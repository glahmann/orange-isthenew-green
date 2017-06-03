package view;

import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import javax.swing.JPanel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JCheckBox;

/**
 * Singleton for resident management screen.
 * 
 * @author Donald Muffler
 * @version 20170524
 */
public final class ManageResidenceScreen extends JScrollPane implements Observer {
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
	
	private Map<String, JCheckBox> myCheckBoxes;
	
	private JButton myDeleteButton;
	
	private JButton myCreateButton;
	
	private JButton myChooseButton;
	
	private JButton myBackButton;
	
	private JLabel myNameTitle;
	
	private JLabel myTypeTitle;
	
	private JLabel myProjectsTitle;
	
	private JPanel myContentPanel;
	
	private JPanel myContentPanelHolder;
	
	private SpringLayout mySpringPanel;
	
	
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

	@Override
	public void update(Observable theObservable, Object theObject) {
		if (theObject instanceof ArrayList) {
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
	 * Builds the content panel that displays the residence information.
	 */
	private final void buildContentPanel() {
		
		myContentPanel = new JPanel();
		myContentPanel.setBackground(Color.GREEN);
		myContentPanelHolder.add(myContentPanel);
		mySpringPanel = new SpringLayout();
		myContentPanel.setLayout(mySpringPanel);
		
		myNameTitle = new JLabel("Name");
		myNameTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringPanel.putConstraint(SpringLayout.NORTH, myNameTitle, 10, SpringLayout.NORTH, myContentPanel);
		mySpringPanel.putConstraint(SpringLayout.WEST, myNameTitle, 40, SpringLayout.WEST, myContentPanel);
		myContentPanel.add(myNameTitle);
		
		myTypeTitle = new JLabel("Type");
		myTypeTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringPanel.putConstraint(SpringLayout.NORTH, myTypeTitle, 0, SpringLayout.NORTH, myNameTitle);
		mySpringPanel.putConstraint(SpringLayout.WEST, myTypeTitle, 400, SpringLayout.EAST, myNameTitle);
		myContentPanel.add(myTypeTitle);
		
		myProjectsTitle = new JLabel("Projects");
		myProjectsTitle.setFont(new Font("Times New Roman", Font.BOLD, FONT_SIZE));
		mySpringPanel.putConstraint(SpringLayout.NORTH, myProjectsTitle, 0, SpringLayout.NORTH, myNameTitle);
		mySpringPanel.putConstraint(SpringLayout.WEST, myProjectsTitle, 400, SpringLayout.EAST, myTypeTitle);
		myContentPanel.add(myProjectsTitle);
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
	private final void buildBottomPanel() {
		final JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.ORANGE);
		
		myDeleteButton = new JButton("Delete");
		myChooseButton = new JButton("Choose");
		myCreateButton = new JButton("Create");
		bottomPanel.add(myDeleteButton);
		bottomPanel.add(myChooseButton);
		bottomPanel.add(myCreateButton);
		myContentPanelHolder.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	
	private final void updatePanel(Object theObject) {
		ArrayList<String> resInfo = (ArrayList<String>) theObject;
		final ButtonGroup checkBoxGroup = new ButtonGroup();
		for (int i = 0; i < resInfo.size(); i += 3) {
			myContentPanel.add(populateContentPanel(resInfo.get(i), 50, mySpringPanel, myNameTitle, checkBoxGroup, true, myContentPanel, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(resInfo.get(i + 1), 50, mySpringPanel, myTypeTitle, checkBoxGroup, false, myContentPanel, (i + 1) / 3 + 1));
			myContentPanel.add(populateContentPanel(resInfo.get(i + 2), 50, mySpringPanel, myProjectsTitle, checkBoxGroup, false, myContentPanel, (i + 1) / 3 + 1));
		}
		myContentPanel.revalidate();
	}
}