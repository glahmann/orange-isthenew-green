/**
 * 
 */
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
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Garrett Lahmann
 * @version 31 May 2017
 */
public class CalcPane extends JPanel {

    /**
     * 
     */
    private static final int FONT_SIZE = 20;
    
    /**
     * 
     */
    private static CalcPane myCalcPane = null;
    
    
    /**
     * Constructor for the calc pane
     */
    private CalcPane() {
        setBackground(java.awt.Color.ORANGE);
        setLayout(new MigLayout(new LC().align("center", "center")));
        buildCalc();
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
     * Builds the display for the calc pane.
     */
    private final void buildCalc() {
        final JFXPanel fxPanel = new JFXPanel();
        final JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        
        final JLabel prevEnergy = new JLabel("  6/16 Energy Used:  868 kWh");
        prevEnergy.setMinimumSize(new Dimension(400, 100));
        prevEnergy.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel prevBill = new JLabel("  6/16 Bill:  $95.48");
        prevBill.setMinimumSize(new Dimension(400, 100));
        prevBill.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel projEnergy = new JLabel("  6/17 Projected Energy Saved:  54kWh");
        projEnergy.setMinimumSize(new Dimension(400, 100));
        projEnergy.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        final JLabel projSave = new JLabel("  6/17 Projected Savings:  $6.02");
        projSave.setMinimumSize(new Dimension(400, 100));
        projSave.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, FONT_SIZE));
        
        infoPanel.add(prevEnergy);
        infoPanel.add(prevBill);
        infoPanel.add(projEnergy);
        infoPanel.add(projSave);
        add(fxPanel);
        add(infoPanel);
//        add(projSaveLabel);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    /**
     * Builds a line chart contain
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


}
