package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelDeControleDeLaCourbe extends JPanel
{
	private JLabel courbe;
	private JLabel distance;
	private JLabel angle;

	private JTextField dist;
	private JTextField ang;
	
	private JButton action;
	
	private JPanel pane;
	
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
