package Mash;

public class InformationDonneeDefault implements InformationsTramesMASH
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
	
	public static final int FONCTION = 2;
	public static final int SS_FONCTION = 1;
	
	public final static String OCTETS_FONCTION_SS_FONCTION_RETOUR = "0201";
	
	
	private String fonction;
	private String sousfonction;
	private String data;
	private Voisin voisin;
	
	public InformationDonneeDefault(String info) 
	{
		super();
		this.fonction= info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_FONCTION);
		this.sousfonction= info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION);
		this.data= info.substring(OCTETS_POSITION_DEBUT_DONNEES, info.length()+OCTETS_POSITION_FIN_DONNEES);
	}
	
	public String getData()
	{
		return this.data;
	}

}
