package IHM;

import javax.swing.*;

public class PanelDeLAccelerometre extends JPanel
{
	public JLabel x;
	public JLabel y;
	public JLabel z;
	public JLabel accelerometre;
	
	public JTextField xT;
	public JTextField yT;
	public JTextField zT;
	
	public PanelDeLAccelerometre()
	{
		this.accelerometre = new JLabel("Accelerometre :");
		
		this.x = new JLabel("x :");
		this.y = new JLabel("y :");
		this.z = new JLabel("z :");
		
		this.xT = new JTextField(5);
		this.yT = new JTextField(5);
		this.zT = new JTextField(5);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(accelerometre);
		this.add(x);
		this.add(xT);
		this.add(y);
		this.add(yT);
		this.add(z);
		this.add(zT);
	}
}
