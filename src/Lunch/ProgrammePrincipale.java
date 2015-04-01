package Lunch;

import java.math.BigInteger;

import javax.swing.SwingUtilities;

import IHM.*;
import Logique.EPuck;
import Logique.SerialPortConnexion;
import Mash.InformationsTramesMASH;
import MultiTaches.EpuckAvecThread;

public class ProgrammePrincipale 
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

	public static final int OCTETS_POSITION_DEBUT_DONNEES = 12;
	public static final int OCTETS_POSITION_FIN_DONNEES = -8;
	
	public static final String BIT_DONNEE_0_1 = "01";
	public static final String BIT_DONNEE_0_2 = "02";

	
	
	public static void main (String[] args)
	{
		SwingUtilities.invokeLater(new InterfacePrincipale());

				//EpuckAvecThread epuck = new EpuckAvecThread(4, "COM5","COM10" );
				//epuck.start();
				
				
				/*SerialPortConnexion port = new SerialPortConnexion("COM5");
				port.ouvrirPort();
				
				try 
				{
					BufferedReader br = new BufferedReader(new InputStreamReader(port.obtenirConnexionEntree(), "US-ASCII"));
					port.obtenirConnexionSortie().write(("blopblop\n\r").getBytes("US-ASCII"));
					while(true)
					{
						try {
							if(br.ready())
							{
								String line = "";
								
								line = br.readLine();
								if(line == null)
								{
									System.out.println("probleme");
									break;
								}
								 
								if(line.equals("\n"))
									break;
								System.out.println(line);
								
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			
			/*transforme un entier en binaire*/
	}
	
	/*transforme un entier en binaire*/
	
	public static void testchaineHexaV2(String info) 
	{
		
	    String enTete = info.substring(OCTET_POSITION_EN_TETE, OCTET_POSITION_EN_TETE+OCTET_TAILE_EN_TETE);
		String tailleInfo = info.substring(OCTETS_POSITION_TAILLE_INFO, OCTETS_POSITION_TAILLE_INFO+OCTETS_TAILLE_TAILLE_INFO);
		InformationsTramesMASH donnees;
		String chekSum =info.substring(info.length()+OCTETS_POSITION_CKSUM, info.length()+OCTETS_POSITION_CKSUM+OCTETS_TAILLE_CKSUM);
		String enQueue =info.substring(info.length()+OCTETS_POSITION_EN_QUEUE, info.length());
	
		System.out.println("enTete = "+ enTete);
		System.out.println("tailleInfo ="+ tailleInfo);
		System.out.println("cksum = "+ chekSum);
		System.out.println("enQueue = "+ enQueue);
			
		if (info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_FONCTION).equals(BIT_DONNEE_0_1))
		{
			if (info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION).equals(BIT_DONNEE_0_1))
			{
				System.out.println("Envoie donnéees voisin non perçu");
				afficheinfo(info);
			}
			else
			{
				System.out.println("Envoie donnéees voisin perçu");
				afficheinfo(info);
			}
		}
	}
	
	public static void afficheinfo(String info)
	{
		String fonction= info.substring(OCTETS_POSITION_FONCTION, OCTETS_POSITION_FONCTION+OCTETS_TAILLE_SS_FONCTION);
		String sousfonction= info.substring(OCTETS_POSITION_SS_FONCTION, OCTETS_POSITION_SS_FONCTION+OCTETS_TAILLE_SS_FONCTION);
		String data= info.substring(12, info.length()-8);
		
		System.out.println("fonction = "+ fonction);
		System.out.println("sousfonction = "+ sousfonction);
		System.out.println("data = "+ data);
	}
	
	public static void testchaineHexa() 
	{
		/*Test on reçois une chaine de caractère contenant des octet en hexa */
		String chaineHexa ="01FE00000010123002021010";
		
		String enTete= chaineHexa.substring(0, 4);
		String tailleInfo= chaineHexa.substring(4, 8);
		String fonction= chaineHexa.substring(8, 10);
		String sousfonction= chaineHexa.substring(10, 12);
		String data= chaineHexa.substring(12, chaineHexa.length()-8);
		String ck= chaineHexa.substring(chaineHexa.length()-8, chaineHexa.length()-4);
		String enQueue= chaineHexa.substring(chaineHexa.length()-4, chaineHexa.length());
		String infor= chaineHexa.substring(10,chaineHexa.length());
		
		
		System.out.println("enTete = "+ enTete);
		System.out.println("tailleInfo ="+ tailleInfo);
		System.out.println("fonction = "+ fonction);
		System.out.println("sousfonction = "+ sousfonction);
		System.out.println("data = "+ data);
		System.out.println("cksum = "+ ck);
		System.out.println("enQueue = "+ enQueue);
		System.out.println("information = "+ infor);

	}
	
	public void bordel()
	{

		String addVoisin="F1";

		
		/*Convertie une chaine hexa decimal en int*/
		int addVoisinInt = Integer.parseInt(addVoisin,16);
		/*Convertie un int en une chaine hexa*/
		String chainereconvertis = Integer.toHexString(addVoisinInt);

		
		String infoVoisin= String.format("%02x", new BigInteger(1, addVoisin.getBytes()));

		
		System.out.println(infoVoisin);
		System.out.println(addVoisinInt);
		System.out.println(chainereconvertis);
		System.out.println(infoVoisin.length());

		/*decimal vers binaire*/
		/*System.out.println("--------------TESTCHAINEHEXA----------------");
		testchaineHexa();
		System.out.println("-------------TESTCHAINEHEXAV2---------------");
		System.out.println("FONCTION/SSFONCTION : 0101");
		testchaineHexaV2("01FE00000101123002021010");
		System.out.println("FONCTION/SSFONCTION : 0102");
		testchaineHexaV2("01FE00000102123002021010");*/
	}
	
	public void testchaineCarac() 
	{
		/*Test on reçois une chaine de caractère du robot */
		String info = "020101111002222003333004";
				
		String adresseVoisin= info.substring(4, 10);
		String coordonneeX= info.substring(10, 16);
		int coordonneeY= Integer.parseInt(info.substring(16, 22));
		String rôle= info.substring(22, 24);
		
		System.out.println("voisin = "+ adresseVoisin);
		System.out.println("x = "+ coordonneeX);
		System.out.println("y = "+ coordonneeY);
		System.out.println("rôle = "+ rôle);
	}
	
	
	
	public void testContrôle() 
	{
		//SwingUtilities.invokeLater(new InterfacePrincipale());
				
		SerialPortConnexion port = new SerialPortConnexion("COM4");
		port.ouvrirPort();
		EPuck robot = new EPuck(port.obtenirConnexionEntree(), port.obtenirConnexionSortie());	
		
		robot.aide();
		robot.afficherValeurCapteur();
		
		port.fermerPort();
		try 
		{
			robot.aide();
			Thread.sleep(2000);
			robot.aide();
			Thread.sleep(2000);
			port.fermerPort();
			System.out.println("Fin Programme");
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Probleme");
			e.printStackTrace();
		}
	}
	
	
	
	public static String test(int i) 
    { 

        // read in the command-line argument
        int n = i;
        String result="";

        // set v to the largest power of two that is <= n
        int v = 1;
        while (v <= n/2) 
        {
            v = v * 2;
        }
  
        // check for presence of powers of 2 in n, from largest to smallest
        while (v > 0) {

            // v is not present in n 
            if (n < v) {
            	result=result+"0";
            }

            // v is present in n, so remove v from n
            else {
            	result=result+"1";
                n = n - v;
            }

            // next smallest power of 2
            v = v / 2;
            
        }
        return result;
    }
}
