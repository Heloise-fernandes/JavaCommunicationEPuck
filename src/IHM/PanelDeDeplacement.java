package IHM;



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Construit l'affichage du panel de déplacement et ajoute un auditeur d'evenement sur chaque bouton.
 * Construit avec WindowBuilder
 * @author Maxime
 *
 */
public class PanelDeDeplacement extends JPanel
{
	private JButton haut;
	private JButton bas;
	private JButton rotDroite;
	private JButton rotGauche;
	private JButton stop;
	private JPanel blank;
	
	private JPanel paneHaut;
	private JPanel paneBas;
	
	public PanelDeDeplacement(ActionListener auditeurBoutons)
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 0, 125, 0};
		gridBagLayout.rowHeights = new int[]{55, 55, 55, 55, 60, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		this.rotDroite = new JButton("D");
		this.rotDroite.addActionListener(auditeurBoutons);
		
		this.haut = new JButton("H");
		this.haut.addActionListener(auditeurBoutons);
		GridBagConstraints gbc_haut = new GridBagConstraints();
		gbc_haut.fill = GridBagConstraints.BOTH;
		gbc_haut.insets = new Insets(0, 0, 5, 5);
		gbc_haut.gridx = 1;
		gbc_haut.gridy = 1;
		this.add(haut, gbc_haut);
		
		this.stop = new JButton("S");
		this.stop.addActionListener(auditeurBoutons);
		
		this.rotGauche = new JButton("G");
		this.rotGauche.addActionListener(auditeurBoutons);
		GridBagConstraints gbc_rotGauche = new GridBagConstraints();
		gbc_rotGauche.anchor = GridBagConstraints.EAST;
		gbc_rotGauche.fill = GridBagConstraints.VERTICAL;
		gbc_rotGauche.insets = new Insets(0, 0, 5, 5);
		gbc_rotGauche.gridx = 0;
		gbc_rotGauche.gridy = 2;
		this.add(rotGauche, gbc_rotGauche);
		GridBagConstraints gbc_stop = new GridBagConstraints();
		gbc_stop.fill = GridBagConstraints.BOTH;
		gbc_stop.insets = new Insets(0, 0, 5, 5);
		gbc_stop.gridx = 1;
		gbc_stop.gridy = 2;
		this.add(stop, gbc_stop);
		GridBagConstraints gbc_rotDroite = new GridBagConstraints();
		gbc_rotDroite.anchor = GridBagConstraints.WEST;
		gbc_rotDroite.fill = GridBagConstraints.VERTICAL;
		gbc_rotDroite.insets = new Insets(0, 0, 5, 0);
		gbc_rotDroite.gridx = 2;
		gbc_rotDroite.gridy = 2;
		this.add(rotDroite, gbc_rotDroite);
		
		
		
		this.bas = new JButton("B");
		this.bas.addActionListener(auditeurBoutons);
		GridBagConstraints gbc_bas = new GridBagConstraints();
		gbc_bas.fill = GridBagConstraints.BOTH;
		gbc_bas.insets = new Insets(0, 0, 5, 5);
		gbc_bas.gridx = 1;
		gbc_bas.gridy = 3;
		this.add(bas, gbc_bas);
		

	}
	
	
}
