/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Residence;
import model.User;
import view.AboutPane;
import view.CustomOptionFrame;
import view.Gui;
import view.LoginPane;
import view.ManageProjectScreen;
import view.SetupPane;

/**
 * Menu item actions.
 * 
 * @author Garrett Lahmann
 * @author Isaac Seemann
 * @author Donald Muffler
 * @author Zira Cook
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
	User myUser;
	
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
     * @author Zira Cook
	 */
	@Override
	public final void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "New User?":
				CustomOptionFrame.getInstance().displayPanel("Setup");
				break;
			case "OK":
				myUser = new User(SetupPane.getInstance().getNameField().getText(), SetupPane.getInstance().getEmailField().getText());
				Main.start(myUser);
				CustomOptionFrame.getInstance().dispose();
				Gui.getInstance().displayPanel("Home");
				break;
			case "Login":
					CustomOptionFrame.getInstance().dispose();
					String fileName = LoginPane.getInstance().getEmailField().getText();
				    final File file = new File(fileName + ".json");
				    if (file.exists()) {
						myUser = JSONSupport.readJSON(file);
						for(Residence residence : myUser.getResidences()) {
							residence.addObserver(ManageProjectScreen.getInstance());
						}
						Main.start(myUser);
				    } else {
                        //If user doesn't exist, an error dialogue will now show, instead of the project just aborting
				    	JOptionPane.showMessageDialog(null, "Error: Email not found");
						System.exit(0);
				    }
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