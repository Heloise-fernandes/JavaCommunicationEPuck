package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LecteurTramesRobot extends Thread 
{
	private InputStream in;
	private BufferedReader br;
	EpuckAvecThread epuck;
	
	public LecteurTramesRobot(String name, InputStream i,EpuckAvecThread r )
	{
		super(name);

		this.in = i;
		this.epuck=r;
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
	

	public void run()
	{
		try
		 {
			if(br.ready())
			 {
				this.epuck.renvoieDonneRecu(br.readLine());
			 }
		 }
		 catch (IOException e) 
		 {
			 System.out.println("Problème entrée (aide)");
			 e.printStackTrace();
	     }
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
