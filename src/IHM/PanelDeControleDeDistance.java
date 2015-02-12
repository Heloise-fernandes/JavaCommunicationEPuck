package IHM;

import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;

public class PanelDeControleDeDistance extends JPanel
{
	private JLabel distance;
	private JLabel vitesse;
	
	private JTextField dist;
	private JTextField vit;
	
	

	public PanelDeControleDeDistance(ActionListener auditeurBoutons)
	{
		this.distance = new JLabel("Distance : ");
		this.dist = new JTextField(5);
		
		this.vitesse = new JLabel("Vitesse : ");
		this.vit = new JFormattedTextField(NumberFormat.getInstance());;
		this.vit.setColumns(5);;
		
		this.add(this.distance);
		this.add(this.dist);
		this.add(this.vitesse);
		this.add(this.vit);
	}
	
	public JTextField getDist() {
		return dist;
	}

	public JTextField getVit() {
		return vit;
	}
}
