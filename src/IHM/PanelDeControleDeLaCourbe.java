package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Exception.TexteVideCOMException;
import Exception.TexteVideVitesseException;
import Exception.TexteVideXException;
import Exception.TexteVideYException;

public class PanelDeControleDeLaCourbe extends JPanel
{
	private JLabel allerA;
	private JLabel x;
	private JLabel y;
	private JLabel vitesse;

	private JTextField x1;
	private JTextField y1;
	private JTextField vit;
	
	private JButton action;
	
	private JPanel b4;
	
	public PanelDeControleDeLaCourbe(ActionListener listener)
	{
		this.allerA = new JLabel("Aller à :");
		this.x = new JLabel("x");
		this.y = new JLabel("y");
		this.vitesse = new JLabel("Vitesse :");
		
		this.x1 = new JTextField(5);
		this.y1 = new JTextField(5);
		this.vit = new JTextField(5);
		
		this.action = new JButton("GO!");
		this.action.addActionListener(listener);
		
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
	    b4.add(action);
	    
	    JPanel b3 = new JPanel();
	    //Idem pour cette ligne
	    b3.add(vitesse);
	    b3.add(vit);
		
	    this.add(b1);
	    this.add(b2);
	    this.add(b3);
	    this.add(b4);
	    this.add(new JPanel());
		
		
		
	}
	
	public String obtenirVitesse() throws TexteVideVitesseException
	{
		if ((this.vitesse.getText().equalsIgnoreCase("")))
			throw new TexteVideVitesseException();
		else return this.vitesse.getText();
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
	
	public JPanel obtenirPaneBouton()
	{
		return this.b4;
	}


}
