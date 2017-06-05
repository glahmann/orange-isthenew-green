package view;

import javax.swing.*;

import model.Item;
import model.Market;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Zira Cook
 * @author Garrett Lahmann
 * @version 6/5/17
 */
final public class ProjectMarket extends JTabbedPane {

    /**
     * 
     */
    private static final long serialVersionUID = -2339981887842998145L;

    private final static Integer[] QUANTITY_DROP_DOWN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final int FONT_SIZE = 20;

    private static final int HORIZONTAL_GAP = 100;

    private static ProjectMarket myMarket = null;

    private JPanel myInsulationCard;

    private JPanel myLightingCard;

    private JPanel myAppliancecard;

    private JPanel myWindowCard;
    
    private Market myMarketModel;

    /**
     * Constructor for the project market
     */
    private ProjectMarket() {
        myMarketModel = new Market();
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
     * 
     * @author Zira Cook
     * @author Garrett Lahmann
     */
    private final void buildMarket() {

        //Setup cards
        myInsulationCard = buildCards("INSULATION"); //TODO change to specified maps
        myLightingCard = buildCards("LIGHTING");
        myAppliancecard = buildCards("APPLIANCES");
        myWindowCard = buildCards("WINDOWS");

        //Create and add tabs with the cards
        addTab("INSULATION", myInsulationCard);
        addTab("LIGHTING", myLightingCard);
        addTab("APPLIANCES", myAppliancecard);
        addTab("WINDOWS", myWindowCard);
    }

    /**
     * Builds the cards for each tab
     * 
     * @author Zira Cook
     * @author Garrett Lahmann
     * @param theTitle the title of the tab
     * @param theMap the map associated with tab data
     * @return the finished tab
     */
    private final JPanel buildCards(final String theTitle) {
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(7, 1));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP, 10));

        JLabel[] topLabels = {new JLabel("Quantity"), new JLabel("Item Name"), new JLabel("Price")};

        for(JLabel label: topLabels) {
            setLabelLook(label, topPanel, Font.BOLD, FONT_SIZE);
        }
        thePanel.add(topPanel);

        // Get copy of item list by type
        // TODO Simplify market to only hold one type at time, then query for new types and item selection?
        ArrayList<Item> items = myMarketModel.getItems(theTitle);
        
        for(Item itm: items) { 
            JPanel thisPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP , 0));
            JComboBox<Integer> quantities = new JComboBox<>(QUANTITY_DROP_DOWN);
            quantities.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));

            thisPanel.add(quantities);       
            
            JLabel[] itemLabels = {new JLabel(" " + itm.getName()), 
                    new JLabel(" $ " + itm.getCost())};
            
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
     * Sets up a label
     * @param currentLabel the label to set
     * @param parentPanel the panel the label will be added to
     * @param style the font style
     * @param fontSize the font size
     */
    private void setLabelLook(JLabel currentLabel, JPanel parentPanel, int style, int fontSize) { //TODO take in dimension
        currentLabel.setFont(new Font("Times New Roman", style, fontSize));

        if (!currentLabel.getText().equals("Quantity")) {
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setPreferredSize(new Dimension(400, 20));
        }

        parentPanel.add(currentLabel);
    }

}
