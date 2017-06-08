package view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Calc;
import model.Item;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Garrett Lahmann
 * @version 8 June 2017
 */
public class CalcPane extends JPanel implements Observer {

    /**
     * Default font size.
     */
    private static final int FONT_SIZE = 20;

    /**
     * Average cost per kilowatt hour.
     */
    private static final double POWER_COST = 0.11;

    /**
     * 
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(".##");
    
    /**
     * Instance of this class for Singletons.
     */
    private static CalcPane myCalcPane = null;

    /**
     * The energy used.
     */
    private double myEnergyUsed;

    /**
     * The cost of the bill.
     */
    private double myBillCost;

    /**
     * The month for the bill.
     */
    private int myMonth;

    /**
     * The year for the bill.
     */
    private int myYear;

    /**
     * Estimated saved watts.
     */
    private double myProjectedEnergySavings;

    /**
     * Estimated saved money.
     */
    private double myProjectedBillSavings;
    
    /**
     * The javaFX panel for the chart.
     */
    private final JFXPanel myFxPanel;


    /**
     * Constructor for the calc pane
     */
    private CalcPane() {
        setLayout(new BorderLayout());
        
        buildTopPanel();
        
        myFxPanel = new JFXPanel();
        myProjectedBillSavings = 0.0;
        myProjectedEnergySavings = 0.0;
    }
    
    /**
     * Getter for the calc pane.
     * 
     * @return the calc pane.
     */
    public final static CalcPane getInstance() {
        if (myCalcPane == null) {
            myCalcPane = new CalcPane();
        }
        return myCalcPane;
    }
    
	/**
	 * Builds the top panel with the back button.
	 */
	private final void buildTopPanel() {
		final JPanel topPanel = new JPanel();
		final JButton backButton = new JButton("Back");
		topPanel.setBackground(java.awt.Color.ORANGE);
		topPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		topPanel.add(backButton, "cell 0 0");
		add(topPanel, BorderLayout.NORTH);
		
		/**
		 * Inner class for handling the back button action.
		 */
		class BackAction implements ActionListener {

			/**
			 * Action listener for the back button.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.getInstance().displayPanel("Home");
			}
		}
		backButton.addActionListener(new BackAction());
	}

    /**
     * Builds the display for the calc pane.
     */
    private final void buildCalc() {
        
        final JPanel centerPanel = new JPanel(new MigLayout(new LC().align("center", "center")));
        centerPanel.setBackground(java.awt.Color.ORANGE);
 
        final JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        
        final JLabel prevEnergy = new JLabel(" " + myMonth + "/" + myYear + "  Energy Used: " + myEnergyUsed + " kWh");
        prevEnergy.setMinimumSize(new Dimension(400, 100));
        prevEnergy.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel prevBill = new JLabel(" " + myMonth + "/" + myYear +"  Bill:  $" + myBillCost);
        prevBill.setMinimumSize(new Dimension(400, 100));
        prevBill.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel projEnergy = new JLabel("  Projected Energy Saved: " + DECIMAL_FORMAT.format(myProjectedEnergySavings) + " kWh");
        projEnergy.setMinimumSize(new Dimension(400, 100));
        projEnergy.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel projSave = new JLabel("  Projected Savings:  $" + DECIMAL_FORMAT.format(myProjectedBillSavings));
        projSave.setMinimumSize(new Dimension(400, 100));
        projSave.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        
        infoPanel.add(prevEnergy);
        infoPanel.add(prevBill);
        infoPanel.add(projEnergy);
        infoPanel.add(projSave);
        centerPanel.add(myFxPanel);
        centerPanel.add(infoPanel);
        add(centerPanel);
        runJfx();
    }

    /**
     * Runs an embedded javafx panel.
     */
    private void runJfx() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = createScene();
                myFxPanel.setScene(scene);
            }
        });
    }

    /**
     * Builds a line chart containing energy usage data.
     * 
     * @return scene A line chart on a javafx scene.
     */
    private static Scene createScene() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        yAxis.setForceZeroInRange(false);
        yAxis.setLabel("kWh");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Energy Usage");
                          
        XYChart.Series series2015 = new XYChart.Series();
        series2015.setName("2015");
        
        series2015.getData().add(new XYChart.Data("Jan", 1011));
        series2015.getData().add(new XYChart.Data("Feb", 1105));
        series2015.getData().add(new XYChart.Data("Mar", 999));
        series2015.getData().add(new XYChart.Data("Apr", 1007));
        series2015.getData().add(new XYChart.Data("May", 950));
        series2015.getData().add(new XYChart.Data("Jun", 900));
        series2015.getData().add(new XYChart.Data("Jul", 875));
        series2015.getData().add(new XYChart.Data("Aug", 822));
        series2015.getData().add(new XYChart.Data("Sep", 860));
        series2015.getData().add(new XYChart.Data("Oct", 920));
        series2015.getData().add(new XYChart.Data("Nov", 955));
        series2015.getData().add(new XYChart.Data("Dec", 940));
        
        XYChart.Series series2016 = new XYChart.Series();
        series2016.setName("2016");
        series2016.getData().add(new XYChart.Data("Jan", 1000));
        series2016.getData().add(new XYChart.Data("Feb", 1029));
        series2016.getData().add(new XYChart.Data("Mar", 992));
        series2016.getData().add(new XYChart.Data("Apr", 975));
        series2016.getData().add(new XYChart.Data("May", 911));
        series2016.getData().add(new XYChart.Data("Jun", 868));
        series2016.getData().add(new XYChart.Data("Jul", 851));
        series2016.getData().add(new XYChart.Data("Aug", 791));
        series2016.getData().add(new XYChart.Data("Sep", 850));
        series2016.getData().add(new XYChart.Data("Oct", 902));
        series2016.getData().add(new XYChart.Data("Nov", 923));
        series2016.getData().add(new XYChart.Data("Dec", 930));
        
        XYChart.Series seriesFuture = new XYChart.Series();
        seriesFuture.setName("2017 Projected");
        seriesFuture.getData().add(new XYChart.Data("Jan", 973));
        seriesFuture.getData().add(new XYChart.Data("Feb", 1009));
        seriesFuture.getData().add(new XYChart.Data("Mar", 978));
        seriesFuture.getData().add(new XYChart.Data("Apr", 960));
        seriesFuture.getData().add(new XYChart.Data("May", 899));
        seriesFuture.getData().add(new XYChart.Data("Jun", 851));
        seriesFuture.getData().add(new XYChart.Data("Jul", 840));
        seriesFuture.getData().add(new XYChart.Data("Aug", 780));
        seriesFuture.getData().add(new XYChart.Data("Sep", 838));
        seriesFuture.getData().add(new XYChart.Data("Oct", 890));
        seriesFuture.getData().add(new XYChart.Data("Nov", 907));
        seriesFuture.getData().add(new XYChart.Data("Dec", 915));

        Scene  scene  =  new  Scene(lineChart,800,600);
        lineChart.getData().addAll(series2015, series2016, seriesFuture);

        return (scene);
    }


    /**
     * Update method for observer.
     */
    @Override
    public void update(Observable theObservable, Object theObject) {
        //Checks for an arraylist of doubles
        if (theObject instanceof ArrayList) {
            if (((ArrayList) theObject).size() > 0) {
                if (((ArrayList) theObject).get(0) instanceof Double) {
                    updateValues(theObject);
                } else if (((ArrayList) theObject).get(0) instanceof Item) {
                    calculateSavings(theObject);
                }
            }
        }
        runJfx(); // Creates a new chart thread. Not sure what happens to old threads.
        buildCalc();
    }

    /**
     * 
     * @param theObject
     */
    private void calculateSavings(Object theObject) {
        myProjectedEnergySavings = Calc.calculate((ArrayList<Item>)theObject);

        myProjectedBillSavings = myProjectedEnergySavings * POWER_COST;
    }

    /**
     * 
     * @param theObject
     */
    private final void updateValues(Object theObject) {
        ArrayList<Double> bills = (ArrayList<Double>) theObject;
        int recentMonth = Integer.MIN_VALUE, recentYear = Integer.MIN_VALUE;
        int currentMonth, currentYear;

        double recentAmmount = 0, recentUsage = 0;
        double currentAmmount = 0, currentUsage = 0;

        for (int i = 0; i < bills.size(); i += 4) {
            //Gets all values for current bill
            currentMonth =  bills.get(i).intValue();
            currentYear = bills.get(i + 1).intValue();
            currentAmmount = bills.get(i + 2);
            currentUsage = bills.get(i + 3);

            //Finds the most recent bill
            if (currentYear > recentYear) {
                recentYear = currentYear;
                recentMonth = currentMonth;
                recentAmmount = currentAmmount;
                recentUsage = currentUsage;

            } else if (currentYear == recentYear) {
                if (currentMonth > recentMonth) {
                    recentYear = currentYear;
                    recentMonth = currentMonth;
                    recentAmmount = currentAmmount;
                    recentUsage = currentUsage;
                }
            }
        }

        myBillCost = recentAmmount;
        myEnergyUsed = recentUsage;
        myYear = recentYear;
        myMonth = recentMonth;
    }
}