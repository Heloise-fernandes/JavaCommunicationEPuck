package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Logique.Direction;

public class PanelDeDeplacement extends JPanel
{
	private JButton haut;
	private JButton bas;
	private JButton rotDroite;
	private JButton rotGauche;
	private JButton stop;
	
	private JPanel paneHaut;
	private JPanel paneBas;
	
	public PanelDeDeplacement(ActionListener auditeurBoutons)
	{
//		this.setLayout(new BorderLayout());
		
		this.paneBas = new JPanel();
		this.setLayout(new GridLayout(3,3));
		
		this.paneHaut = new JPanel();
		
		this.haut = new JButton("H");
		this.haut.addActionListener(auditeurBoutons);
		
		this.bas = new JButton("B");
		this.bas.addActionListener(auditeurBoutons);
		
		this.rotDroite = new JButton("D");
		this.rotDroite.addActionListener(auditeurBoutons);
		
		this.rotGauche = new JButton("G");
		this.rotGauche.addActionListener(auditeurBoutons);
		
		this.stop = new JButton("S");
		this.stop.addActionListener(auditeurBoutons);

		this.add(new JButton());
		this.add(haut);
		this.add(new JButton());
		this.add(rotGauche);
		this.add(stop);
		this.add(rotDroite);
		this.add(new JButton());
		this.add(bas);
		this.add(new JButton());
		
//		this.paneHaut.add(new PanelDeControleDeDistance());
//		
//		this.add(paneHaut,BorderLayout.NORTH);
//		this.add(paneBas);
	}
	
	
}
