package Logique;

public class Courbe
{
	public final static double DIAMETRE_ROUE = 41.0 ;
	public final static double ECARTEMENT_ENTRE_ROUES = ((Math.PI*DIAMETRE_ROUE)/1000)*400;
	private double rayonDeCourbure;
	private double vitesse;
	
	public Courbe(double rayonDeCourbure, int vitesse)
	{
		this.rayonDeCourbure=rayonDeCourbure;
		this.vitesse=vitesse;
		
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
