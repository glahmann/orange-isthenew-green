package view;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 * Create Project dialogue.
 * 
 * @author Zira Cook
 * @version 20170527
 */
public class CreateProject extends JPanel {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 5501475586821287960L;

	/**
	 * Size for text fields.
	 */
	private static final int TEXT_FIELD_SIZE = 15;

    /**
     * Project created in the pane.
     */
	private static CreateProject myProject = null;

    /**
     * New project's name text field.
     */
	private final JTextField myProjectNameBox;

    /**
     * Button for entering a bill.
     */
	private final JButton myEnterBillButton;

    /**
     * Button for creating the project.
     */
	private final JButton myCreateButton;

	/**
	 * Constructs create project dialogue.
	 */
	private CreateProject() {
		//Setup for new project screen
		setLayout(new MigLayout(new LC().align("center", "center")));
		final JPanel topPanel = new JPanel(new MigLayout());
		topPanel.add(new JLabel("Project Name: "));

		myProjectNameBox = new JTextField(TEXT_FIELD_SIZE);
		topPanel.add(myProjectNameBox);
		
		final JPanel bottomPanel = new JPanel(new MigLayout());
		myEnterBillButton = new JButton("Enter an Energy Bill?");
		bottomPanel.add(myEnterBillButton);

		myEnterBillButton.setBorderPainted(false);
		myEnterBillButton.setContentAreaFilled(false);
		myEnterBillButton.setForeground(Color.BLUE);
		
		myCreateButton = new JButton("Create");
		bottomPanel.add(myCreateButton);
		
		add(topPanel, "wrap");
		add(bottomPanel);
	}

	/**
	 * Gets an instance of the create project screen.
	 * @return a singleton of the pane
     */
	public static final CreateProject getInstance() {
		if (myProject == null) {
			myProject = new CreateProject();
		}
		return myProject;
	}

	/**
	 * Sets actions for each text box.
	 * @param theAction text box actions
     */
	public final void setAction(final Action theAction) {
		myProjectNameBox.addActionListener(theAction);
		myEnterBillButton.addActionListener(theAction);
		myCreateButton.addActionListener(theAction);
	}

    /**
     * Getter for project name field.
     * @return the text field of the entered project name
     */
	public final String getProjectName() {
		return myProjectNameBox.getText();
	}
}