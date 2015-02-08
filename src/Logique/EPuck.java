package Logique;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import InterfaceControleurIHM.ControleDuRobotEPuck;

/**
 * Classe modélisant le robot ePuck. On peut lui envoyer des ordres.
 * @author Maxime
 *
 */
public class EPuck implements ControleDuRobotEPuck 
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
	
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#avancerToutDroit(int)
	 */
	@Override
	public void avancerToutDroit(int vitesse)
	{
		try{
			out.write((EpuckOrder.AVANCERTOUTDROIT+","+vitesse+","+vitesse+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (avancer)"); e.printStackTrace();}
	}
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#avancerToutDroit(int, int)
	 */
	@Override
	public void avancerToutDroit(int vitesse, int distance)
	{
		
	}
	
	
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#toupie(int)
	 */
	@Override
	public void toupie(int vitesse)
	{
		try{
			out.write((EpuckOrder.TOUPIE+","+vitesse+","+(-vitesse)+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (toupie)"); e.printStackTrace();}
	}
	
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#aide()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#stop()
	 */
	@Override
	public void stop()
	{
		try{
			out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
		}
		catch (IOException e) {System.out.println("Problème sortie (stop)"); e.printStackTrace();}
	}
	
	/* (non-Javadoc)
	 * @see Logique.ControleDuRobotEPuck#AfficherValeurCapteur()
	 */
	@Override
	public void AfficherValeurCapteur()
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
}
