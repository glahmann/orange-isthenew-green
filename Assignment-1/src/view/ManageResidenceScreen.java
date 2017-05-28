package view;

import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controller.ManageResidenceActions;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JCheckBox;

/**
 * Singleton for project Management screen.
 * 
 * @author Donald Muffler
 * @version 20170524
 */
public final class ManageResidenceScreen extends JScrollPane {
	// TODO: add an updatePanel method and observer which calls updatePanel.

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
	 * Private constructor to prevent instantiation.
	 */
	private ManageResidenceScreen() {
		buildTopPanel();
		buildContentPanel();
	}
	
	/**
	 * Builds the top panel with the back button.
	 */
	private final void buildTopPanel() {
		final JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		setColumnHeaderView(topPanel);
		topPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		final JButton back = new JButton("Back");
		topPanel.add(back, "cell 0 0");
	}
	
	/**
	 * Builds the content panel that displays the residence information.
	 */
	private final void buildContentPanel() {
		final JPanel contentPanelHolder = new JPanel(new BorderLayout());
		setViewportView(contentPanelHolder);
		
		final JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.GREEN);
		contentPanelHolder.add(contentPanel);
		final SpringLayout springPanel = new SpringLayout();
		contentPanel.setLayout(springPanel);
		
		final JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		springPanel.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, contentPanel);
		springPanel.putConstraint(SpringLayout.WEST, nameLabel, 40, SpringLayout.WEST, contentPanel);
		contentPanel.add(nameLabel);
		
		final JLabel typeLabel = new JLabel("Type");
		typeLabel.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		springPanel.putConstraint(SpringLayout.NORTH, typeLabel, 0, SpringLayout.NORTH, nameLabel);
		springPanel.putConstraint(SpringLayout.WEST, typeLabel, 400, SpringLayout.EAST, nameLabel);
		contentPanel.add(typeLabel);
		
		final JLabel projectsLabel = new JLabel("Projects");
		projectsLabel.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		springPanel.putConstraint(SpringLayout.NORTH, projectsLabel, 0, SpringLayout.NORTH, nameLabel);
		springPanel.putConstraint(SpringLayout.WEST, projectsLabel, 400, SpringLayout.EAST, typeLabel);
		contentPanel.add(projectsLabel);
		
		final ButtonGroup buttonGroup = new ButtonGroup();
		// will change to a for loop implementation to read in data after it is parsed.
		contentPanel.add(populateContentPanel("Test Name", 50, springPanel, nameLabel, buttonGroup, true, contentPanel, 1));
		contentPanel.add(populateContentPanel("Test Type", 50, springPanel, typeLabel, buttonGroup, false, contentPanel, 1));
		contentPanel.add(populateContentPanel("Test Amount", 50, springPanel, projectsLabel, buttonGroup, false, contentPanel, 1));
		
		buildBottomPanel(contentPanelHolder);
	}
	
	/**
	 * Populates the content panel with residence information. 
	 * @param theString the information.
	 * @param theRelativeYPosition relative position to the title tag.
	 * @param theSpringLayout the layout manager.
	 * @param theRelativeLabel the relative label used for new label positioning.
	 * @param theButtonGroup the button group for the checkboxes.
	 * @param theBoolean denotes the creation of a check box.
	 * @param theContentPanel panel that holds the content.
	 * @param theMultiplier multiplier used for information placement.
	 * @return the residence information which includes placement.
	 */
	private final JLabel populateContentPanel(final String theString, final int theRelativeYPosition,
									   final SpringLayout theSpringLayout, final JLabel theRelativeLabel,
									   ButtonGroup theButtonGroup, final boolean theBoolean,
									   final JPanel theContentPanel, final int theMultiplier) {
		final JLabel newLabel = new JLabel(theString);
		newLabel.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));
		theSpringLayout.putConstraint(SpringLayout.NORTH, newLabel, theRelativeYPosition * theMultiplier, SpringLayout.NORTH, theRelativeLabel);
		theSpringLayout.putConstraint(SpringLayout.WEST, newLabel, 0, SpringLayout.WEST, theRelativeLabel);
		
		if (theBoolean) {
			final JCheckBox checkBox = new JCheckBox();
			theSpringLayout.putConstraint(SpringLayout.EAST, checkBox, -10, SpringLayout.WEST, newLabel);
			theSpringLayout.putConstraint(SpringLayout.NORTH, checkBox, 0, SpringLayout.NORTH, newLabel);
			theButtonGroup.add(checkBox);
			theContentPanel.add(checkBox);
		}
		return newLabel;
	}
	
	/**
	 * Builds the bottom panel which contains the action buttons.
	 * @param thePanelHolder the panel where the buttons reside.
	 */
	private final void buildBottomPanel(final JPanel thePanelHolder) {
		final JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.ORANGE);
		final Action residenceAction = new ManageResidenceActions(null); // TODO: change to connectActionToPanel method or find a better method.
		bottomPanel.add(populateBottomPanel("Delete", residenceAction));
		bottomPanel.add(populateBottomPanel("Choose", residenceAction));
		bottomPanel.add(populateBottomPanel("Create", residenceAction));
		thePanelHolder.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Builds the button for the bottom panel.
	 * @param theString the button name.
	 * @param theAction action for the button.
	 * @return the button.
	 */
	private final JButton populateBottomPanel(final String theString, final Action theAction) {
		final JButton button = new JButton(theString);
		button.addActionListener(theAction);
		return button;
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
}