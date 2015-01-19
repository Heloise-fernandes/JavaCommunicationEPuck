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
		try {
			this.br= new BufferedReader(new InputStreamReader(in, "US-ASCII"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Problème création robot");
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet d'avancer en ligne droite (vers l'avant ou l'arrière)
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO).
	 * Si la vitesse est négative, le robot recule.
	 */
	public void avancerToutDroit(int vitesse)
	{
		try{
			out.write((EpuckOrder.AVANCERTOUTDROIT+","+vitesse+","+vitesse+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (avancer)"); e.printStackTrace();}
	}
	
	
	/**
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public void toupie(int vitesse)
	{
		try{
			out.write((EpuckOrder.TOUPIE+","+vitesse+","+(-vitesse)+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/**
	 * Permet d'afficher l'aide fournie par le robot
	 */
	public void aide()
	{
		try{
			out.write((EpuckOrder.AIDE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (aide)"); e.printStackTrace();}
		
		try
		 {
			//Thread.sleep(500);
			 while(in.read()>0)
			 {
				 System.out.println(br.readLine());
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
	public void AfficherValeurCapteur()
	{
		try
		{
			out.write((EpuckOrder.AIDE+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
		
		
		try
		 {
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "US-ASCII"));
			Thread.sleep(500);
			while (in.read()>0)
			{
			 System.out.println(br.readLine());
			}
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     } catch (InterruptedException e) {
			// TODO Auto-generated catch block
	    	 
	    	System.out.println("Problème lecture (aide)");
			e.printStackTrace();
		}
	}
}
