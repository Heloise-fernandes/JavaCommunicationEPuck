package IHM;

import javax.swing.*;

public class PanelDeControleDeDistance extends JPanel
{
	public JLabel distance;
	
	public JTextField dist;
	
	public PanelDeControleDeDistance()
	{
		this.distance = new JLabel("Distance : ");
		this.dist = new JTextField(5);
		
		this.add(this.distance);
		this.add(this.dist);
	}
}
