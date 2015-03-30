package Mash;
/**
import java.util.ArrayList;

public class InformationsDonneesVoisinPercu implements InformationsTramesMASH
{

	
	
	public static final int OCTETS_POSITION_FONCTION = 8;
	public static final int OCTETS_TAILLE_FONCTION  = 2;
	
	public static final int OCTETS_POSITION_SS_FONCTION = 10;
	public static final int OCTETS_TAILLE_SS_FONCTION  = 2;

	public static final int OCTETS_POSITION_DEBUT_DONNEES = 12;
	public static final int OCTETS_POSITION_FIN_DONNEES = -8;
	
	public static final int FONCTION = 1;
	public static final int SS_FONCTION = 1;
	
	public final static String OCTETS_FONCTION_SS_FONCTION_RETOUR = "0201";
	
	
	private String fonction;
	private String sousfonction;
	private String data;

	private ArrayList<Voisin> vListe;
	

	
	public InformationsDonneesVoisinPercu(String info) 
	{
		super();
		this.fonction= info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_FONCTION);
		this.sousfonction= info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION);
		this.data= info.substring(OCTETS_POSITION_DEBUT_DONNEES, info.length()+OCTETS_POSITION_DEBUT_DONNEES);
	}
	
	public String envoieChainePourRobot()
	{
		String chaineAEnvoyer = "";
		chaineAEnvoyer = chaineAEnvoyer+this.fonction+",";
		chaineAEnvoyer = chaineAEnvoyer+this.sousfonction+",";
		chaineAEnvoyer = chaineAEnvoyer+Integer.parseInt(this.data,16);
		
		return chaineAEnvoyer;
	}
	
	public void retourTrameRobots(String info) 
	{
		for (int i=4; i<info.length();i=i+20) 
		{
			this.vListe.add(new Voisin(Integer.parseInt(info.substring(i, i+6)),Integer.parseInt(info.substring(i+6, i+12)),Integer.parseInt(info.substring(i+12, i+8)),Integer.parseInt(info.substring(i+18, i+20))));
		}
	}

	public String reconstitutionInformationTrameMASH()
	{
		String information=OCTETS_FONCTION_SS_FONCTION_RETOUR;
		for(int i = 0; i< this.vListe.size();i++)
			information=information+this.vListe.get(i).toHexaString();
		return information;
	}
	
	public int valeurTrameRetour()
	{
		int valeur=0;
		for(int i = 0 ;i<this.vListe.size();i++ )
		{
			valeur = valeur + this.vListe.get(i).valeurVoisin();
		}
		valeur = valeur+FONCTION+SS_FONCTION;
		return valeur;
	}
	
	
}*/
