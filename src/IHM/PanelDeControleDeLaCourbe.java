package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Exception.TexteVideCOMException;
import Exception.TexteVideRayonCourbureException;
import Exception.TexteVideVitesseException;
import Exception.TexteVideXException;
import Exception.TexteVideYException;

public class PanelDeControleDeLaCourbe extends JPanel
{
	private JLabel allerA;
	private JLabel x;
	private JLabel y;
	private JLabel vitesse;
	private JLabel rayonDeCourbure;
	private JLabel courbe;

	private JTextField x1;
	private JTextField y1;
	private JTextField vit;
	private JTextField ray;
	
	private JButton actionGoTo;
	private JButton actionCourbe;
	
	private JPanel b4;
	private JPanel b5;
	
	public PanelDeControleDeLaCourbe(ActionListener listener)
	{
		this.allerA = new JLabel("Aller à :");
		this.x = new JLabel("x");
		this.y = new JLabel("y");
		this.vitesse = new JLabel("Vitesse :");
		this.rayonDeCourbure = new JLabel("Rayon de courbure :");
		this.courbe = new JLabel("Courbe :");
		
		this.x1 = new JTextField(5);
		this.y1 = new JTextField(5);
		this.vit = new JTextField(5);
		this.ray = new JTextField(5);
		
		this.actionGoTo = new JButton("GO!");
		this.actionGoTo.addActionListener(listener);
		this.actionCourbe = new JButton("GO!");
		this.actionCourbe.addActionListener(listener);
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		JPanel b1 = new JPanel();
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
	    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(this.allerA);

	    JPanel b2 = new JPanel();
	    //Idem pour cette ligne
	   
	    b2.add(x1);
	    b2.add(x);
	    b2.add(y1);
	    b2.add(y);

	    b4 = new JPanel();
	    
	    //Idem pour cette ligne
	    b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
	    b4.add(actionGoTo);
	    
	    JPanel b3 = new JPanel();
	    //Idem pour cette ligne
	    b3.add(vitesse);
	    b3.add(vit);
	    
	    b5 = new JPanel();
	    b5.add(rayonDeCourbure);
	    b5.add(ray);
	    b5.add(actionCourbe);
	    
	    JPanel b6 = new JPanel();
	    b6.add(courbe);
	    
	    this.add(b3);
	    this.add(new JPanel());
	    this.add(b1);
	    this.add(b2);
	    this.add(b4);
	    this.add(new JPanel());
	    this.add(b6);
	    this.add(b5);
	    this.add(new JPanel());
		
		
		
	}
	
	public String obtenirVitesse() throws TexteVideVitesseException
	{
		if ((this.vit.getText().equalsIgnoreCase("")))
			throw new TexteVideVitesseException();
		else return this.vit.getText();
	}
	
	public String obtenirX() throws TexteVideXException
	{
		if ((this.x1.getText().equalsIgnoreCase("")))
			throw new TexteVideXException();
		else return this.x1.getText();
	}
	
	public String obtenirY() throws TexteVideYException
	{
		if ((this.y1.getText().equalsIgnoreCase("")))
			throw new TexteVideYException();
		else return this.y1.getText();
	}
	
	public String obtenirRayonCourbure() throws TexteVideRayonCourbureException
	{
		if ((this.ray.getText().equalsIgnoreCase("")))
			throw new TexteVideRayonCourbureException();
		else return this.ray.getText();
	}
	
	public JPanel obtenirPaneBoutonGoTo()
	{
		return this.b4;
	}
	
	public JPanel obtenirPaneBoutonCourbe()
	{
		return this.b5;
	}


}
