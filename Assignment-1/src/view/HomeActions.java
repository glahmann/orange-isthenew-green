package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Actions for the home page.
 * 
 * @author Donald Muffler
 * @version 20172005
 */
public final class HomeActions extends AbstractAction {

	/**
	 * Serializabe.
	 */
	private static final long serialVersionUID = -255517639779622036L;

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Create Project":
				// TODO: create project controller.
				break;
			case "Open Project":
				// TODO: open project controller
				break;
			case "Manage Projects":
				// TODO: manage projects controller
				break;
			case "Manage Residences":
				// TODO: manage residences controller
				break;
			case "Change Residence":
				// TODO: change residence controller
				break;
			case "Save/Exit":
				// TODO: save/exit controller
				break;
		}
	}

}
