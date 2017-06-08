package controller;

import java.awt.event.ActionEvent;
import java.io.File;

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
		
		switch(whichButton) {
			case "New User?":
				CustomOptionFrame.getInstance().displayPanel("Setup");
				break;
			case "OK":
				final User newUser = new User(SetupPane.getInstance().getName(), SetupPane.getInstance().getEmail());
				Main.start(newUser);
				CustomOptionFrame.getInstance().dispose();
				Gui.getInstance().displayPanel("Home");
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
				    } else {
                        // If user doesn't exist, an error dialogue will now show, instead of the project just aborting
				    	JOptionPane.showMessageDialog(null, "Error: Email not found");
				    	// Safety feature! :D
						System.exit(0);
				    }
				Gui.getInstance().displayPanel("Home");
				break;
		}
	}
}