package controller;

import net.miginfocom.swing.MigLayout;
import view.BillPane;
import view.CreateProject;
import view.Gui;
import view.ManageResidenceScreen;

import java.awt.*;
import java.awt.event.ActionEvent;

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
	 * Serializabe.
	 */
	private static final long serialVersionUID = -255517639779622036L;

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Create Project":
				final CreateProject project = new CreateProject(this);
				JOptionPane.showMessageDialog(Gui.getInstance(), project);
				break;
			case "Enter an Energy Bill?":
				final BillPane bill = new BillPane();
				JOptionPane.showMessageDialog(Gui.getInstance(), bill);
				// TODO: Add to user.
				break;
			case "Manage Projects":
				// TODO: manage projects controller
				break;
			case "Manage Residences":
				Gui.getInstance().displayPanel("Manage Residences");
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
}
