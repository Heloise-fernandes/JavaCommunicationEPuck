package IHM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Permet de capturer les actions effectuées sur la fenetre.
 * Ici on capture seulement la fermeture afin de fermer la connexion bluetooth
 * @author Maxime
 *
 */
public class GestionnaireFenetre extends WindowAdapter {
	
	/**
	 * Ferme la connexion bluetooth, si elle existe, avant la fermeture de l'application
	 */
	public void windowClosing(WindowEvent e) {
		if (InterfacePrincipale.getport() != null)
			InterfacePrincipale.getport().fermerPort();
		System.exit(0);

		}

}
