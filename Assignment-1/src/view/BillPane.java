package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Enter energy bill pane.
 * @author Zira Cook
 * @version 5/21/2017
 */
public class BillPane extends AbstractAction {

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


        myBillPanel.add(new JLabel("Name of Bill: "), "cell 0 0");
        final JTextField billNameBox = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(billNameBox, "cell 1 0");

        myBillPanel.add(new JLabel("Total Bill Cost: $"), "cell 0 1");
        final JTextField enterBillAmmount = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterBillAmmount, "cell 1 1");

        myBillPanel.add(new JLabel("Starting Month (MM): "), "cell 0 2");
        final JTextField enterBeginMonth = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterBeginMonth, "cell 1 2");
        myBillPanel.add(new JLabel("Starting Year (YYYY): "), "cell 0 3");
        final JTextField enterBeginYear = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterBeginYear, "cell 1 3");

        myBillPanel.add(new JLabel("Ending Month (MM): "), "cell 0 4");
        final JTextField enterEndMonth = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterEndMonth, "cell 1 4");
        myBillPanel.add(new JLabel("Starting Year (YYYY): "), "cell 0 5");
        final JTextField enterEndYear = new JTextField(TEXT_FIELD_SIZE);
        myBillPanel.add(enterEndYear, "cell 1 5");

        JOptionPane.showMessageDialog(myFrame, myBillPanel);

        final String billName = billNameBox.getText();
        final String billCost = enterBillAmmount.getText();
        final String startMonth = enterBeginMonth.getText();
        final String startYear = enterBeginYear.getText();
        final String endMonth = enterEndMonth.getText();
        final String endYear = enterEndYear.getText();
    }
}
