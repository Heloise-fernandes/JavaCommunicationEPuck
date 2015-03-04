package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Exception.TexteVideCOMException;

public class PanelDeConnexionAuPort extends JPanel
{
	private JLabel lab1;
	private JTextField com;
	private JButton b1;
	
	private PanelDeControleDeDistance panelControleDistance;
	
	public PanelDeConnexionAuPort(ActionListener auditeurBoutons)
	{
		this.lab1 = new JLabel("Connexion au port : ");
		this.com = new JTextField(6);
		this.b1 = new JButton("Connexion");
		this.b1.addActionListener(auditeurBoutons);
		this.panelControleDistance = new PanelDeControleDeDistance(auditeurBoutons);
		
		
		this.add(lab1);
		this.add(com);
		this.add(b1);
		this.add(panelControleDistance);
		
	}
	
	public String obtenirPortCOM() throws TexteVideCOMException
	{
		if ((this.com.getText().equalsIgnoreCase("")))
			throw new TexteVideCOMException();
		else return this.com.getText();
	}
	
	public PanelDeControleDeDistance getPanelDistance()
	{
		return this.panelControleDistance;
				
	}
}
