package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 * The home page.
 * 
 * @author Donald Muffler
 * @version 20170519
 */
public final class HomePage extends JPanel {
	
    /**
	 * Serializable.
	 */
	private static final long serialVersionUID = -9181129119705300345L;

	/**
     * Size of the home page buttons.
     */
    private static final Dimension HOME_PAGE_BUTTON_DIMENSION = new Dimension(200, 200);
    
    /**
     * Amount of buttons per row.
     */
    private static final int BUTTONS_PER_ROW = 3;
	
	/**
	 * The button panel.
	 */
	private final JPanel myButtonPanel;
	
	/**
	 * Constructs a home page.
	 */
	public HomePage() {
		this.setLayout(new MigLayout(new LC().align("c", "c")));
		myButtonPanel = new JPanel(new MigLayout(new LC().wrapAfter(BUTTONS_PER_ROW)));
		buildButtonPanel();
	}
	
	/**
	 * Builds the button panel.
	 * @return the button panel.
	 */
	public final void buildButtonPanel() {
		// TODO will change, since this is crap.
		JButton createProjectButton = new JButton("Create Project");
		JButton openProjectButton = new JButton("Open Project");
		JButton manageProjectsButton = new JButton("Manage Project");
		JButton manageResidencesButton = new JButton("Manage Residences");
		JButton changeResidenceButton = new JButton("Change Residence");
		JButton saveAndExitButton = new JButton("Save and Exit");
		
		createProjectButton = setButtonSize(createProjectButton);
		openProjectButton = setButtonSize(openProjectButton);
		manageProjectsButton = setButtonSize(manageProjectsButton);
		manageResidencesButton = setButtonSize(manageResidencesButton);
		changeResidenceButton = setButtonSize(changeResidenceButton);
		saveAndExitButton = setButtonSize(saveAndExitButton);
		
		myButtonPanel.add(createProjectButton);
		myButtonPanel.add(openProjectButton);
		myButtonPanel.add(manageProjectsButton);
		myButtonPanel.add(manageResidencesButton);
		myButtonPanel.add(changeResidenceButton);
		myButtonPanel.add(saveAndExitButton);
		
		add(myButtonPanel);
	}
	
	private final JButton setButtonSize(final JButton theButton) {
		theButton.setPreferredSize(HOME_PAGE_BUTTON_DIMENSION);
		return theButton;
	}
}