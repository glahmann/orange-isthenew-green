/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.User;
import view.AboutPane;
import view.Gui;
import view.SetupPane;

/**
 * Menu item actions.
 * 
 * @author Garrett Lahmann
 * @author Isaac Seemann
 * @author Donald Muffler
 * @version 15 May 2017
 */
public final class MenuActions extends AbstractAction {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -4587489463192053499L;
	
	/**
	 * The User.
	 */
	final User myUser;
	
	/**
	 * Constructor for menu actions.
	 * @param theUser
	 */
	public MenuActions(final User theUser) {
		myUser = theUser;
	}
	
	/**
	 * @author Garrett Lahmann
	 * @author Donald Muffler
	 */
	@Override
	public final void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "New User?":
				final SetupPane setupFromUser = new SetupPane();
				JOptionPane.showMessageDialog(Gui.getInstance(), setupFromUser, "Setup", 
		                JOptionPane.INFORMATION_MESSAGE);
				myUser.setName(setupFromUser.getName());
				myUser.setEmail(setupFromUser.getEmail());
				break;
			case "Login...":
				String email = JOptionPane.showInputDialog("Enter your email: ");

				//If an email was entered update the user display
				if (email != null) {
					myUser.setEmail(email);
				}
				break;
			case "Setup...":
				final SetupPane setupFromMenu = new SetupPane();
				JOptionPane.showMessageDialog(Gui.getInstance(), setupFromMenu, "Setup", 
		                JOptionPane.INFORMATION_MESSAGE);
				myUser.setName(setupFromMenu.getName());
				myUser.setEmail(setupFromMenu.getEmail());				
				File userFile = new File(myUser.getEmail() + ".json");
				JSONSupport.writeJSON(myUser, userFile);
				break;
			case "About...":
				new AboutPane();
				break;
			case "Default":
				break;
		}
	}
}