package controller;

import view.Gui;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import model.User;

/**
 * Actions for the home page.
 * 
 * @author Donald Muffler
 * @author Zira Cook
 * @version 20172005
 */
public final class HomeActions extends AbstractAction {

	/**
	 * User data.
	 */
	private final User myUser;
	
	/**
	 * Constructor for HomeActions gets User data.
	 * @param theUser the user data to be changed.
	 */
	public HomeActions(final User theUser) {
		myUser = theUser;
	}
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -255517639779622036L;

	/**
	 * Performs an action based on which button was pressed.
	 * 
	 * @author Donald Muffler
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Statistics":
			    myUser.updateInfo();
				Gui.getInstance().displayPanel("Statistics");
				break;
			case "Manage Residences":
				myUser.updateInfo();
				Gui.getInstance().displayPanel("Manage Residences");
				break;
			case "Save/Exit":
				int exit = JOptionPane.showConfirmDialog(null, "Would you like to exit?", "Leaving so soon?",
						JOptionPane.YES_NO_OPTION);
				File theFile = new File(myUser.getEmail() + ".json");
				JSONSupport.writeJSON(myUser, theFile);
				//Close the program if "yes" option is picked
				if (exit == 0) {
					System.exit(0);
				}
				break;
		}
	}
}