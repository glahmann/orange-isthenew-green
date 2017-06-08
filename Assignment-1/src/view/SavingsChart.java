package view;

// Eclipse has access restriction on javafx libraries
// Every instance of a javafx object will generate a warning
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class SavingsChart extends Application {

    public SavingsChart() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Energy Usage");
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
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series2015, series2016, seriesFuture);
       
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}