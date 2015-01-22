package IHM;

import javax.swing.*;

public class PanelDeConnexionAuPort extends JPanel
{
	public JLabel lab1;
	public JTextField com;
	public JButton b1;
	
	public PanelDeConnexionAuPort()
	{
		this.lab1 = new JLabel("Connexion au port : ");
		this.com = new JTextField(6);
		this.b1 = new JButton("Connexion");
		
		this.add(lab1);
		this.add(com);
		this.add(b1);
	}
}
