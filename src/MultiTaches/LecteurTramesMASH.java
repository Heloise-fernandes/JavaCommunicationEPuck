package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import Logique.SerialPortConnexion;


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
				String line = "";
				 if(br.ready()) 
				 {
					line = br.readLine();
					this.robot.renvoieDonneRecu(line);
					
				 }
		}
		catch (IOException e) {System.out.println("Problème lecture (aide)");} 
		

	}
	
	
}
