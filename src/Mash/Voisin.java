package Mash;

import java.math.BigInteger;

public class Voisin 
{
	private int adresseVoisin;
	private int coordonneeX;
	private int coordonneeY;
	private int role;
	
	public Voisin(int id,int x, int y , int r)
	{
		this.adresseVoisin = id;
		this.coordonneeX=x;
		this.coordonneeY=y;
		this.role=r;
	}
	
	public String toHexaString()
	{
		String infoVoisin = Integer.toHexString(this.adresseVoisin);
		infoVoisin= infoVoisin + Integer.toHexString(this.coordonneeX);
		infoVoisin= infoVoisin + Integer.toHexString(this.coordonneeY);
		infoVoisin= infoVoisin+Integer.toHexString(this.role);
		return infoVoisin;
	}
	
	public int valeurVoisin()
	{
		return this.adresseVoisin+this.coordonneeX+this.coordonneeY+this.role;
	}
	
}
