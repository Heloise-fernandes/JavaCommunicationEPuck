package IHM;

import javax.swing.*;

public class PanelDeControleDeDistance extends JPanel
{
	public JLabel distance;
	public JLabel vitesse;
	
	public JTextField dist;
	public JTextField vit;
	
	public PanelDeControleDeDistance()
	{
		this.distance = new JLabel("Distance : ");
		this.vitesse = new JLabel("Vitesse : ");
		
		this.dist = new JTextField(5);
		this.vit = new JTextField(5);
		
		this.add(this.distance);
		this.add(this.dist);
		this.add(this.vitesse);
		this.add(this.vit);
	}
}
