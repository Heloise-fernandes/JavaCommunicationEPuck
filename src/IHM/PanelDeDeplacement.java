package IHM;



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

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

		
		JButton button_1 = new JButton();
		button_1.setEnabled(false);
		this.add(button_1);
		
		this.add(haut);
		
		JButton button_2 = new JButton();
		button_2.setEnabled(false);
		
		this.add(button_2);
		this.add(rotGauche);
		this.add(stop);
		this.add(rotDroite);
		
		JButton button = new JButton();
		button.setEnabled(false);
		
		this.add(button);
		this.add(bas);
		
		JButton button_3 = new JButton();
		button_3.setEnabled(false);
		
		this.add(button_3);
		
//		this.paneHaut.add(new PanelDeControleDeDistance());
//		
//		this.add(paneHaut,BorderLayout.NORTH);
//		this.add(paneBas);
	}
	
	
}
