package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelDeControleDeLaCourbe extends JPanel
{
	public JLabel courbe;
	public JLabel distance;
	public JLabel angle;

	public JTextField dist;
	public JTextField ang;
	
	public JButton action;
	
	public JPanel pane;
	
	public PanelDeControleDeLaCourbe()
	{
		this.courbe = new JLabel("Courbe de déplacement :");
		this.distance = new JLabel("Distance");
		this.angle = new JLabel("Angle");
		
		this.dist = new JTextField(5);
		this.ang = new JTextField(5);
		
		this.action = new JButton("GO!");
		
		this.setLayout(new BorderLayout());
		
		this.pane = new JPanel();
		this.pane.setLayout(new GridLayout(2,2));
		
		this.add(this.courbe,BorderLayout.NORTH);
		this.pane.add(distance);
		this.pane.add(dist);
		this.pane.add(angle);
		this.pane.add(ang);
		this.add(pane,BorderLayout.CENTER);
		this.add(action,BorderLayout.EAST);
		
		
		
	}
}
