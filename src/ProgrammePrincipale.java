
public class ProgrammePrincipale {

	public static void main(String[] args) 
	{

		SerialPortConnexion port = new SerialPortConnexion("COM4");
		port.ouvrirPort();
		EPuck robot = new EPuck(port.obtenirConnexionEntree(), port.obtenirConnexionSortie());		
		try 
		{
			robot.aide();
			robot.aide();
			robot.toupie(300);
			Thread.sleep(10000);
			robot.stop();
			port.fermerPort();
			System.out.println("Fin Programme");
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Probleme");
			e.printStackTrace();
		}
	}
}
