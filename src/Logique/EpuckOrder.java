package Logique;
/**
 * Classe permettant d'avoir les ordres en commande epuck
 * @author Maxime
 *
 */
public enum EpuckOrder {

	AVANCERTOUTDROIT("D"),
	ARRETER("S"),
	AIDE("H"),
	TOUPIE("D"),
	PROXIMITE("N"),
	ACCELEROMETRE("A"),
	AVANCERVALEURDEFAUT("AD"),
	RECULER("RD"),
	TOURNERDROITE("DD"),
	TOURNERGACHE("DG"),
	DEPLACEMENTPARCOORDONNEE("?"), 
	COURBE("D");
	
	private final String ordre;
	
	private EpuckOrder(String ordre)
	{
		this.ordre=ordre;
	}
	
	@Override
	public String toString()
	{
		return ordre;
	}
}
