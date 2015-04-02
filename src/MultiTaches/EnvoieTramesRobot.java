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
			{
				
				out.write(("t,"+l[1]+","+l[2]+"\n\r").getBytes("US-ASCII"));
			}
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
			if(ordre==EpuckOrder.ACCELEROMETRE)
				out.write((EpuckOrder.ACCELEROMETRE+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.PROXIMITE)
				out.write((EpuckOrder.PROXIMITE+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.ARRETER)
				out.write((EpuckOrder.ARRETER+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.AVANCERTOUTDROIT)
				out.write((EpuckOrder.AVANCERTOUTDROIT+","+v+","+v+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.TOURNERGACHE)
				out.write((EpuckOrder.TOURNERGACHE+","+-v+","+v+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.TOURNERDROITE)
				out.write((EpuckOrder.TOURNERDROITE+","+v+","+(-v)+"\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.AVANCERVALEURDEFAUT)
				out.write((EpuckOrder.AVANCERVALEURDEFAUT+",500,500\n\r").getBytes("US-ASCII"));
			
			else if(ordre==EpuckOrder.RECULER)
				out.write((EpuckOrder.RECULER+","+(-v)+","+(-v)+"\n\r").getBytes("US-ASCII"));
			else 
				System.out.println("param pas trouvé ordre");
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie "); 
			e.printStackTrace();
		}
	}
	

	public void envoieOrdre(EpuckOrder ordre, int x, int y) 
	{

			try 
			{
				if(ordre==EpuckOrder.COURBE)
					out.write((EpuckOrder.COURBE+","+x+","+y+"\n\r").getBytes("US-ASCII"));
				else if(ordre==EpuckOrder.DEPLACEMENTPARCOORDONNEE)
				{
					System.out.println(EpuckOrder.DEPLACEMENTPARCOORDONNEE+","+x+","+y+"\n\r");
					out.write((EpuckOrder.DEPLACEMENTPARCOORDONNEE+","+x+","+y+"\n\r").getBytes("US-ASCII"));
				}
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
