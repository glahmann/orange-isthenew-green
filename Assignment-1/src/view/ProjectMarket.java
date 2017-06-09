package view;

import javax.swing.*;

import model.Item;
import model.Market;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.util.ArrayList;

/**
 * GUI class to display the project market.
 * 
 * @author Zira Cook
 * @author Garrett Lahmann
 * @version 6/5/17
 */
final public class ProjectMarket extends JPanel {

    /**
     * Serialized ID for the object.
     */
    private static final long serialVersionUID = -2339981887842998145L;

    /**
     * Array to populate combo boxes for quantities.
     */
    private final static Integer[] QUANTITY_DROP_DOWN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * Default font size.
     */
    private static final int FONT_SIZE = 20;

    /**
     * Default horizontal gap for flow layout.
     */
    private static final int HORIZONTAL_GAP = 100;

    /**
     * Project market instance for singleton use.
     */
    private static ProjectMarket myMarket = null;
    
    /**
     * ArrayList of update buttons.
     */
    private final ArrayList<JButton> myUpdateButtons;
    
    /**
     * List of view cart buttons.
     */
    private final ArrayList<JButton> myViewButtons;
    
    private JButton myBackButton;
    
    /**
     * Market for the display.
     */
    private Market myMarketModel;

    /**
     * Constructor for the project market
     */
    private ProjectMarket() {
        setBackground(Color.GREEN);
        myMarketModel = new Market();
        myUpdateButtons = new ArrayList<JButton>();
        myViewButtons = new ArrayList<JButton>();
        buildMarket();
    }

    /**
     * Getter for the Singleton market GUI instance.
     * @return the market.
     */
    public final static ProjectMarket getInstance() {
        if (myMarket == null) {
            myMarket = new ProjectMarket();
        }
        return myMarket;
    }
    
    /**
     * Gets the current market model.
     * 
     * @author Garrett Lahmann
     * @return the market model.
     */
    public Market getMarket() {
        return myMarketModel; // I know it's bad...
    }
    
    /**
     * Adds action listeners to all update and view cart buttons on market GUI.
     * 
     * @author Garrett Lahmann
     * @param theAction An action listener.
     */
    public final void setAction(final Action theAction) {
        for (JButton btn: myUpdateButtons) {
            btn.addActionListener(theAction);
        }
        for (JButton btn: myViewButtons) {
            btn.addActionListener(theAction);
        }
        myBackButton.addActionListener(theAction);
    }

    /**
     * Builds the display for the market page.
     * 
     * @author Zira Cook
     * @author Garrett Lahmann
     * @author Donald Muffler
     */
    private final void buildMarket() {
    	setLayout(new BorderLayout());
    	buildTopPanel();
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("INSULATION", buildCards("INSULATION"));
        tabbedPane.addTab("LIGHTING", buildCards("LIGHTING"));
        tabbedPane.addTab("APPLIANCES", buildCards("APPLIANCES"));
        tabbedPane.addTab("WINDOWS", buildCards("WINDOWS"));
        add(tabbedPane);
    }
    
    /**
     * @author Donald Muffler
     * 
     * Panel for traversing back.
     */
    private final void buildTopPanel() {
    	final JPanel topPanel = new JPanel(new MigLayout("", "[]", "[]"));
    	topPanel.setBackground(Color.ORANGE);
		myBackButton = new JButton("Back To Projects");
		topPanel.add(myBackButton, "cell 0 0");
		add(topPanel, BorderLayout.NORTH);
    }

    /**
     * Builds the cards for each tab.
     * 
     * @author Zira Cook
     * @author Garrett Lahmann
     * @param theTitle The title of the tab.
     * @return The finished tab.
     */
    private final JPanel buildCards(final String theTitle) {
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(7, 1));
        thePanel.setBackground(Color.GREEN);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP, 10));
        topPanel.setBackground(Color.GREEN);

        JLabel[] topLabels = {new JLabel("Quantity"), new JLabel("Item Name"), new JLabel("Price")};

        for(JLabel label: topLabels) {
            setLabelLook(label, topPanel, Font.BOLD, FONT_SIZE);
        }
        thePanel.add(topPanel);

        // Get copy of item list by type
        ArrayList<Item> items = myMarketModel.getItems(theTitle);
        
        // Add items to panels for display
        for(Item itm: items) { 
            JPanel thisPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP , 0));
            thisPanel.setBackground(Color.GREEN);
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
        bottomPanel.setBackground(Color.GREEN);
        
        JButton updateButton = new JButton("ADD TO PROJECT");
        JButton viewButton = new JButton("VIEW PROJECT ITEMS");
        viewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        updateButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        viewButton.setPreferredSize(new Dimension(350, 100));
        updateButton.setPreferredSize(new Dimension(350, 100));
        
        myUpdateButtons.add(updateButton);
        myViewButtons.add(viewButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(viewButton);
        thePanel.add(bottomPanel);

        return thePanel;
    }

    /**
     * Sets up a label.
     * 
     * @author Zira Cook
     * @param currentLabel The label to set.
     * @param parentPanel The panel the label will be added to.
     * @param style The font style.
     * @param fontSize The font size.
     */
    private void setLabelLook(JLabel currentLabel, JPanel parentPanel, int style, int fontSize) {
        currentLabel.setFont(new Font("Times New Roman", style, fontSize));

        if (!currentLabel.getText().equals("Quantity")) {
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setMinimumSize(new Dimension(400, 20));
            currentLabel.setPreferredSize(new Dimension(400, 20));
        }

        parentPanel.add(currentLabel);
    }
}