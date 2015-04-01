package Logique;

public class Courbe
{
	public final static double DIAMETRE_ROUE = 41.0 ;
	
	//calcule autre groupe : environ 51 mm
	public final static double ECARTEMENT_ENTRE_ROUES = ((Math.PI*DIAMETRE_ROUE)/1000)*400;
	public final static double UN_PAS = (2*Math.PI*(DIAMETRE_ROUE/2))/1000;
	//site : environ 53 mm
	
	private double rayonDeCourbure;
	private double vitesse;
	
	public Courbe(double rayonDeCourbure, int vitesse)
	{
		this.rayonDeCourbure=rayonDeCourbure;
		this.vitesse=vitesse*UN_PAS;
		
	}
	
	public double obtenirVitesseRoueGauche()
	{
		return (this.rayonDeCourbure-(ECARTEMENT_ENTRE_ROUES/2))*(vitesse/rayonDeCourbure);
	}
	
	public double obtenirVitesseRoueDroite()
	{
		return (this.rayonDeCourbure+(ECARTEMENT_ENTRE_ROUES/2))*(vitesse/rayonDeCourbure);
	}
}
