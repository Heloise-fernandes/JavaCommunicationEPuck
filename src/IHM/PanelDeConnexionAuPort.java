package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Exception.TexteVideCOMException;

/**
 * Représente le panel de connexion au robot
 * @author Maxime
 *
 */
public class PanelDeConnexionAuPort extends JPanel
{
	private JLabel lab1;
	private JTextField com;
	private JButton b1;
	

	/**
	 * constructeur
	 * @param auditeurBoutons Qui va traiter l'interaction avec les boutons
	 */
	public PanelDeConnexionAuPort(ActionListener auditeurBoutons)
	{
		this.lab1 = new JLabel("Connexion au port : ");
		this.com = new JTextField(6);
		this.b1 = new JButton("Connexion");
		this.b1.addActionListener(auditeurBoutons);

		this.add(lab1);
		this.add(com);
		this.add(b1);
	}
	
	/**
	 * Permet de récuperer la chaîne de caractère du champ texte
	 * @return une chaine de caractère
	 * @throws TexteVideCOMException si le champ texte est vide
	 */
	public String obtenirPortCOM() throws TexteVideCOMException
	{
		if ((this.com.getText().equalsIgnoreCase("")))
			throw new TexteVideCOMException();
		else return this.com.getText();
	}
	

}
