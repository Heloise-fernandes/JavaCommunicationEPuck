package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import Logique.EpuckOrder;

public class EnvoieTramesRobot extends Thread 
{
	private OutputStream out;

	
	public EnvoieTramesRobot(String name, OutputStream o)
	{
		super(name);

		this.out = o;
	}
	
	
	public void run()
	{
		
	}
	
	public void envoieOrdre(EpuckOrder ordre, int v, int x,int y)
	{
		try
		{
			if(ordre.equals(EpuckOrder.ACCELEROMETRE))
				out.write((EpuckOrder.ACCELEROMETRE+"\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.PROXIMITE))
				out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.ARRETER))
				out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.AVANCERTOUTDROIT))
				out.write((EpuckOrder.AVANCERTOUTDROIT+","+v+","+v+"\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.TOUPIE))
				out.write((EpuckOrder.TOUPIE+","+(-v)+","+v+"\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.TOURNERGACHE))
				out.write((EpuckOrder.TOUPIE+",-100,100\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.TOURNERDROITE))
				out.write((EpuckOrder.TOUPIE+",100,-100\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.AVANCERVALEURDEFAUT))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",500,500\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.RECULER))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",-500,-500\n\r").getBytes("US-ASCII"));
			
			if(ordre.equals(EpuckOrder.DEPLACEMENTPARCOORDONNEE))
				out.write(("BLOP BLOP BLOP").getBytes("US-ASCII"));	
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
	}


	public void envoieOrdre(String data) 
	{
		try
		{
			out.write((data).getBytes("US-ASCII"));

		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
		
	}

}
