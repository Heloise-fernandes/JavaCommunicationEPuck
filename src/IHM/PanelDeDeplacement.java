package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelDeDeplacement extends JPanel
{
	public JButton haut;
	public JButton bas;
	public JButton rotDroite;
	public JButton rotGauche;
	public JButton stop;
	
	public JPanel paneHaut;
	public JPanel paneBas;
	
	public PanelDeDeplacement()
	{
		this.setLayout(new BorderLayout()); 
		
		this.paneBas = new JPanel();
		this.paneBas.setLayout(new GridLayout(3,3));
		
		this.paneHaut = new JPanel();
		
		this.haut = new JButton("H");
		this.bas = new JButton("B");
		this.rotDroite = new JButton("D");
		this.rotGauche = new JButton("G");
		this.stop = new JButton("S");

		this.paneBas.add(new JButton());
		this.paneBas.add(haut);
		this.paneBas.add(new JButton());
		this.paneBas.add(rotGauche);
		this.paneBas.add(stop);
		this.paneBas.add(rotDroite);
		this.paneBas.add(new JButton());
		this.paneBas.add(bas);
		this.paneBas.add(new JButton());
		
		this.paneHaut.add(new PanelDeControleDeDistance());
		
		this.add(paneHaut,BorderLayout.NORTH);
		this.add(paneBas);
	}
	
	
}
