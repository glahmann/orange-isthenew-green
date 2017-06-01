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
import javax.swing.SwingUtilities;

import javax.swing.JPanel;

/**
 * 
 * @author Garrett Lahmann
 * @version 31 May 2017
 */
public class CalcPane extends JPanel {

    private static CalcPane myCalcPane = null;
    
    
    /**
     * Constructor for the calc pane
     */
    private CalcPane() {
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
//        //testMap = buildMaps();
//        hardcodeMaps();
//
//        //Setup cards
//        myInsulationCard = buildCards("INSULATION", myInsulations); //TODO change to specified maps
//        myLightingCard = buildCards("LIGHTING", myLights);
//        myAppliancecard = buildCards("APPLIANCES", myAppliances);
//        myWindowCard = buildCards("WINDOWS", myWindows);
//
//        //Create and add tabs with the cards
//        addTab("INSULATION", myInsulationCard);
//        addTab("LIGHTING", myLightingCard);
//        addTab("APPLIANCES", myAppliancecard);
//        addTab("WINDOWS", myWindowCard);
        final JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);
//        setSize(300, 200);
//        setVisible(true); // TODO not necessary?
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
