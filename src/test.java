import Logique.SerialPortConnexion;
import MultiTaches.EpuckAvecThread;


public class test 
{
	public static void main(String[] args)
	{
		SerialPortConnexion port = new SerialPortConnexion("COM5");
		EpuckAvecThread epuck = new EpuckAvecThread(4, port,port );
		epuck.start();
		
		
	}
	
	
	
	
	
	
}
