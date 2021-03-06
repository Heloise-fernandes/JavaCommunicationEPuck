package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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


public class LecteurTramesMASH extends Thread 
{
	
	private InputStream in;
	private BufferedReader br;
	private EpuckAvecThread robot;
	
	public LecteurTramesMASH (String name, InputStream i,EpuckAvecThread r)
	{
		super(name);

		this.in = i;
		this.robot=r;
		try 
		{
			this.br = new BufferedReader(new InputStreamReader(in, "US-ASCII"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			System.out.println("Problème création robot");
			e.printStackTrace();
		}
	}
	
	public void run()
	{

		System.out.println("MASh : je suis pret");
		
		while(true)
		{
			try
			 {
				if(br.ready())
				{
					System.out.println("MASH : je lit une trames du mash");
					String line = "";
					System.out.println("MASH : "+line);
					line = br.readLine();
					if(line == null)
					{
						System.out.println("probleme");
						break;
					}
					 
					if(line.equals("\n"))
						break;
					System.out.println("MASH : "+line);
					this.robot.envoieCommande(line);
					  
				}
				
			 }
			 catch (IOException e) 
			 {
				 System.out.println("Problème entrée");

		     }
	    }
		System.out.println("fin");
					
	}
	
	
}
