package InterfaceControleurIHM;

public interface ControleDuRobotEPuck {

	/**
	 * AvancerToutDroit
	 * Permet d'avancer en ligne droite (vers l'avant ou l'arrière)
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO).
	 * Si la vitesse est négative, le robot recule.
	 */
	public abstract void avancerToutDroit(int vitesse);

	/**
	 * AvancerToutDroit selon une distance
	 * Permet d'avancer en ligne droite (vers l'avant ou l'arrière)
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (1000).
	 * Si la vitesse est négative, le robot recule.
	 * distance un entier qui definit la distance à parcourir par le robot
	 */
	public abstract void avancerToutDroit(int vitesse, int distance);

	/**
	 * Permet au robot de tourner sur lui même comme une toupie
	 * @param vitesse Entier en pas par seconde du robot (1 pas = TODO) La vitesse max du robot est (TODO)
	 */
	public abstract void toupie(int vitesse);

	/**
	 * TODO
	 * Permet d'afficher l'aide fournie par le robot
	 */
	public abstract void aide();

	public abstract void stop();

	/**
	 * Entree:void
	 * Sortie:void
	 * Affiche la valeur des capteur infrarouge
	 * */
	public abstract void AfficherValeurCapteur();

}