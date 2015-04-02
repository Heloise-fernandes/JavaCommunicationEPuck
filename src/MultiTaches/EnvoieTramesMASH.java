package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import Logique.EpuckOrder;

public class EnvoieTramesMASH extends Thread 
{
	private OutputStream out;

	
	public EnvoieTramesMASH(String name, OutputStream o)
	{
		super(name);

		this.out = o;
	}

	public void redirectionTrames(String chaineretour) 
	{
		try
		{
			System.out.println("MASH : "+chaineretour);
			out.write((chaineretour).getBytes("US-ASCII"));
		}
		catch (IOException e) 
		{
			System.out.println("Problème sortie (aide)"); 
			e.printStackTrace();
		}
	}

}
