package Dessin;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import InterfaceControleurIHM.ObservateurEPuck;
/**
 * Cette classe permet de créer un graphique (nuage de points).
 * Elle est destiné à afficher la position du robot sur l'interface.
 * @author Maxime
 */
public class Graphique  implements ObservateurEPuck{
	
	private static final int HAUTEUR_GRAPHIQUE = 300;
	private static final int LARGEUR_GRAPHIQUE = 500;
	private static final double MIN_X = -50.0;
	private static final double MAX_X = 50.0;
	private static final double ECHELLE_X = 5;
	private static final double MIN_Y = -50.0;
	private static final double MAX_Y = 50.0;
	private static final double ECHELLE_Y = 5;
	
	
	private XYDataset donnee;
	private XYSeriesCollection result;
	private XYSeries series;
	private ChartPanel chartPanel;
	
	/**
	 * Constructeur de la classe
	 * creer un graphique qui contient des points
	 */
	public Graphique()
	{
		
		result = new XYSeriesCollection();
    	series = new XYSeries("Positiondu robot");
    	result.addSeries(series);
    	donnee=result;
    	
    	JFreeChart chart = ChartFactory.createScatterPlot(
                "Position du robot", // chart title
                "X", // x axis label
                "Y", // y axis label
                donnee, // data  ***-----PROBLEM------***
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
                );
    	
    	//On défini l'echelle du graphique
    	XYPlot xyPlot = chart.getXYPlot();
        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        domain.setRange(MIN_X, MAX_X);
        domain.setTickUnit(new NumberTickUnit(ECHELLE_X));
        domain.setVerticalTickLabels(true);
        NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(MIN_Y, MAX_Y);
        range.setTickUnit(new NumberTickUnit(ECHELLE_Y));
        
        //on ajoute le point d'origine
        ajoutPoint(0.0,0.0);
        
        chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(LARGEUR_GRAPHIQUE, HAUTEUR_GRAPHIQUE));       
	}
	
	/**
	 * Permet d'ajouter un point au graphique. L'ajout d'un point dans series met
	 * automatiquement le graphique à jour.
	 * @param x coordonnée x
	 * @param y coordonnée y
	 */
	public void ajoutPoint (double x, double y)
   	{
		System.out.println("J'ajoute le point");
    	series.add(x,y);
   	}


	/**
	 * Methode de l'interface ObservateurEPuck, fait la même chose qu'ajoutPoint
	 */
	@Override
	public void actualiser(double x, double y) {
		System.out.println("Je recoit actualiser");
		this.ajoutPoint(x,y);
		
	}
	
	/**
	 * Permet d'obtenir le graphique afin de l'afficher dans une fenêtre
	 * @return le graphique 
	 */
	public ChartPanel obtenirChartPanel()
	{
		return this.chartPanel;
	}

}
