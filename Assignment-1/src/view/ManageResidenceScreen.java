package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import net.miginfocom.swing.MigLayout;

/**
 * Singleton for resident management screen.
 * 
 * @author Donald Muffler
 * @version 20170524
 */
public final class ManageResidenceScreen extends JScrollPane implements Observer {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 4304685901234127360L;
	
	/**
	 * Singleton instance for Manage Residence screen.
	 */
	private static ManageResidenceScreen myResidenceScreen = null;
	
	/**
	 * Size of font on the page.
	 */
	private static final int FONT_SIZE = 20;
	
	/**
	 * Hashmap to store buttons
	 */
	private HashMap<String, JCheckBox> myCheckBoxes;
	
	/**
	 * Delete residence button.
	 */
	private JButton myDeleteButton;
	
	/**
	 * Create residence button.
	 */
	private JButton myCreateButton;
	
	/**
	 * Choose residence button.
	 */
	private JButton myChooseButton;
	
	/**
	 * Back button.
	 */
	private JButton myBackButton;
	
	/**
	 * Name header.
	 */
	private JLabel myNameTitle;
	
	/**
	 * Type header.
	 */
	private JLabel myTypeTitle;
	
	/**
	 * Project number header.
	 */
	private JLabel myProjectsTitle;
	
	/**
	 * Displays the content.
	 */
	private JPanel myContentPanel;
	
	/**
	 * Holds the content panel.
	 */
	private JPanel myContentPanelHolder;
	
	/**
	 * Spring layout used for the content panel.
	 */
	private SpringLayout mySpringLayout;
	
	
	/**
	 * Private constructor to prevent instantiation.
	 */
	private ManageResidenceScreen() {
		myContentPanelHolder = new JPanel(new BorderLayout());
		setViewportView(myContentPanelHolder);
		buildTopPanel();
		buildContentPanel();
		buildBottomPanel();
	}
	
	/**
	 * Sets the action for this panel's buttons.
	 * @param theAction
	 */
	public final void setAcion(final Action theAction) {
		myDeleteButton.addActionListener(theAction);
		myChooseButton.addActionListener(theAction);
		myCreateButton.addActionListener(theAction);
		myBackButton.addActionListener(theAction);
	}
	
	/**
	 * Singleton getter for this instance. Creates an instance if one does not exist.
	 * @return Singleton instance for ManageResidenceScreen.
	 */
	public static final ManageResidenceScreen getInstance() {
		if (myResidenceScreen == null) {
			myResidenceScreen = new ManageResidenceScreen();
		}
		return myResidenceScreen;
	}

	/**
	 * Updates the panel with the residence information.
	 */
	@Override
	public void update(Observable theObservable, Object theObject) {
		//Checks if the object is an arraylist of strings
        //This deals with the user updating an arraylist of doubles
        if (theObject instanceof ArrayList) {
        	if (((ArrayList) theObject).size() > 0) {
	            if (((ArrayList<String>) theObject).get(((ArrayList) theObject).size() - 1) instanceof String) {
	                myContentPanelHolder.remove(myContentPanel);
	                buildContentPanel();
	                updatePanel(theObject);
	            }
        	}
		}
	}
	
	/**
	 * Builds the top panel with the back button.
	 */
	private final void buildTopPanel() {
		final JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		setColumnHeaderView(topPanel);
		topPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		myBackButton = new JButton("Back");
		topPanel.add(myBackButton, "cell 0 0");
	}
	
	public final HashMap<String, JCheckBox> checkSelected() {
		return (HashMap<String, JCheckBox>) myCheckBoxes.clone();
	}
	
	/**
	 * Builds the content panel that displays the residence information.
	 */
	private final void buildContentPanel() {
		
		myContentPanel = new JPanel();
		myContentPanel.setBackground(Color.GREEN);
		myContentPanelHolder.add(myContentPanel);
		mySpringLayout = new SpringLayout();
		myContentPanel.setLayout(mySpringLayout);
		
		myNameTitle = new JLabel("Name");
		myNameTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringLayout.putConstraint(SpringLayout.NORTH, myNameTitle, 10, SpringLayout.NORTH, myContentPanel);
		mySpringLayout.putConstraint(SpringLayout.WEST, myNameTitle, 40, SpringLayout.WEST, myContentPanel);
		myContentPanel.add(myNameTitle);
		
		myTypeTitle = new JLabel("Type");
		myTypeTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringLayout.putConstraint(SpringLayout.NORTH, myTypeTitle, 0, SpringLayout.NORTH, myNameTitle);
		mySpringLayout.putConstraint(SpringLayout.WEST, myTypeTitle, 400, SpringLayout.EAST, myNameTitle);
		myContentPanel.add(myTypeTitle);
		
		myProjectsTitle = new JLabel("Projects");
		myProjectsTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringLayout.putConstraint(SpringLayout.NORTH, myProjectsTitle, 0, SpringLayout.NORTH, myNameTitle);
		mySpringLayout.putConstraint(SpringLayout.WEST, myProjectsTitle, 400, SpringLayout.EAST, myTypeTitle);
		myContentPanel.add(myProjectsTitle);
	}
	
	/**
	 * Populates the content panel with residence information. 
	 * @param theString the information.
	 * @param theRelativeYPosition relative position to the title tag.
	 * @param theRelativeLabel the relative label used for new label positioning.
	 * @param theButtonGroup the button group for the checkboxes.
	 * @param theBoolean denotes the creation of a check box.
	 * @param theMultiplier multiplier used for information placement.
	 * @return the residence information which includes placement.
	 */
	private final JLabel populateContentPanel(final String theString, final int theRelativeYPosition, final JLabel theRelativeLabel,
									   final ButtonGroup theButtonGroup, final boolean theBoolean, final int theMultiplier) {
		final JLabel newLabel = new JLabel(theString);
		newLabel.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));
		mySpringLayout.putConstraint(SpringLayout.NORTH, newLabel, theRelativeYPosition * theMultiplier, SpringLayout.NORTH, theRelativeLabel);
		mySpringLayout.putConstraint(SpringLayout.WEST, newLabel, 0, SpringLayout.WEST, theRelativeLabel);
		
		if (theBoolean) {
			final JCheckBox checkBox = new JCheckBox();
			mySpringLayout.putConstraint(SpringLayout.EAST, checkBox, -10, SpringLayout.WEST, newLabel);
			mySpringLayout.putConstraint(SpringLayout.NORTH, checkBox, 0, SpringLayout.NORTH, newLabel);
			theButtonGroup.add(checkBox);
			myContentPanel.add(checkBox);
			myCheckBoxes.put(theString, checkBox);
		}
		return newLabel;
	}
	
	/**
	 * Builds the bottom panel which contains the action buttons.
	 */
	private final void buildBottomPanel() {
		final JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.ORANGE);

		myDeleteButton = createButton(bottomPanel, "Delete Residence");
		myChooseButton = createButton(bottomPanel,"Choose Residence");
		myCreateButton = createButton(bottomPanel,"Create Residence");
		
		myContentPanelHolder.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Creates and resizes the button.
	 * @param thePanel the panel the button is added to.
	 * @param theName name of the button.
	 * @return the button.
	 */
	private final JButton createButton(final JPanel thePanel, final String theName) {
		final JButton button = new JButton(theName);
		button.setPreferredSize(new Dimension(200, 50));
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		thePanel.add(button);
		return button;
	}
	
	/**
	 * Updates the residence panel with user residences.
	 * @param theObject the list of residences.
	 */
	private final void updatePanel(Object theObject) {
		ArrayList<String> resInfo = (ArrayList<String>) theObject;
		myCheckBoxes = new HashMap<String, JCheckBox>();
		final ButtonGroup checkBoxGroup = new ButtonGroup();
		for (int i = 0; i < resInfo.size() - 1; i += 3) {
			myContentPanel.add(populateContentPanel(resInfo.get(i), 50, myNameTitle, checkBoxGroup, true, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(resInfo.get(i + 1), 50, myTypeTitle, checkBoxGroup, false, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(resInfo.get(i + 2), 50, myProjectsTitle, checkBoxGroup, false, (i + 1) / 3 + 1));
		}
		myContentPanel.revalidate();
	}
}