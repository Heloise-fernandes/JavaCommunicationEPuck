package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import Logique.EpuckOrder;
import Logique.SerialPortConnexion;
import Mash.TramesMASH;


public class EpuckAvecThread 
{
	
		
	    private int identifiant;

		private EnvoieTramesRobot envoieTramesRobot;
		private LecteurTramesRobot lecteurTramesRobot;
		private EnvoieTramesMASH envoieTramesMASH;
		private LecteurTramesMASH lecteurTramesMASH;
		private SerialPortConnexion port1;
		private SerialPortConnexion port;

		public EpuckAvecThread(int i, SerialPortConnexion p, SerialPortConnexion p1)
		{
			this.port=p;
			this.port1=p1;
			this.identifiant = 80+i; 			
		}
		

		public void start()
		{
			this.port.ouvrirPort();
			this.port1.ouvrirPort();
			//this.envoieTramesRobot = new EnvoieTramesRobot("retourTramesRobot", port.obtenirConnexionSortie());
			this.lecteurTramesRobot = new LecteurTramesRobot("lecteurTrameRobot",port.obtenirConnexionEntree(), this);
			this.envoieTramesMASH = new EnvoieTramesMASH("EnvoieTramesMASH", port1.obtenirConnexionSortie());
			//this.lecteurTramesMASH = new LecteurTramesMASH("lecteurTramesMASH",port1.obtenirConnexionEntree(), this);
			this.lecteurTramesRobot.run();
		}
		
		
		public void close()
		{
			this.port.fermerPort();
			this.port1.fermerPort();
		}
		
		
		public void trasfereDesDonneesRecusVersMash(String chaineretour)
		{
			TramesMASH trame = new TramesMASH(chaineretour);
			
			if(trame.getDonne().getData().substring(0,2).equals("co"))
				//notify
				System.out.println("A notifier");
			this.envoieTramesMASH.redirectionTrames(chaineretour);
			System.out.println(trame);
		}
		
		
		public void envoieDOrdreAuRobot(EpuckOrder o, int i,int x,int y)
		{
			this.envoieTramesRobot.envoieOrdre(o, i,x ,y);
		}
		
		public void envoieCommande(String commande)
		{
			TramesMASH trame = new TramesMASH(commande);
			
			this.envoieTramesRobot.envoieOrdre(trame.getDonne().getData());
		}



}
