package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Enter energy bill pane.
 * @author Zira Cook
 * @version 5/21/2017
 */
public class BillPane extends JPanel {

	private static BillPane myBillPane = null;
	
    /** Size of email text field. */
    private static final int TEXT_FIELD_SIZE = 15;
    
    /** Amount of the bill. */
    private final int myBillCost;
    
    /** Start month of the bill. */
    private final int myStartMonth;
    
    /** end month of the bill. */
    private final int myEndMonth;
    
    /** End year of the bill.*/
    private final int myEndYear;
    
    /** Start year for the bill. */
    private final int myStartYear;
    
    /**
     * Name for the bill.
     */
    private final String myBillName;

    /**
     * Constructor for the bill pane.
     */
    private BillPane() {
    	setLayout(new MigLayout());

        add(new JLabel("Total Bill Cost: $"), "cell 0 0");
        final JTextField enterBillAmmount = new JTextField(TEXT_FIELD_SIZE);
        add(enterBillAmmount, "cell 1 0");

        add(new JLabel("Start Month (MM): "), "cell 0 2");
        final JTextField enterBeginMonth = new JTextField(10);
        add(enterBeginMonth, "cell 1 2");
        add(new JLabel("Year (YYYY): "), "cell 2 2");
        final JTextField enterBeginYear = new JTextField(10);
        add(enterBeginYear, "cell 3 2");

        add(new JLabel("End Month (MM): "), "cell 0 4");
        final JTextField enterEndMonth = new JTextField(10);
        add(enterEndMonth, "cell 1 4");
        add(new JLabel("Year (YYYY): "), "cell 2 4");
        final JTextField enterEndYear = new JTextField(10);
        add(enterEndYear, "cell 3 4");
        
       myBillCost = Integer.parseInt(enterBillAmmount.getText());
       
       myStartMonth = Integer.parseInt(enterBeginMonth.getText());
       myStartYear = Integer.parseInt(enterBeginYear.getText());
       myEndMonth = Integer.parseInt(enterEndMonth.getText());
       myEndYear = Integer.parseInt(enterEndYear.getText());
       myBillName = String.valueOf(myStartMonth+myStartYear+myEndMonth+myEndYear); //TODO: change or remove?
    }

    /**
     * Gets an instance of the pane
     * @return a singleton
     */
    public final BillPane getInstance() {
    	if (myBillPane == null) {
    		myBillPane = new BillPane();
    	}
    	return myBillPane;
    }
    
    public final void setActions(final Action theAction) {
    	
    }
    
    /**
     * Getter for bill amount.
     * @return bill amount.
     */
    public final int getBillCost() {
    	return myBillCost;
    }
    
    /**
     * Getter for start month.
     * @return start month.
     */
    public final int getStartMonth() {
    	return myStartMonth;
    }

    /**
     * Getter for end month.
     * @return end month.
     */
    public final int getEndMonth() {
    	return myEndMonth;
    }
    
    /**
     * Getter for end year.
     * @return end year.
     */
    public final int getEndYear() {
    	return myEndYear;
    }
    
    /**
     * Getter for bill name.
     * @return bill name.
     */
    public final String getBillName() {
    	return myBillName;
    }
    
    /**
     * Getter for start year.
     * @return start year.
     */
    public final int getStarYear() {
    	return myStartYear;
    }
}