package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Residence;
import model.User;
import view.CustomOptionFrame;
import view.Gui;
import view.LoginPane;
import view.ManageProjectScreen;
import view.SetupPane;

/**
 * Login and setup actions.
 * 
 * @author Donald Muffler
 * @version 20170608
 */
public class LoginActions extends AbstractAction {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -5355251163493324434L;

	/**
	 * Performs an action based on which button was pressed.
	 * 
	 * @author Donald Muffler
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		final ArrayList<String> emailSuffixes = new ArrayList<String>();
		emailSuffixes.add(".com");
		emailSuffixes.add(".edu");
		emailSuffixes.add(".gov");
		emailSuffixes.add(".org");
		
		switch(whichButton) {
			case "New User?":
				CustomOptionFrame.getInstance().displayPanel("Setup");
				break;
			case "OK":
				String email = SetupPane.getInstance().getEmail();
				
				boolean goodSuffix = false;
				// checks to see if a good suffix was used for email.
				for (int i = 0; i < emailSuffixes.size(); i++) {
					if (email.length() > 5 && email.substring(email.length() - 4).equals(emailSuffixes.get(i))) {
						goodSuffix = true;
					}
				}
				// checks to see if the email is in correct format (correct suffix, contains @, and a character before @).
				if (!email.contains("@") || !goodSuffix) { // email is incorrect format.
			    	JOptionPane.showMessageDialog(null, "Enter a correct email.", "Incorrect Email Format!", JOptionPane.ERROR_MESSAGE);
					CustomOptionFrame.getInstance().displayPanel("Setup Pane");
				} else { // email is in correct format.
					final User newUser = new User(SetupPane.getInstance().getName(), SetupPane.getInstance().getEmail());
					CustomOptionFrame.getInstance().dispose();
					Main.start(newUser);
				}
				break;
			case "Login":
					CustomOptionFrame.getInstance().dispose();
					String fileName = LoginPane.getInstance().getEmail();
					
				    final File file = new File(fileName + ".json");
				    if (file.exists()) {
						final User existingUser = JSONSupport.readJSON(file);
						for(Residence residence : existingUser.getResidences()) {
							residence.addObserver(ManageProjectScreen.getInstance());
						}
						Main.start(existingUser);
				    } else if (fileName.length() == 0) { // user enters in blank email.
						fileName = "Guest";
				    	final User guestUser = new User(fileName, fileName);
				    	Main.start(guestUser);
				    } else { // login does not exist. call setup pane and pre-populate email field.
				    	JOptionPane.showMessageDialog(null, "Error: Email not found", "Email Does Not Exist!", JOptionPane.ERROR_MESSAGE);
				    	SetupPane.getInstance().populateEmailField(LoginPane.getInstance().getEmail());
				    	CustomOptionFrame.getInstance().displayPanel("Setup");
				    }
				break;
		}
	}
}