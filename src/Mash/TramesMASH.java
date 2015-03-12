package Mash;

public class TramesMASH
{

		public static final int OCTET_POSITION_EN_TETE = 0;
		public static final int OCTET_TAILE_EN_TETE = 4;
		
		public static final int OCTETS_POSITION_TAILLE_INFO = 4;
		public static final int OCTETS_TAILLE_TAILLE_INFO = 4;
	
		public static final int OCTETS_POSITION_FONCTION = 8;
		public static final int OCTETS_TAILLE_FONCTION  = 2;
		
		public static final int OCTETS_POSITION_SS_FONCTION = 10;
		public static final int OCTETS_TAILLE_SS_FONCTION  = 2;
		
		public static final int OCTETS_POSITION_CKSUM = -8;
		public static final int OCTETS_TAILLE_CKSUM = 4;
		
		public static final int OCTETS_POSITION_EN_QUEUE = -4;
		
		public static final String BIT_DONNEE_0_1 = "01";
		public static final String BIT_DONNEE_0_2 = "02";
				
	    String enTete;
		String tailleInfo;
		InformationsTramesMASH donnees;
		String chekSum;
		String enQueue;	
	
		
		public TramesMASH(String info)
		{
			
			
			this.enTete = info.substring(OCTET_POSITION_EN_TETE, OCTET_POSITION_EN_TETE+OCTET_TAILE_EN_TETE);
			this.tailleInfo = info.substring(OCTETS_POSITION_TAILLE_INFO, OCTETS_POSITION_TAILLE_INFO+OCTETS_TAILLE_TAILLE_INFO);
			this.chekSum=info.substring(info.length()+OCTETS_POSITION_CKSUM, info.length()+OCTETS_POSITION_CKSUM+OCTETS_TAILLE_CKSUM);
			this.enQueue=info.substring(info.length()+OCTETS_POSITION_EN_QUEUE, info.length());
		
			
			if (info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_FONCTION).equals(BIT_DONNEE_0_1))
			{
				if (info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION).equals(BIT_DONNEE_0_1))
				{
					this.donnees = new InformationsDonneesVoisin(info);
				}
				else
				{
					this.donnees = new InformationsDonneesVoisinPercu(info);
				}
			}
				
		}
		
		public void TramesMASHEncapsulation(String tramesRecu)
		{
		
			if (tramesRecu.substring(0).equals("2"))
			{
				if (tramesRecu.substring(1).equals("1"))
				{
					//TODO
				}
				else
				{
					//TODO
				}
			}
				
		}
}
