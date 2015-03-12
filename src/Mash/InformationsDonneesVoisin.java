package Mash;

public class InformationsDonneesVoisin implements InformationsTramesMASH 
{


	public static final int OCTETS_POSITION_FONCTION = 8;
	public static final int OCTETS_TAILLE_FONCTION  = 2;
	
	public static final int OCTETS_POSITION_SS_FONCTION = 10;
	public static final int OCTETS_TAILLE_SS_FONCTION  = 2;

	public static final int OCTETS_POSITION_DEBUT_DONNEES = 12;
	public static final int OCTETS_POSITION_FIN_DONNEES = -8;
	
	public static final int OCTETS_POSITION_FONCTION_ROBOT = 0;
	public static final int OCTETS_TAILLE_FONCTION_ROBOT  = 2;
	
	public static final int OCTETS_POSITION_SS_FONCTION_ROBOT = 2;
	public static final int OCTETS_TAILLE_SS_FONCTION_ROBOT  = 2;

	public static final int OCTETS_POSITION_DEBUT_DONNEES_ROBOT = 4;
	public static final int OCTETS_POSITION_FIN_DONNEES_ROBOT = 6;
	
	
	
	public final static String OCTETS_FONCTION_SS_FONCTION_RETOUR = "0201";
	
	
	private String fonction;
	private String sousfonction;
	private String data;
	private Voisin voisin;
	
	public InformationsDonneesVoisin(String info) 
	{
		this.fonction= info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_FONCTION);
		this.sousfonction= info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION);
		this.data= info.substring(OCTETS_POSITION_DEBUT_DONNEES, info.length()+OCTETS_POSITION_DEBUT_DONNEES);
	}
	
	/*Envoie la chaine de demande de recherche robot par id, id en base 10*/
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
		this.voisin= new Voisin(info.substring(OCTETS_POSITION_DEBUT_DONNEES_ROBOT, OCTETS_POSITION_DEBUT_DONNEES_ROBOT+6),Integer.parseInt(info.substring(OCTETS_POSITION_DEBUT_DONNEES_ROBOT+6, OCTETS_POSITION_DEBUT_DONNEES_ROBOT+12)),Integer.parseInt(info.substring(OCTETS_POSITION_DEBUT_DONNEES_ROBOT+18, OCTETS_POSITION_DEBUT_DONNEES_ROBOT+24)),info.substring(OCTETS_POSITION_DEBUT_DONNEES_ROBOT+24, info.length()));
	}
	
	public String reconstitutionInformationTrameMASH()
	{
		String information=OCTETS_FONCTION_SS_FONCTION_RETOUR;
		information=information+this.voisin.toHexaString();
		return information;
	}


}
