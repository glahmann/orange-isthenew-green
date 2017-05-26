package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Back":
				// TODO: back button controller
				break;
			case "Delete":
				// TODO: delete residence controller
				break;
			case "Choose":
				// TODO: choose residence controller
				break;
		}
	}

}
