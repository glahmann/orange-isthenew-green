/**
 * 
 */
package view;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class CreateProject extends JPanel{
	
	/**
	 * Size for text field.s
	 */
	private static final int TEXT_FIELD_SIZE = 15;
	
	private static CreateProject myProject = null;
	
	private final JTextField myProjectNameBox;
	
	private final JButton myEnterBillButton;
	
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
	
	public static final CreateProject getInstance() {
		if (myProject == null) {
			myProject = new CreateProject();
		}
		return myProject;
	}
	
	public final void setAction(final Action theAction) {
		myProjectNameBox.addActionListener(theAction);
		myEnterBillButton.addActionListener(theAction);
		myCreateButton.addActionListener(theAction);
	}
}