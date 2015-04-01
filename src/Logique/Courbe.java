package Logique;

/**
 * Classe permettant de calculer les vitesses des deux roues afin d'effetuer un cercle
 * @author Maxime
 *
 */
public class Courbe
{
	public final static double DIAMETRE_ROUE_CM= 41.0 ;
	public final static int DIAMETRE_ROUE_PAS=390;
	
	//calcule autre groupe : environ 51 mm
	public final static double ECARTEMENT_ENTRE_ROUES = ((Math.PI*DIAMETRE_ROUE_CM)/1000)*400;
	public final static double UN_PAS = (2*Math.PI*(DIAMETRE_ROUE_CM/2))/1000;
	//site : environ 53 mm
	
	private double rayonDeCourbure;
	private double vitesse;
	
	/**
	 * Constructeur
	 * @param rayonDeCourbure en pas
	 * @param vitesse en pas/s
	 */
	public Courbe(double rayonDeCourbure, int vitesse)
	{
		this.rayonDeCourbure=rayonDeCourbure;
		this.vitesse=vitesse;
		
	}
	
	/**
	 * Permet de calculer la vitesse de la roue gauche. On la met en entier car le robot ne peut pas prendre des nombre
	 * à virgule
	 * @return la vitesse de la roue gauche
	 */
	public int obtenirVitesseRoueGauche()
	{
		Double d = (this.rayonDeCourbure-(DIAMETRE_ROUE_PAS/2))*(vitesse/rayonDeCourbure);
		return d.intValue();
	}
	
	/**
	 * Permet de calculer la vitesse de la roue droite. On la met en entier car le robot ne peut pas prendre des nombre
	 * à virgule
	 * @return la vitesse de la roue droite
	 */
	public int obtenirVitesseRoueDroite()
	{
		Double d = (this.rayonDeCourbure+(DIAMETRE_ROUE_PAS/2))*(vitesse/rayonDeCourbure);
		return d.intValue();
	}
}
