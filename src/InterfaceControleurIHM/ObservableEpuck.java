package InterfaceControleurIHM;

import Mash.TramesMASH;

/**
 * Interface permettant au robot de notifier sa position
 * @author Maxime
 *
 */
public interface ObservableEpuck {
	
	public void ajouterObserver(ObservateurEPuck o);
	public void notifierObserver(double x, double y);
	public void notifierObserver(TramesMASH trame);
	public void supprimerObserver(ObservateurEPuck o);

}
