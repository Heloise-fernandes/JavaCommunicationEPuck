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
	ACCELEROMETRE("A");
	
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
