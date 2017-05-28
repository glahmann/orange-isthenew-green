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

import net.miginfocom.swing.MigLayout;

/**
 * Create Project dialogue.
 * 
 * @author Zira Cook
 * @version 20170527
 */
public class CreateProject {
	
	/**
	 * Size for text field.s
	 */
	private static final int TEXT_FIELD_SIZE = 15;

	/**
	 * Constructs create project dialogue.
	 */
	public CreateProject(final Action theAction) { //extending JPanel would probably be better.
		//Setup for new project screen
		final JPanel newProjectPanel = new JPanel(new MigLayout());
		newProjectPanel.add(new JLabel("Project Name: "));

		final JTextField projectNameBox = new JTextField(TEXT_FIELD_SIZE);
		newProjectPanel.add(projectNameBox);
		final JButton enterBillButton = new JButton("Enter an Energy Bill?");
		newProjectPanel.add(enterBillButton, "cell 1 1");

		enterBillButton.setBorderPainted(false);
		enterBillButton.setContentAreaFilled(false);
		enterBillButton.setForeground(Color.BLUE);

		//If user wants to enter an energy bill
		enterBillButton.addActionListener(theAction);

//		JOptionPane.showMessageDialog(null, newProjectPanel);

		final String enteredProjectName = projectNameBox.getText();

		if(enteredProjectName.equals("")) {
		}
	}
	
//	public final String getName() {
//		return myName;
//	}
}