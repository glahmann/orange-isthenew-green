package view;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;

import javax.swing.*;

/**
 * Enter energy bill pane.
 * @author Zira Cook (Initial creation)
 * @author Donald Muffler (Update into Singleton and changed fields around)
 * @version 5/21/2017
 */
public class BillPane extends JPanel {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Singleton for BillPane.
	 */
	private static BillPane myBillPane = null;
	
    /** Size of email text field. */
    private static final int TEXT_FIELD_SIZE = 11;
    
    /**
     * Bill cost.
     */
    private final JTextField myBillCost;
    
    /**
     * Bill start month.
     */
    private final JTextField myStartMonth;
    
    /**
     * Bill end month.
     */
    private final JTextField myEndMonth;
    
    /**
     * Bill start year.
     */
    private final JTextField myStartYear;
    
    /**
     * Bill end year.
     */
    private final JTextField myEndYear;
    
    /**
     * Energy usage.
     */
    private final JTextField myEnergyUsage;
    
    /**
     * Add bill button.
     */
    private final JButton myAddButton;

    /**
     * @author Zira Cook
     * @author Donald Muffler
     * Constructor for the bill pane.
     */
    private BillPane() {
        setBackground(Color.ORANGE);
    	setLayout(new MigLayout(new LC().align("center", "center")));
    	final JPanel topPanel = new JPanel(new MigLayout(new LC().wrapAfter(1)));
    	
    	final JPanel panel1 = new JPanel(new MigLayout());
        panel1.add(new JLabel("Total Bill Cost: $"));
        myBillCost = new JTextField(TEXT_FIELD_SIZE);
        panel1.add(myBillCost, "gapleft 64");
        topPanel.add(panel1);
        
        final JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Start Month/Year MM YYYY: "));
        myStartMonth = new JTextField(5);
        panel2.add(myStartMonth, "cell 1 2");
        myStartYear = new JTextField(5);
        panel2.add(myStartYear);
        topPanel.add(panel2);

        final JPanel panel3 = new JPanel(new MigLayout());
        panel3.add(new JLabel("End Month/Year MM YYYY: "));
        myEndMonth = new JTextField(5);
        panel3.add(myEndMonth, "gapleft 6");
        myEndYear = new JTextField(5);
        panel3.add(myEndYear);
        topPanel.add(panel3);
        
        final JPanel panel4 = new JPanel(new MigLayout());
        panel4.add(new JLabel("Energy Use in kWh: "));
        myEnergyUsage = new JTextField(5);
        panel4.add(myEnergyUsage, "gapleft 90");

        topPanel.add(panel4);
        
        final JPanel buttonPanel = new JPanel(new MigLayout());
        myAddButton = new JButton("Add Bill");
        buttonPanel.add(myAddButton, "gapleft 175");
        topPanel.add(buttonPanel);
        
        add(topPanel);
    }

    /**
     * Gets an instance of the pane
     * @return a singleton
     * @author Donald Muffler
     */
    public final static BillPane getInstance() {
    	if (myBillPane == null) {
    		myBillPane = new BillPane();
    	}
    	return myBillPane;
    }
    
    /**
     * Sets the actions for this panel's buttons.
     * @param theAction the action to set.
     * @author Donald Muffler
     */
    public final void setActions(final Action theAction) {
    	myAddButton.addActionListener(theAction);
    }
    
    /**
     * Getter for bill amount.
     * @return bill amount.
     * @author Donald Muffler
     */
    public final double getBillCost() {
    	return Double.parseDouble(myBillCost.getText());
    }
    
    /**
     * Getter for start month.
     * @return start month.
     * @author Donald Muffler
     */
    public final int getStartMonth() {
    	return Integer.parseInt(myStartMonth.getText());
    }

    /**
     * Getter for end month.
     * @return end month.
     * @author Donald Muffler
     */
    public final int getEndMonth() {
    	return Integer.parseInt(myEndMonth.getText());
    }
    
    /**
     * Getter for end year.
     * @return end year.
     * @author Donald Muffler
     */
    public final int getEndYear() {
    	return Integer.parseInt(myEndYear.getText());
    }
    
    /**
     * Getter for start year.
     * @return start year.
     * @author Donald Muffler
     */
    public final int getStarYear() {
    	return Integer.parseInt(myStartYear.getText());
    }
    
    /**
     * Getter for the energy usage.
     * @return energy usage.
     * @author Donald Muffler
     */
    public final double getEnergyUsage() {
    	return Double.parseDouble(myEnergyUsage.getText());
    }
}