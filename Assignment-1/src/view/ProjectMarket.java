package view;

import javax.swing.*;

import model.Item;
import model.Market;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 
     */
    private final static Integer[] QUANTITY_DROP_DOWN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * 
     */
    private static final int FONT_SIZE = 20;

    /**
     * 
     */
    private static final int HORIZONTAL_GAP = 100;

    /**
     * 
     */
    private static ProjectMarket myMarket = null;
    
    /**
     * 
     */
    private final JButton myUpdateButton;
    
    /**
     * 
     */
    private Market myMarketModel;

    /**
     * Constructor for the project market
     */
    private ProjectMarket() {
        myMarketModel = new Market();
        myUpdateButton = new JButton("UPDATE CART");
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
     * 
     * @author Garrett Lahmann
     * @return the market model.
     */
    public Market getMarket() {
        return myMarketModel; // I know it's bad...
    }
    
    /**
     * 
     * @param theAction
     */
    public final void setAction(final Action theAction) {
        myUpdateButton.addActionListener(theAction);
    }

    /**
     * Builds the display for the market page.
     * 
     * @author Zira Cook
     * @author Garrett Lahmann
     */
    private final void buildMarket() {

        //Setup cards
//        myInsulationCard =  
//        myLightingCard = ;
//        myAppliancecard = buildCards("APPLIANCES");
//        myWindowCard = buildCards("WINDOWS");

        //Create and add tabs with the cards
        
        addTab("INSULATION", buildCards("INSULATION"));
        addTab("LIGHTING", buildCards("LIGHTING"));
        addTab("APPLIANCES", buildCards("APPLIANCES"));
        addTab("WINDOWS", buildCards("WINDOWS"));
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
            myMarketModel.addItemPair(itm.getName(), quantities);
            
            JLabel[] itemLabels = {new JLabel(" " + itm.getName()), 
                    new JLabel(" $ " + itm.getCost())};
            
            for(JLabel label: itemLabels) {
                label.setMinimumSize(new Dimension(200, 200));
                setLabelLook(label, thisPanel, Font.PLAIN, FONT_SIZE);
            }
            thePanel.add(thisPanel);
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        myUpdateButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        myUpdateButton.setPreferredSize(new Dimension(350, 100));
        
        bottomPanel.add(myUpdateButton);
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
