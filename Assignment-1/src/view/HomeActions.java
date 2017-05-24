package view;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Actions for the home page.
 * 
 * @author Donald Muffler
 * @author Zira Cook
 * @version 20172005
 */
public final class HomeActions extends AbstractAction {

	/**
	 * Serializabe.
	 */
	private static final long serialVersionUID = -255517639779622036L;

	/**
	 * Size for text field.s
	 */
	private static final int TEXT_FIELD_SIZE = 15;

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Create Project":
				createProject();
				break;
			case "Manage Projects":
				// TODO: manage projects controller
				break;
			case "Manage Residences":
				// TODO: manage residences controller
				break;
			case "Save/Exit":
				int exit = JOptionPane.showConfirmDialog(null, "Would you like to exit?", "Leaving so soon?",
						JOptionPane.YES_NO_OPTION);

				//Close the program if "yes" option is picked
				if (exit == 0) {
					System.exit(0);
				}
				break;
		}
	}

	/**
	 * Creates a new project.
	 * @return 0 for a successful creation, 1 if there was a user error.
	 */
	private int createProject() {
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
		final Action newUserAction = new BillPane(null);
		enterBillButton.addActionListener(newUserAction);

		JOptionPane.showMessageDialog(null, newProjectPanel);

		final String enteredProjectName = projectNameBox.getText();

		if(enteredProjectName.equals("")) {
			return 1;
		}

		return 0;
	}

}
