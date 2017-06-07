package controller;

import view.BillPane;
import view.CustomOptionFrame;
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
	 * Serializable.
	 */
	private static final long serialVersionUID = -255517639779622036L;

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
//			case "Create Project":
//				CustomOptionFrame.getInstance().displayPanel("Create Project");
//				break;
//			case "Create":
//				Gui.getInstance().displayPanel("Market");
//                CustomOptionFrame.getInstance().dispose();
//				break;
//			case "Enter an Energy Bill?":
//				//final BillPane bill = new BillPane();
//				//JOptionPane.showMessageDialog(Gui.getInstance(), bill);
//				// TODO: Add to user.
//				break;
			case "Statistics":
			    Gui.getInstance().displayPanel("Calculator");
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
