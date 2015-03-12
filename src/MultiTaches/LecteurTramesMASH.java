package MultiTaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import Logique.SerialPortConnexion;
import Mash.GestionnaireTramesMashEtRobots;
import Mash.InformationsDonneesVoisin;
import Mash.InformationsDonneesVoisinPercu;

public class LecteurTramesMASH extends Thread 
{
	
	private SerialPortConnexion portLecture;
	private InputStream in;
	private BufferedReader br;
	private GestionnaireTramesMashEtRobots gestionListe;

	
	public LecteurTramesMASH (String name, String port)
	{
		super(name);
		this.portLecture = new SerialPortConnexion(port);
		this.portLecture.ouvrirPort();
		this.gestionListe = new GestionnaireTramesMashEtRobots();
		
		this.in = this.portLecture.obtenirConnexionEntree();
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
		
		/*Tant que le processus fonctionne il lit dans le buffer*/
		while(true)
		{
			try
			 {
				String line = "";
				/*Si le buffer n'est pas vide on lit sinon on attend */
				 if(br.ready()) 
				 {
					 /*On lit jusqu'à ce que le buffer soit vide*/
					 while(true)
					 {
						line = br.readLine();
						if(line == null)
						 {
							 break;/*buffer vide*/
						 }
					    gestionListe.ajouterTrameMashRecu(line);
					}
				 }
			 }
			catch (IOException e) {System.out.println("Problème lecture (aide)");} 
		}

	}
	
	
}
