package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Project;
import model.Residence;
import model.User;

/**
 * Actions for the manage residence screen.
 * 
 * @author Donald Muffler
 * @version 20170525
 */
public final class ManageResidenceActions extends AbstractAction{

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -2588766063534303043L;

	/**
	 * User.
	 */
	private final User myUser;
	
	/**
	 * 
	 * @param theAction
	 */
	public ManageResidenceActions(final User theUser) {
		myUser = theUser;
	}
	
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Back":
				break;
			case "Delete":
				// TODO: delete residence controller
				break;
			case "Choose":
				// TODO: choose residence controller
				break;
			case "Create":
				Residence res = new Residence("My Home");
				res.addProject(new Project("test"));
				myUser.addResidence(res);
				break;
		}
	}

}
