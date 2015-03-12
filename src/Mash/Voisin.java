package Mash;

import java.math.BigInteger;

public class Voisin 
{
	private String adresseVoisin;
	private int coordonneeX;
	private int coordonneeY;
	private String role;
	
	public Voisin(String id,int x, int y , String r)
	{
		this.adresseVoisin = id;
		this.coordonneeX=x;
		this.coordonneeY=y;
		this.role=r;
	}
	
	public String toHexaString()
	{
		String infoVoisin= String.format("%06x", new BigInteger(1, this.adresseVoisin.getBytes()));
		infoVoisin= infoVoisin+String.format("%06x", new BigInteger(1, Integer.toString(this.coordonneeX).getBytes()));
		infoVoisin= infoVoisin+String.format("%06x", new BigInteger(1, Integer.toString(this.coordonneeY).getBytes()));
		infoVoisin= infoVoisin+String.format("%02x", new BigInteger(1, this.role.getBytes()));
		return infoVoisin;
	}
	
	
	
}
