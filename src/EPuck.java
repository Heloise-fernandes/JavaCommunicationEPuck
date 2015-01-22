import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe modélisant le robot ePuck. On peut lui envoyer des ordres.
 * @author Maxime
 *
 */
public class EPuck 
{
	private InputStream in;
	private OutputStream out;
	private BufferedReader br;
	
	/**
	 * Constructeur
	 * @param in Le flux d'entrée d'un port lié au robot
	 * @param out Le flux de sortie d'un port lié au robot
	 */
	public EPuck(InputStream in, OutputStream out)
	{
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

	public void tournerDroite()
	{
		try{
			out.write((EpuckOrder.TOUPIE+",100,-100\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
 
	public void tournerGauche()
	{
		try{
			out.write((EpuckOrder.TOUPIE+",-100,100\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/**
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void toupieDroite(int vitesse)
	{
		try{
			out.write((EpuckOrder.TOUPIE+","+vitesse+","+(-vitesse)+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
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
	 * TODO
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
			if(br.ready())
			{ 
				 while(true)
				 {
					if(br.ready()==false)
					 {
						 break;
					 }
					 System.out.println(br.readLine());
				}
			 }
		 }
		catch (IOException e) {System.out.println("Problème lecture (aide)");e.printStackTrace();} //catch (InterruptedException e) {e.printStackTrace();}
		
		
	}
	
	public void stop()
	{
		try{
			out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (stop)"); e.printStackTrace();}
	}
	
	/**
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

}
