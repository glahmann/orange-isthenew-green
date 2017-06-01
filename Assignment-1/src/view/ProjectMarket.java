package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zira Cook
 * @version 5/31/17
 */
final public class ProjectMarket extends JTabbedPane {

    private final static Integer[] QUANTITY_DROP_DOWN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final int FONT_SIZE = 20;

    private static final int HORIZONTAL_GAP = 100;

    private static ProjectMarket myMarket = null;

    private JPanel myInsulationCard;

    private JPanel myLightingCard;

    private JPanel myAppliancecard;

    private JPanel myWindowCard;

    private HashMap<String, Double> myInsulations;

    private HashMap<String, Double> myLights;

    private HashMap<String, Double> myAppliances;

    private HashMap<String, Double> myWindows;

    private HashMap<String, Double> testMap; //TODO delete



    /**
     * Constructor for the project market
     */
    private ProjectMarket() {
        myInsulations = new HashMap<>();
        myLights = new HashMap<>();
        myAppliances = new HashMap<>();
        myWindows = new HashMap<>();
        buildMarket();
    }

    /**
     * Getter for the market.
     * @return the market.
     */
    public final static ProjectMarket getInstance() {
        if (myMarket == null) {
            myMarket = new ProjectMarket();
        }
        return myMarket;
    }

    /**
     * Builds the display for the market page.
     */
    private final void buildMarket() {
        //testMap = buildMaps();
        hardcodeMaps();

        //Setup cards
        myInsulationCard = buildCards("INSULATION", myInsulations); //TODO change to specified maps
        myLightingCard = buildCards("LIGHTING", myLights);
        myAppliancecard = buildCards("APPLIANCES", myAppliances);
        myWindowCard = buildCards("WINDOWS", myWindows);

        //Create and add tabs with the cards
        addTab("INSULATION", myInsulationCard);
        addTab("LIGHTING", myLightingCard);
        addTab("APPLIANCES", myAppliancecard);
        addTab("WINDOWS", myWindowCard);
    }

    /**
     * Builds the cards for each tab
     * @param theTitle the title of the tab
     * @param theMap the map associated with tab data
     * @return the finished tab
     */
    private final JPanel buildCards(final String theTitle, HashMap<String, Double> theMap) {
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(7, 1));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP, 10));

        JLabel[] topLabels = {new JLabel("Quantity"), new JLabel("Item Name"), new JLabel("Price")};

        for(JLabel label: topLabels) {
            setLabelLook(label, topPanel, Font.BOLD, FONT_SIZE);
        }

        thePanel.add(topPanel);

        for(Map.Entry<String, Double> entry : theMap.entrySet()) {
            JPanel thisPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP , 0));
            JComboBox<Integer> quantities = new JComboBox<>(QUANTITY_DROP_DOWN);
            quantities.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));

            thisPanel.add(quantities);

            JLabel[] itemLabels = {new JLabel(" " + entry.getKey()),
                    new JLabel(" $ " + entry.getValue().toString())};

            for(JLabel label: itemLabels) {
                label.setMinimumSize(new Dimension(200, 200));
                setLabelLook(label, thisPanel, Font.PLAIN, FONT_SIZE);
            }

            thePanel.add(thisPanel);
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton updateButton = new JButton("UPDATE CART");
        updateButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        updateButton.setPreferredSize(new Dimension(350, 100));
        bottomPanel.add(updateButton);
        thePanel.add(bottomPanel);

        return thePanel;
    }

    /**
     * Populates a map for displaying.
     * @return the map with all values.
     */
    private final HashMap<String, Double> buildMaps() { //TODO connect with Market.java data
        HashMap<String, Double> theMap = new HashMap<>();

        return theMap;
    }

    /**
     * Sets up a label
     * @param currentLabel the label to set
     * @param parentPanel the panel the label will be added to
     * @param style the font style
     * @param fontSize the font size
     */
    private final void setLabelLook(JLabel currentLabel, JPanel parentPanel, int style, int fontSize) { //TODO take in dimension
        currentLabel.setFont(new Font("Times New Roman", style, fontSize));

        if (!currentLabel.getText().equals("Quantity")) {
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setPreferredSize(new Dimension(400, 20));
        }

        parentPanel.add(currentLabel);
    }

    private final void hardcodeMaps() {
        myInsulations.put("Faced Insulation Roll 15 in x 25 ft", 26.50);
        myInsulations.put("Insulating Foam Single Can 16 oz", 6.75);
        myInsulations.put("Acoustic Insulation Panel 12 in x 12 in", 29.99);
        myInsulations.put("Denim Insulation Bag 16 in x 48 in", 10.98);
        myInsulations.put("Blow-in Insulation Bag 19 lbs", 11.95);

        myLights.put("LED Soft White 60W Pack",7.97);
        myLights.put("CFL Spiral Soft Daylight 60w Pack", 5.97);
        myLights.put("Halogen Flood Light 100w Pack", 9.97);
        myLights.put("Incandescent Dimmable 65w Pack", 11.97);
        myLights.put("LED Daylight 100w Pack", 12.97);

        myAppliances.put("High-Efficiency Top Load Washer", 577.80);
        myAppliances.put("Front Load Dryer, Energy Star", 747.90);
        myAppliances.put("Whirlpool Dishwasher, Energy Star", 397.80);
        myAppliances.put("LG Eco Bottom Freezer Refrigerator", 1147.50);
        myAppliances.put("GE Window Air Conditioner, Energy Star", 249.00);

        myWindows.put("Single Hung Window 23.5 in x 35.5 in", 88.96);
        myWindows.put("Left-Hand Sliding Window 35.5 in x 35.5 in", 118.00);
        myWindows.put("Double Hung Window 27.75 in x 57.25 in", 167.00);
        myWindows.put("Left-Hand Casement Window 23.5 in x 35.5 in", 185.00);
        myWindows.put("Hopper Basement Window 31.75 in x 15.75 in", 55.52);

    }

}
