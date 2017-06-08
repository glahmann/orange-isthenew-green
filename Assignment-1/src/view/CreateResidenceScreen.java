/**
 * 
 */
package view;

import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.HousingType;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 * @author Donald Muffler
 * @version 20170602
 */
public class CreateResidenceScreen extends JPanel{

	/**
	 * Singleton instance.
	 */
	private static CreateResidenceScreen myScreen = null;
	
	private JButton myCreateButton;
	
	private JButton myCancelButton;
	
	private JTextField myResNameBox;
	
	private JComboBox<HousingType> myResType;
	
	private static final HousingType[] HOUSING_TYPE= HousingType.values();

	/**
	 * 
	 */
	private CreateResidenceScreen() {
		buildPanel();
	}

	public static final CreateResidenceScreen getInstance() {
		if (myScreen == null) {
			myScreen = new CreateResidenceScreen();
		}
		return myScreen;
	}
	
	public final void setAction(final Action theAction) {
		myCreateButton.addActionListener(theAction);
		myCancelButton.addActionListener(theAction);
	}
	
	public final JComboBox<HousingType> getResSelection() {
		return myResType;
	}
	
	public final JTextField getResNameField() {
		return myResNameBox;
	}
	
	private final void buildPanel() {
		setLayout(new MigLayout(new LC().align("center", "center")));
		final JPanel innerPanel = new JPanel(new GridLayout(0, 1));
		final JPanel namePanel = new JPanel(new MigLayout());
		add(innerPanel);
		
		innerPanel.add(namePanel);
		myResNameBox = new JTextField(20);
		namePanel.add(new JLabel("Name"));
		namePanel.add(myResNameBox);
		innerPanel.add(namePanel);
		
		final JPanel comboPanel = new JPanel();
		myResType = new JComboBox(HOUSING_TYPE);
		comboPanel.add(myResType);
		innerPanel.add(comboPanel);
		
		final JPanel buttonPanel = new JPanel();
		myCancelButton = new JButton("Cancel");
		myCreateButton = new JButton("Create");
		buttonPanel.add(myCancelButton);
		buttonPanel.add(myCreateButton);
		innerPanel.add(buttonPanel);
	}
}