package InterfaceControleurIHM;

import Controler.Direction;

public interface ControleDeLApplication {
	
	public void ConnexionSerie(int numPort);
	
	public void Bouger(Direction direction);
	

}
