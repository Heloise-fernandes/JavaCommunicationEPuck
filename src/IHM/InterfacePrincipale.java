package IHM;


import Logique.Direction;
import Logique.EPuck;
import Logique.SerialPortConnexion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.ui.RefineryUtilities;

import Dessin.Graphique;
import Exception.TexteVideCOMException;
import Exception.TexteVideVitesseException;
import Exception.TexteVideXException;
import Exception.TexteVideYException;
import InterfaceControleurIHM.ObservableEpuck;
import InterfaceControleurIHM.ObservateurEPuck;
import InterfaceControleurIHM.Vue;


public class InterfacePrincipale implements Runnable, Vue, ActionListener, KeyListener
{
	private static final int VITESSE_PAR_DEFAUT = 500;

	private JFrame fenetre;
	
	private JPanel paneGauche;
	private JPanel paneDroit;
	
	private PanelDeConnexionAuPort panelConnexion;
	private PanelDeDeplacement panelDeplacement;
	private PanelDeControleDeLaCourbe panelCourbe;

	private EPuck controler;

	private Graphique graphique;
	
	public InterfacePrincipale()
	{
		this.controler=null;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run()
	{	
		
		//Configuration de la fenêtre JFrame
		this.fenetre = new JFrame();
		this.fenetre.setSize(800,450);
		this.fenetre.getContentPane().setLayout(new BorderLayout());
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//Configuration du panel de gauche
		this.paneGauche = new JPanel();
		this.paneGauche.setLayout(new BorderLayout());
		
		//Ajout des éléments du panel de gauche
		this.panelConnexion = new PanelDeConnexionAuPort(this);
		
		this.panelDeplacement = new PanelDeDeplacement(this);
		
		this.panelCourbe = new PanelDeControleDeLaCourbe(this);
		
		this.paneGauche.add(panelConnexion,BorderLayout.NORTH);
		this.paneGauche.add(panelDeplacement,BorderLayout.CENTER);
		this.paneGauche.add(panelCourbe,BorderLayout.SOUTH);
		
		//Configuration du panel de droite
		this.paneDroit = new JPanel();
		this.paneDroit.setLayout(new GridLayout(2,1));
		
		//fenetre graphique
		this.graphique = new Graphique();
        
        //graphique.ajoutPoint(10.0, 10.0);
        
        JPanel panelGraphique = new JPanel();
        panelGraphique.setLayout(new java.awt.BorderLayout());        
        panelGraphique.add(graphique.obtenirChartPanel(),BorderLayout.CENTER);
        panelGraphique.validate();
		
		//Ajout des éléments du panel de droite
		//this.pane4 = new PanelDeTracage();
		//this.paneDroit.add(panelGraphique);
		//this.paneDroit.add(pane5);
		/*this.paneDroit.add(pane6);
		this.paneDroit.add(pane7);*/
		
		//Formation de la fenêtre finale
		this.fenetre.getContentPane().add(paneGauche,BorderLayout.WEST);
		this.fenetre.getContentPane().add(panelGraphique);
		this.fenetre.setVisible(true);
		
		
        
        //test observeur
        /*this.controler.ajouterObserver(graphique);
        this.controler.notifierObserver(10.0, 3.0);
        this.controler.notifierObserver(5.0, -4.0);*/
		
	}

	
	public void traiterConnexion(String portCOM)
	{
		SerialPortConnexion port = new SerialPortConnexion(portCOM);
		if (port.ouvrirPort())
		{
			this.controler = new EPuck(port.obtenirConnexionEntree(), port.obtenirConnexionSortie());
			JOptionPane.showMessageDialog(this.fenetre, "Connexion Réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
			this.controler.ajouterObserver(this.graphique);
		}
		else JOptionPane.showMessageDialog(this.fenetre, "Echec de Connexion", "Information", JOptionPane.ERROR_MESSAGE);
	}
	
	public void traiterDeplacement(char ordre)
	{
		if (this.controler != null)
		{
			int vitesse;
			
			try{
				vitesse =  Integer.parseInt(this.panelCourbe.obtenirVitesse());
			}
			catch (NumberFormatException e)
			{
				vitesse = VITESSE_PAR_DEFAUT;
			} catch (TexteVideVitesseException e) {
				vitesse = VITESSE_PAR_DEFAUT;
			}
			
			switch (ordre)
			{
			case 'H':
				this.controler.avancerToutDroit(vitesse);
				break;
			case 'B':
				this.controler.avancerToutDroit(-vitesse);
				break;
			case 'D':
				this.controler.toupieDroite(vitesse);
				break;
			case 'G':
				this.controler.toupieGauche(-vitesse);
				break;
			default:
				this.controler.stop();
				break;
			}
		}
		else JOptionPane.showMessageDialog(this.fenetre, "Vous devez être connecté", "Information", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JComponent source = (JComponent) event.getSource();
		
		if (source.getParent() == this.panelConnexion)
		{
			try {
				traiterConnexion(this.panelConnexion.obtenirPortCOM());
			} catch (TexteVideCOMException e) {
				JOptionPane.showMessageDialog(this.fenetre, "Vous devez rentrer un N° de port", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (source.getParent() == this.panelDeplacement)
		{
			traiterDeplacement(((JButton) event.getSource()).getText().charAt(0));
		}
		
		if (source.getParent() == this.panelCourbe.obtenirPaneBouton())
		{
			traiterGoTo();
		}
		
		
	}


	private void traiterGoTo() {
		
		try {
			int x = Integer.parseInt(this.panelCourbe.obtenirX());
			int y = Integer.parseInt(this.panelCourbe.obtenirY());
		} catch (NumberFormatException | TexteVideXException | TexteVideYException e) {
			JOptionPane.showMessageDialog(this.fenetre, "Vous devez rentrer des nombres", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
		//TODO ajouter appel methode goto
		
	}

	@Override
	public void notifierActionMouvement(Direction direction) {
		// TODO Auto-generated method stub
		
	}


	

}
