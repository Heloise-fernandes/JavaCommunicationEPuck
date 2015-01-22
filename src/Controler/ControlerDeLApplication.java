package Controler;

import Application.EPuck;
import Application.SerialPortConnexion;
import InterfaceControleurIHM.ControleDeLApplication;


public class ControlerDeLApplication implements ControleDeLApplication{

	private boolean connexionEtablie;
	private SerialPortConnexion port;
	private EPuck robot;
	
	@Override
	public void Bouger(Direction direction) {
		//case
		
	}

	@Override
	public void ConnexionSerie(int numPort) {
		if (!connexionEtablie)
		{
			port = new SerialPortConnexion("COM"+numPort);
			port.ouvrirPort();
		}
		
	}

}
