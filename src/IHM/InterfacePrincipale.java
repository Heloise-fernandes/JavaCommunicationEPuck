package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class InterfacePrincipale implements Runnable
{
	public JFrame fenetre;
	
	public JPanel paneGauche;
	public JPanel paneDroit;
	
	public PanelDeConnexionAuPort pane1;
	public PanelDeDeplacement pane2;
	public PanelDeControleDeLaCourbe pane3;
	
	public PanelDeTracage pane4;
	public PanelDeLAccelerometre pane5;
	public PanelDeLaCamera pane6;
	public PanelDeDetectionViaCapteurIR pane7;
	
	
	@Override
	public void run()
	{	
		
		//Configuration de la fenêtre JFrame
		this.fenetre = new JFrame();
		this.fenetre.setSize(800,450);
		this.fenetre.setLayout(new BorderLayout());
		
		//Configuration du panel de gauche
		this.paneGauche = new JPanel();
		this.paneGauche.setLayout(new BorderLayout());
		
		//Ajout des éléments du panel de gauche
		this.pane1 = new PanelDeConnexionAuPort();
		this.pane2 = new PanelDeDeplacement();
		this.pane3 = new PanelDeControleDeLaCourbe();
		this.paneGauche.add(pane1,BorderLayout.NORTH);
		this.paneGauche.add(pane2,BorderLayout.CENTER);
		this.paneGauche.add(pane3,BorderLayout.SOUTH);
		
		//Configuration du panel de droite
		this.paneDroit = new JPanel();
		this.paneDroit.setLayout(new GridLayout(2,2));
		
		//Ajout des éléments du panel de droite
		this.pane4 = new PanelDeTracage();
		this.pane5 = new PanelDeLAccelerometre();
		this.pane6 = new PanelDeLaCamera();
		this.pane7 = new PanelDeDetectionViaCapteurIR();
		this.paneDroit.add(pane4);
		this.paneDroit.add(pane5);
		this.paneDroit.add(pane6);
		this.paneDroit.add(pane7);
		
		//Formation de la fenêtre finale
		this.fenetre.add(paneGauche,BorderLayout.WEST);
		this.fenetre.add(paneDroit);
		this.fenetre.setVisible(true);
	}
	

}
