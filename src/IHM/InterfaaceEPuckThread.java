package IHM;


import Logique.Courbe;
import Logique.Direction;
import Logique.EPuck;
import Logique.EpuckOrder;
import Logique.SerialPortConnexion;
import MultiTaches.EpuckAvecThread;
import gnu.io.NoSuchPortException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.io.Closeable;

import javax.swing.*;

import Dessin.Graphique;
import Exception.TexteVideCOMException;
import Exception.TexteVideRayonCourbureException;
import Exception.TexteVideVitesseException;
import Exception.TexteVideXException;
import Exception.TexteVideYException;

/**
 * Fenetre principale de l'application
 * @author Maxime
 *
 */
public class InterfaaceEPuckThread implements Runnable, ActionListener, KeyListener
{
	private static final int VITESSE_PAR_DEFAUT = 500;

	private JFrame fenetre;
	
	private JPanel paneGauche;
	private JPanel paneDroit;
	
	private PanelDeConnexionAuPort panelConnexion;
	private PanelDeDeplacement panelDeplacement;
	private PanelCourbeEtGoTo panelCourbe;

	private EpuckAvecThread controler;

	private Graphique graphique;
	
	private static SerialPortConnexion port;
	
	private int nombreEpuck;
	
	private final String portMASH;
	
	public InterfaaceEPuckThread(String portMASH)
	{
		this.nombreEpuck=0;
		this.controler=null;
		this.portMASH=portMASH;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run()
	{	
		//Creer un gestionnaire de fenetre afin de capturer la fermeture
		GestionnaireFenetre gf = new GestionnaireFenetre();
		
		//Configuration de la fenêtre JFrame
		this.fenetre = new JFrame();
		this.fenetre.setSize(800,450);
		this.fenetre.getContentPane().setLayout(new BorderLayout());
		//On ne fait rien à la fermeture, c'est le gestionnaire qui se charge de fermer l'application
		this.fenetre.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		//Configuration du panel de gauche
		this.paneGauche = new JPanel();
		this.paneGauche.setLayout(new BorderLayout());
		
		//Ajout des éléments du panel de gauche
		this.panelConnexion = new PanelDeConnexionAuPort(this);
		this.panelDeplacement = new PanelDeDeplacement(this);
		this.panelCourbe = new PanelCourbeEtGoTo(this);
		
		this.paneGauche.add(panelConnexion,BorderLayout.NORTH);
		this.paneGauche.add(panelDeplacement,BorderLayout.CENTER);
		this.paneGauche.add(panelCourbe,BorderLayout.SOUTH);
		
		//Configuration du panel de droite
		this.paneDroit = new JPanel();
		this.paneDroit.setLayout(new GridLayout(2,1));
		
		//fenetre graphique
		this.graphique = new Graphique();
		//On met le graphique dans un JPanel afin de pouvoir l'afficher
        JPanel panelGraphique = new JPanel();
        panelGraphique.setLayout(new java.awt.BorderLayout());        
        panelGraphique.add(graphique.obtenirChartPanel(),BorderLayout.CENTER);
        panelGraphique.validate();
		
		//Formation de la fenêtre finale
        this.fenetre.addWindowListener(gf);
		this.fenetre.getContentPane().add(paneGauche,BorderLayout.WEST);
		this.fenetre.getContentPane().add(panelGraphique);
		this.fenetre.setVisible(true);
		
	}

	/**
	 * Permet de se connecter via un port COM, et ajoute le graphique à la liste de observer du robot
	 * @param portCOM port de communication avec le robot sous la forme "COMX" avec X le numero du port COM
	 */
	public void traiterConnexion(String portCOM1, String portCOM2)
	{
		try{
			this.nombreEpuck++;
			this.controler = new EpuckAvecThread(this.nombreEpuck,portCOM1, portCOM2);
			JOptionPane.showMessageDialog(this.fenetre, "Connexion Réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
			//On ajoute le graphique en observeur afin de pouvoir, si besoin ajouter la position du robot sur le graphique
			this.controler.ajouterObserver(this.graphique);
		}
		catch ( NoSuchPortException e){
			JOptionPane.showMessageDialog(this.fenetre, "Echec de Connexion", "Information", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Permet de capturer les ordres du panel de déplacement.
	 * Si aucune vitesse n'est entrée par l'utilisateur, on prend une vitesse par défaut de 5OO pas/s
	 * @param ordre caractère représentant l'ordre du robot
	 */
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
				this.controler.envoieDOrdreAuRobot(EpuckOrder.AVANCERTOUTDROIT, vitesse, 0, 0);
				break;
			case 'B':
				this.controler.envoieDOrdreAuRobot(EpuckOrder.AVANCERTOUTDROIT, -vitesse, 0, 0);
				break;
			case 'D':
				this.controler.envoieDOrdreAuRobot(EpuckOrder.TOURNERDROITE, vitesse, 0, 0);
				break;
			case 'G':
				this.controler.envoieDOrdreAuRobot(EpuckOrder.TOURNERGACHE, vitesse, 0, 0);
				break;
			default:
				this.controler.envoieDOrdreAuRobot(EpuckOrder.ARRETER, vitesse, 0, 0);
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


	/**
	 * Permet de localiser la source de l'evenement et de le traiter
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JComponent source = (JComponent) event.getSource();
		
		if (source.getParent() == this.panelConnexion)
		{
			try {
				traiterConnexion(this.panelConnexion.obtenirPortCOM(),portMASH);
			} catch (TexteVideCOMException e) {
				JOptionPane.showMessageDialog(this.fenetre, "Vous devez rentrer un N° de port", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (source.getParent() == this.panelDeplacement)
		{
			traiterDeplacement(((JButton) event.getSource()).getText().charAt(0));
		}
		
		if (source.getParent() == this.panelCourbe.obtenirPaneBoutonGoTo())
		{
			traiterGoTo();
		}
		
		
		if (source.getParent() == this.panelCourbe.obtenirPaneBoutonCourbe())
		{
			traiterCourbe();
		}
		
		
	}


	/**
	 * Permet au robot de faire un cercle. Pour faire un cercle dans l'autre sens il suffit de rentrer une vitesse négative
	 */
	private void traiterCourbe() 
	{
		int vitesse;
		int rayonCourbure;
		
		try {
			vitesse = Integer.parseInt(this.panelCourbe.obtenirVitesse());
		}
		catch (TexteVideVitesseException e)
		{
			vitesse = VITESSE_PAR_DEFAUT;
		}
		
		try {
			
			
			rayonCourbure = Integer.parseInt(this.panelCourbe.obtenirRayonCourbure());
			
			System.out.println("je créer la courbe");
			Courbe courbe = new Courbe(rayonCourbure,vitesse);
			System.out.println("courbe créé");
			
			int vitRoueGauche = courbe.obtenirVitesseRoueGauche();
			System.out.println("vit roue G faite");
			int vitRoueDroite = courbe.obtenirVitesseRoueDroite();
			System.out.println("vit rooue D faite");
			
			System.out.println("vitRoueG : "+vitRoueGauche);
			System.out.println("viteRoueD : "+vitRoueDroite);
			
			this.controler.envoieDOrdreAuRobot(EpuckOrder.COURBE,vitRoueGauche, vitRoueDroite);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this.fenetre, "Pas vide Vous devez rentrer un rayon de courbure sous forme d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
		} 
		catch (TexteVideRayonCourbureException e)
		{
			JOptionPane.showMessageDialog(this.fenetre, "VIDE Vous devez rentrer un rayon de courbure sous forme d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

	/**
	 * Permet de traiter le goto. Il manque l'appel de la méthode goto du robot, non traité
	 */
	private void traiterGoTo() {
		
		try {
			int x = Integer.parseInt(this.panelCourbe.obtenirX());
			int y = Integer.parseInt(this.panelCourbe.obtenirY());
		} catch (NumberFormatException | TexteVideXException | TexteVideYException e) {
			JOptionPane.showMessageDialog(this.fenetre, "Vous devez rentrer des nombres", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
		//TODO ajouter appel methode goto
		
	}
	
	/**
	 * Permet d'obtenir le port de connexion, afin de pouvoir le fermer avant de quitter l'application
	 * @return le port de connexion
	 */
	public static SerialPortConnexion getport()
	{
		return port;
	}


	

}
