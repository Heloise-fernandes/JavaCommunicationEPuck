
public class ProgrammePrincipale {

	public static void main(String[] args) 
	{

		SerialPortConnexion port = new SerialPortConnexion("COM4");
		port.ouvrirPort();
		EPuck robot = new EPuck(port.obtenirConnexionEntree(), port.obtenirConnexionSortie());	
		
		robot.aide();
		robot.afficherValeurCapteur();
		robot.obtenirValeurCapteur();
		
		port.fermerPort();
		/*try 
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
		}*/
	}
}
