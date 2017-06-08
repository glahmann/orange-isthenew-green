package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public final class ManageProjectScreen extends JScrollPane implements Observer {
	// TODO: add an updatePanel method and observer which calls updatePanel.

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 4304685901234127360L;
	
	/**
	 * Singleton instance for Manage Residence screen.
	 */
	private static ManageProjectScreen myProjectScreen = null;
	
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
	private JButton myOpenButton;
	
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
	 * Add bill button.
	 */
	private JButton myBillButton;
	
	
	/**
	 * Private constructor to prevent instantiation.
	 */
	private ManageProjectScreen() {
		myContentPanelHolder = new JPanel(new BorderLayout());
		setViewportView(myContentPanelHolder);
		buildTopPanel();
		buildContentPanel();
		buildBottomPanel();
	}
	
	/**
	 * Sets the action for this panel's buttons.
	 * @param theAction the action.
	 */
	public final void setAcion(final Action theAction) {
		myBillButton.addActionListener(theAction);
		myDeleteButton.addActionListener(theAction);
		myOpenButton.addActionListener(theAction);
		myCreateButton.addActionListener(theAction);
		myBackButton.addActionListener(theAction);
	}
	
	/**
	 * Singleton getter for this instance. Creates an instance if one does not exist.
	 * @return Singleton instance for ManageResidenceScreen.
	 */
	public static final ManageProjectScreen getInstance() {
		if (myProjectScreen == null) {
			myProjectScreen = new ManageProjectScreen();
		}
		return myProjectScreen;
	}

	/**
	 * Updates the manage project screen.
	 */
	@Override
	public void update(Observable theObservable, Object theObject) {
		if (theObject instanceof ArrayList) {
			myContentPanelHolder.remove(myContentPanel);
			buildContentPanel();
			updatePanel(theObject);
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
	
	/**
	 * Map that contains the project name and box associated with it.
	 * @return clone of the projects map with JCheckboxes.
	 */
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
		
		myTypeTitle = new JLabel("Item Count");
		myTypeTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringLayout.putConstraint(SpringLayout.NORTH, myTypeTitle, 0, SpringLayout.NORTH, myNameTitle);
		mySpringLayout.putConstraint(SpringLayout.WEST, myTypeTitle, 400, SpringLayout.EAST, myNameTitle);
		myContentPanel.add(myTypeTitle);
		
		myProjectsTitle = new JLabel("Estimated Monthly Savings");
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
	 * @param thePanelHolder the panel where the buttons reside.
	 */
	private final void buildBottomPanel() {
		final JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.ORANGE);

		myDeleteButton = new JButton("Delete Project");
		myOpenButton = new JButton("Open Project");
		myCreateButton = new JButton("Create Project");
		myBillButton = new JButton("Add Energy Bill");
		bottomPanel.add(myBillButton);
		bottomPanel.add(myDeleteButton);
		bottomPanel.add(myOpenButton);
		bottomPanel.add(myCreateButton);
		myContentPanelHolder.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Updates the panel with project information.
	 * @param theObject the list or projects.
	 */
	private final void updatePanel(Object theObject) {
		ArrayList<String> projectInfo = (ArrayList<String>) theObject;
		myCheckBoxes = new HashMap<String, JCheckBox>();
		final ButtonGroup checkBoxGroup = new ButtonGroup();
		for (int i = 0; i < projectInfo.size(); i += 3) {
			myContentPanel.add(populateContentPanel(projectInfo.get(i), 50, myNameTitle, checkBoxGroup, true, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(projectInfo.get(i + 1), 50, myTypeTitle, checkBoxGroup, false, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(projectInfo.get(i + 2), 50, myProjectsTitle, checkBoxGroup, false, (i + 1) / 3 + 1));
		}
		myContentPanel.revalidate();
	}
}