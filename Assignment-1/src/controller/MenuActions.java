package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import model.User;
import view.AboutPane;
import view.Gui;

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
	 * Performs an action based on which button was pressed.
	 * 
	 * @author Garrett Lahmann
	 * @author Donald Muffler
     * @author Zira Cook
	 */
	@Override
	public final void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Home":
				Gui.getInstance().displayPanel("Home");
				break;
			case "About...":
				new AboutPane();
				break;
			case "Default":
				break;
		}
	}
}