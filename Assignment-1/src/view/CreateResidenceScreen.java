package view;

import java.awt.Color;
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
	 * Serial ID.
	 */
	private static final long serialVersionUID = 7600849599008396691L;

	/**
	 * Singleton instance.
	 */
	private static CreateResidenceScreen myScreen = null;
	
	/**
	 * Create residence button.
	 */
	private JButton myCreateButton;
	
	/**
	 * Cancel button.
	 */
	private JButton myCancelButton;
	
	/**
	 * Residence name field.
	 */
	private JTextField myResNameBox;
	
	/**
	 * Residence type.
	 */
	private JComboBox<HousingType> myResType;
	
	/**
	 * Housing type enums.
	 */
	private static final HousingType[] HOUSING_TYPE = HousingType.values();

	/**
	 * Constructs residence singleton.
	 */
	private CreateResidenceScreen() {
	    setBackground(Color.ORANGE);
		buildPanel();
	}

	/**
	 * Getter for create residence screen singleton.
	 * @return create residence screen.
	 */
	public static final CreateResidenceScreen getInstance() {
		if (myScreen == null) {
			myScreen = new CreateResidenceScreen();
		}
		return myScreen;
	}
	
	/**
	 * Sets the actions for this screen.
	 * @param theAction the action.
	 */
	public final void setAction(final Action theAction) {
		myCreateButton.addActionListener(theAction);
		myCancelButton.addActionListener(theAction);
	}
	
	/**
	 * Getter for the residence selection.
	 * @return the res type enum.
	 */
	public final JComboBox<HousingType> getResSelection() {
		return myResType;
	}
	
	/**
	 * Getter for the residence name.
	 * @return the residence name.
	 */
	public final String getResName() {
		return myResNameBox.getText();
	}
	
	/**
	 * Builds the Panel.
	 */
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
		myResType = new JComboBox<HousingType>(HOUSING_TYPE);
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