package InterfaceControleurIHM;

public interface ObservableEpuck {
	
	public void ajouterObserver(ObservateurEPuck o);
	public void notifierObserver(double x, double y);
	public void supprimerObserver(ObservateurEPuck o);

}
