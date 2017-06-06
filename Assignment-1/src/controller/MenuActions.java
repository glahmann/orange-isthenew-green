/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

import model.User;
import view.AboutPane;
import view.CustomOptionFrame;
import view.Gui;
import view.LoginPane;
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
				CustomOptionFrame.getInstance().displayPanel("Setup");
				break;
			case "OK":
				myUser.setName(SetupPane.getInstance().getNameField().getText());
				myUser.setEmail(SetupPane.getInstance().getEmailField().getText());
				CustomOptionFrame.getInstance().dispose();
				Gui.getInstance().displayPanel("Home");
				break;
			case "Login":
					CustomOptionFrame.getInstance().dispose();
					String fileName = LoginPane.getInstance().getEmailField().getText();
				    final File file = new File(fileName + ".json");
				    if (file.exists()) {
						User user = JSONSupport.readJSON(file);
						Main.start(user);
				    } else {
				    	System.exit(0);
				    }
//					User user = JSONSupport.readJSON(file);
//					Main.start(user);
				Gui.getInstance().displayPanel("Home");
				break;
			case "Home":
				Gui.getInstance().displayPanel("Home");
				break;
			case "Setup...":
				CustomOptionFrame.getInstance().displayPanel("Setup");				
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