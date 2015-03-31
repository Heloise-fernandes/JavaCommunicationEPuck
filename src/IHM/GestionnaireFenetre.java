package IHM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestionnaireFenetre extends WindowAdapter {
	
	public void windowClosing(WindowEvent e) {
		if (InterfacePrincipale.getport() != null)
			InterfacePrincipale.getport().fermerPort();
		System.exit(0);

		}

}
