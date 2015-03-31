package Logique;
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
import Mash.TramesMASH;

/**
 * Classe modélisant le robot ePuck. On peut lui envoyer des ordres.
 * @author Maxime/ it's me Héloïse
 */
public class EPuck implements ObservableEpuck
{
	private InputStream in;
	private OutputStream out;
	private BufferedReader br;
	private List<ObservateurEPuck> listeObservateur;
	
	/**
	 * Constructeur
	 * @param in Le flux d'entrée d'un port lié au robot
	 * @param out Le flux de sortie d'un port lié au robot
	 * @param br Le tampon de flux
	 */
	public EPuck(InputStream in, OutputStream out)
	{
		this.listeObservateur=new ArrayList<ObservateurEPuck>();
		this.in=in;
		this.out=out;
		try 
		{
			this.br= new BufferedReader(new InputStreamReader(in, "US-ASCII"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			System.out.println("Problème création robot");
			e.printStackTrace();
		}
	}
	
	
	/*Avec vitesse par defaut*/
	public void avancer()
	{
		try
		{
			out.write((EpuckOrder.AVANCERTOUTDROIT+",500,500\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (avancer)"); e.printStackTrace();}
	}
	
	public void reculer()
	{
		try
		{
			out.write((EpuckOrder.AVANCERTOUTDROIT+",-500,-500\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (avancer)"); e.printStackTrace();}
	}
	
	/**
	 * Toupie vers la droite
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void tournerDroite()
	{
		try{
			out.write((EpuckOrder.TOUPIE+",100,-100\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
 
	/**
	 * Toupie vers la gauche
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void tournerGauche()
	{
		try{
			out.write((EpuckOrder.TOUPIE+",-100,100\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/*Avec parametre de vitesse*/

	/**
	 * Toupie vers la droite
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void toupieDroite(int vitesse)
	{
		try
		{
			out.write((EpuckOrder.TOUPIE+","+vitesse+","+(-vitesse)+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/**
	 * Toupie vers la gauche
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void toupieGauche(int vitesse)
	{
		try
		{
			out.write((EpuckOrder.TOUPIE+","+(-vitesse)+","+vitesse+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/**
	 * AvancerToutDroit
	 * Permet d'avancer en ligne droite (vers l'avant ou l'arrière)
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO).
	 * Si la vitesse est négative, le robot recule.
	 */
	public void avancerToutDroit(int vitesse)
	{
		try
		{
			out.write((EpuckOrder.AVANCERTOUTDROIT+","+vitesse+","+vitesse+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (avancer)"); e.printStackTrace();}
	}
	
	/**
	 * Aide, TODO : masquer erreur
	 * Permet d'afficher l'aide fournie par le robot
	 */
	public void aide()
	{
		boolean premièreligne = false; 
		try
		{
			out.write((EpuckOrder.AIDE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (aide)"); e.printStackTrace();}
		
		try
		 {
			String line = "";
				 while(true)
				 {
					line = br.readLine();
					if(line == null)
					 {
						 break;
					 }
					 System.out.println(line);
				}
			
		 }
		catch (IOException e) {System.out.println("Problème lecture (aide)");e.printStackTrace();} //catch (InterruptedException e) {e.printStackTrace();}
		
		
	}
	
	
	/*Stop*/
	public void stop()
	{
		try{
			out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (stop)"); e.printStackTrace();}
	}
	
	/**
	 * Afficher valeur de proximite
	 * Entree:void
	 * Sortie:void
	 * Affiche la valeur des capteur infrarouge
	 * */
	public void afficherValeurCapteur()
	{
		try
		{
			out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
		
		try
		 {
			if(br.ready())
			 {
				System.out.println(br.readLine());
			 }
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     } 
	}
	
	/**
	 * Obtenir valeur de proximite
	 * Entree:void
	 * Sortie : tableau d'entier
	 * Affiche la valeur des capteur infrarouge
	 * */
	public int[] obtenirValeurCapteur()
	{
		try
		{
			out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
		
		try
		 {
			if(br.ready())
			 {
				String chaineValeurCapteur[]= br.readLine().split(",");
				int[] tableauValeurCapteur = new int[chaineValeurCapteur.length];
				for(int i=1; i<chaineValeurCapteur.length; i++)
					tableauValeurCapteur[i]=Integer.parseInt(chaineValeurCapteur[i]);
				return tableauValeurCapteur;
			 }
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     }
		return null; 
	}
	
	/**
	 * Obtenir valeur de accélérometre
	 * Entree:void
	 * Sortie : tableau d'entier
	 * renvoie les valeurs de l'accerometre
	 * */	
	public int[] obtenirValeurAccelerometre()
	{
		try
		{
			out.write((EpuckOrder.ACCELEROMETRE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
		
		try
		 {
			if(br.ready())
			 {
				String chaineValeurAccelerometre[]= br.readLine().split(",");
				int[] tableauValeurAccelerometre = new int[chaineValeurAccelerometre.length];
				for(int i=1; i<chaineValeurAccelerometre.length; i++)
					tableauValeurAccelerometre[i]=Integer.parseInt(chaineValeurAccelerometre[i]);
				return tableauValeurAccelerometre;
			 }
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     }
		return null; 
	}

	/**
	 * Obtenir coordonnée et placer sur la carte
	 * Entree:void
	 * Sortie : 
	 * */
	public int[] deplacementCartographier()
	{
		/*Voir groupe 2 pour reccuoperer les coordonnée*/

		//TODO notifier les observateurs
		try
		 {
			if(br.ready())
			 {
				
				String chaineValeur[]= br.readLine().split(",");
				if(chaineValeur[0].equals("X"))
				{
					int[] chaineValeurCarte = new int[chaineValeur.length];
					chaineValeurCarte[0]=-1;
					chaineValeurCarte[1]=Integer.parseInt(chaineValeur[1]);
					chaineValeurCarte[2]=Integer.parseInt(chaineValeur[2]);
					return chaineValeurCarte;
				}
				
			 }
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     }
		return null; 
	}
		
	public int[] envoieTramesMash()
	{


		/*reçois la trâme MASH*/
		/*evalue en tête*/
		/*envoie commande sur robots*/
		/*attend réponse*/
		/*renvoie vers MASH*/
		return null;
	}
	public int[]reçoisTramesMash()
	{

		/*écoute si reçois des demandes de position*/
		/*evalue en tête*/
		/*renvoie information au robot*/
		return null;
	}


	@Override
	public void ajouterObserver(ObservateurEPuck o) {
		System.out.println("observateur ajouté");
		this.listeObservateur.add(o);
	}


	@Override
	public void notifierObserver(double x, double y) {
		System.out.println("Je rentre dans la méthode notifierObserver");
		for(ObservateurEPuck obs : listeObservateur)
		{
			System.out.println("Je lance actualiser");
			obs.actualiser( x,  y);
		}
		
	}


	@Override
	public void supprimerObserver(ObservateurEPuck o) {
		this.listeObservateur.remove(o);
		
	}
	
	public void courbe(double vitesseRg, double vitesseRd)
	{
		try
		{
			out.write((EpuckOrder.AVANCERTOUTDROIT+","+vitesseRg+","+vitesseRd+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (courbe)"); e.printStackTrace();}
	}


	@Override
	public void notifierObserver(TramesMASH trame) {
		// TODO Auto-generated method stub
		
	}
	
}
