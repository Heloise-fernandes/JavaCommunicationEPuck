package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelDeDetectionViaCapteurIR extends JPanel
{
	public JLabel capteur;
	
	public JProgressBar ir1;
	public JProgressBar ir2;
	public JProgressBar ir3;
	public JProgressBar ir4;
	public JProgressBar ir5;
	public JProgressBar ir6;
	public JProgressBar ir7;
	public JProgressBar ir8;
	
	public JPanel paneHaut;
	public JPanel paneBas;
	
	public PanelDeDetectionViaCapteurIR()
	{
		this.ir1 = new JProgressBar();
		this.ir2 = new JProgressBar();
		this.ir3 = new JProgressBar();
		this.ir4 = new JProgressBar();
		this.ir5 = new JProgressBar();
		this.ir6 = new JProgressBar();
		this.ir7 = new JProgressBar();
		this.ir8 = new JProgressBar();
		
		this.capteur = new JLabel("Capteurs IR :");
		
		this.paneHaut = new JPanel();
		this.paneBas = new JPanel();
		
		this.paneHaut.setLayout(new BorderLayout());
		this.paneHaut.add(capteur,BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout());
		
		this.paneBas.setLayout(new GridLayout(4,5));
		
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir1);
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir2);
		this.paneBas.add(new JLabel());
		
		this.paneBas.add(ir3);
		this.paneBas.add(new JLabel());
		this.paneBas.add(new JLabel());
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir4);
		
		this.paneBas.add(ir5);
		this.paneBas.add(new JLabel());
		this.paneBas.add(new JLabel());
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir6);
		
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir7);
		this.paneBas.add(new JLabel());
		this.paneBas.add(ir8);
		this.paneBas.add(new JLabel());
		
		this.add(paneHaut,BorderLayout.NORTH);
		this.add(paneBas);

		
	}
}
