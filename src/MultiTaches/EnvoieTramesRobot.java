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
	
	public void envoieOrdre(String[] l)
	{
		try
		{
			System.out.println(l[0]+","+l[1]+","+l[2]);
			if(l[0].equals(EpuckOrder.ACCELEROMETRE.toString()))
				out.write((EpuckOrder.ACCELEROMETRE+"\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.PROXIMITE.toString()))
				out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.ARRETER.toString()))
				out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.AVANCERTOUTDROIT.toString()))
				out.write((EpuckOrder.AVANCERTOUTDROIT+","+l[1]+","+l[2]+"\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.TOUPIE.toString()))
				out.write((EpuckOrder.TOUPIE+","+l[1]+","+l[2]+"\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.TOURNERGACHE.toString()))
				out.write((EpuckOrder.TOUPIE+",-100,100\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.TOURNERDROITE.toString()))
				out.write((EpuckOrder.TOUPIE+",100,-100\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.AVANCERVALEURDEFAUT.toString()))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",500,500\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.RECULER.toString()))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",-500,-500\n\r").getBytes("US-ASCII"));
			
			else if(l[0].equals(EpuckOrder.DEPLACEMENTPARCOORDONNEE.toString()))
				out.write(("?,"+l[1]+","+l[2]+"\n\r").getBytes("US-ASCII"));	
			else 
				System.out.println("tab pas trouvé ordre");
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
	}


	public void envoieOrdre(EpuckOrder ordre, int v, int x,int y)
	{
		try
		{
			if(ordre.equals(EpuckOrder.ACCELEROMETRE))
				out.write((EpuckOrder.ACCELEROMETRE+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.PROXIMITE))
				out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.ARRETER.toString()))
				out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.AVANCERTOUTDROIT))
				out.write((EpuckOrder.AVANCERTOUTDROIT+","+v+","+v+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.TOUPIE.toString()))
				out.write((EpuckOrder.TOUPIE+","+(-v)+","+v+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.TOURNERGACHE))
				out.write((EpuckOrder.TOUPIE+",-100,100\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.TOURNERDROITE))
				out.write((EpuckOrder.TOUPIE+",100,-100\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.AVANCERVALEURDEFAUT))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",500,500\n\r").getBytes("US-ASCII"));
			
			else if(ordre.equals(EpuckOrder.RECULER))
				out.write((EpuckOrder.AVANCERTOUTDROIT+",-500,-500\n\r").getBytes("US-ASCII"));
			else 
				System.out.println("param pas trouvé ordre");
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
	}
	

	public void envoieOrdre(EpuckOrder ordre, int x, int y) 
	{

			try 
			{
				if(ordre.equals(EpuckOrder.COURBE))
					out.write((EpuckOrder.COURBE+","+x+","+y+"\n\r").getBytes("US-ASCII"));
				else if(ordre.equals(EpuckOrder.DEPLACEMENTPARCOORDONNEE))
					out.write((EpuckOrder.DEPLACEMENTPARCOORDONNEE+"\n\r").getBytes("US-ASCII"));
				else
					System.out.println("Pas trouvé");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
