package MultiTaches;

import gnu.io.NoSuchPortException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import InterfaceControleurIHM.ObservableEpuck;
import InterfaceControleurIHM.ObservateurEPuck;
import Logique.EpuckOrder;
import Logique.SerialPortConnexion;
import Mash.TramesMASH;


public class EpuckAvecThread implements ObservableEpuck
{
	
		
	    private int identifiant;

		private EnvoieTramesRobot envoieTramesRobot;
		private LecteurTramesRobot lecteurTramesRobot;
		private EnvoieTramesMASH envoieTramesMASH;
		private LecteurTramesMASH lecteurTramesMASH;
		private SerialPortConnexion port1;
		private SerialPortConnexion port;
		private List<ObservateurEPuck> listeObservateur;
		

		public EpuckAvecThread(int i, String p, String p1) throws NoSuchPortException
		{
			
			this.listeObservateur=new ArrayList<ObservateurEPuck>();
			
			this.port= new SerialPortConnexion(p);
			this.port1= new SerialPortConnexion(p1);
			
			this.identifiant = 80+i; 
			
			this.port.ouvrirPort();
			this.port1.ouvrirPort();

			System.out.println("les deux ports sont ouvert\n");
			
			this.envoieTramesRobot = new EnvoieTramesRobot("retourTramesRobot", port.obtenirConnexionSortie());
			this.lecteurTramesRobot = new LecteurTramesRobot("lecteurTrameRobot",port.obtenirConnexionEntree(), this);
			this.envoieTramesMASH = new EnvoieTramesMASH("EnvoieTramesMASH", port1.obtenirConnexionSortie());
			this.lecteurTramesMASH = new LecteurTramesMASH("lecteurTramesMASH",port1.obtenirConnexionEntree(), this);
			
			
			
			System.out.println("thread creer\n");
		}
		

		public void start()
		{
			this.lecteurTramesRobot.start();
			this.lecteurTramesMASH.start();

		}
		
		
		public void close()
		{
			this.port.fermerPort();
			this.port1.fermerPort();
		}
		
		
		public void trasfereDesDonneesRecusVersMash(String chaineretour)
		{
			if(chaineretour.length()>=4)
			{
				if(chaineretour.substring(0,3).equals("01FE"))
				{
					TramesMASH trame = new TramesMASH(chaineretour);
					
					if(trame.getDonne().substring(0).equals("t"))
					{
						this.notifierObserver(trame);
						System.out.println("A notifier");
					}
					this.envoieTramesMASH.redirectionTrames(chaineretour);
				}
				else
				{
					if(chaineretour.substring(0).equals("t"))
					{
						this.notifierObserver(chaineretour);
						System.out.println("A notifier");
					}
				}
			}
			else
			{
				if(chaineretour.substring(0).equals("t"))
				{
					this.notifierObserver(chaineretour);
					System.out.println("A notifier");
				}
			}
			System.out.println(chaineretour);
		}
		
		
		private void notifierObserver(String chaineretour) 
		{
			System.out.println("Je rentre dans la méthode notifierObserver");
			for(ObservateurEPuck obs : this.listeObservateur)
			{
				System.out.println("Je lance actualiser");
				String[] coordonnées = new String[3];
				coordonnées = chaineretour.split(",");
				obs.actualiser(Double.parseDouble(coordonnées[1]),Double.parseDouble(coordonnées[2]));
			}
			
		}


		public void envoieDOrdreAuRobot(EpuckOrder o, int i,int x,int y)
		{
			this.envoieTramesRobot.envoieOrdre(o, i,x ,y);
		}
		
		public void envoieDOrdreAuRobot(EpuckOrder ordre, int x,int y) 
		{
			System.out.println("On retransmet l'ordre");
			this.envoieTramesRobot.envoieOrdre(ordre,x ,y);
		}
		
		public void envoieCommande(String commande)
		{
			TramesMASH trame = new TramesMASH(commande);
			String[] liste = trame.getDonne().split(",");
			
			this.envoieTramesRobot.envoieOrdre(liste);
		}


		@Override
		public void ajouterObserver(ObservateurEPuck o) 
		{
			System.out.println("observateur ajouté");
			this.listeObservateur.add(o);
			
		}


		@Override
		public void notifierObserver(TramesMASH trame) 
		{
			System.out.println("Je rentre dans la méthode notifierObserver");
			for(ObservateurEPuck obs : this.listeObservateur)
			{
				System.out.println("Je lance actualiser");
				String[] coordonnées = new String[3];
				coordonnées = trame.getDonne().split(",");
				obs.actualiser(Double.parseDouble(coordonnées[1]),Double.parseDouble(coordonnées[2]));
			}
			
		}

		@Override
		public void supprimerObserver(ObservateurEPuck o) 
		{
			this.listeObservateur.remove(o);
			
		}


		@Override
		public void notifierObserver(double x, double y) {
			// TODO Auto-generated method stub
			
		}


		


}
