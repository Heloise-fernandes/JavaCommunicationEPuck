package Mash;

import java.util.ArrayList;

public class GestionnaireTramesMashEtRobots 
{
	
	private ArrayList<InformationsTramesMASH> trameRecuMASH;
	private ArrayList<InformationsTramesMASH> trameRecuRobot;

	
	public GestionnaireTramesMashEtRobots()
	{
		this.trameRecuMASH = new ArrayList<InformationsTramesMASH>();
		this.trameRecuRobot = new ArrayList<InformationsTramesMASH>();

	}
	
	
	public void ajouterTrameMashRecu(String trame)
	{
		/*TODO*/
		
		if (trame.substring(16, 20).equals("0x01"))
		{
			if (trame.substring(20, 24)=="0x01")
			{
				this.ajouterTrameMashRecuDemandeDonneVoisin(trame);
			}
			else
			{
				this.ajouterTrameMashRecuDemandeDonneVoisinPercu(trame);
			}
		}
	}


	private  void ajouterTrameMashRecuDemandeDonneVoisinPercu(String trame) 
	{
		this.trameRecuMASH.add(new InformationsDonneesVoisinPercu(trame));
		
	}


	private void ajouterTrameMashRecuDemandeDonneVoisin(String trame) 
	{
		this.trameRecuMASH.add(new InformationsDonneesVoisin(trame));
		
	}
}
