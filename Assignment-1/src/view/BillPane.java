package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Enter energy bill pane.
 * @author Zira Cook
 * @version 5/21/2017
 */
public class BillPane extends AbstractAction {

    /** Serial ID */
	private static final long serialVersionUID = 6490723052778244792L;

	/** Size of email text field. */
    private static final int TEXT_FIELD_SIZE = 15;

    /** GUI Frame. */
    private final JFrame myFrame;

    /** Frame to display bill input.*/
    private JPanel myBillPanel;

    public BillPane(final JFrame theFrame) {
        super("Bill...");
        myFrame = theFrame;
    }


    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myBillPanel = new JPanel(new MigLayout());

        myBillPanel.add(new JLabel("Total Bill Cost: $"), "cell 0 0");
        final JTextField enterBillAmmount = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterBillAmmount, "cell 1 0");

        myBillPanel.add(new JLabel("Start Month (MM): "), "cell 0 2");
        final JTextField enterBeginMonth = new JTextField(10);
        myBillPanel.add(enterBeginMonth, "cell 1 2");
        myBillPanel.add(new JLabel("Year (YYYY): "), "cell 2 2");
        final JTextField enterBeginYear = new JTextField(10);
        myBillPanel.add(enterBeginYear, "cell 3 2");

        myBillPanel.add(new JLabel("End Month (MM): "), "cell 0 4");
        final JTextField enterEndMonth = new JTextField(10);
        myBillPanel.add(enterEndMonth, "cell 1 4");
        myBillPanel.add(new JLabel("Year (YYYY): "), "cell 2 4");
        final JTextField enterEndYear = new JTextField(10);
        myBillPanel.add(enterEndYear, "cell 3 4");

        JOptionPane.showMessageDialog(myFrame, myBillPanel);

        final String billCost = enterBillAmmount.getText();
        final String startMonth = enterBeginMonth.getText();
        final String startYear = enterBeginYear.getText();
        final String endMonth = enterEndMonth.getText();
        final String endYear = enterEndYear.getText();
        final String billName = startMonth+startYear+endMonth+endYear;
    }
}
