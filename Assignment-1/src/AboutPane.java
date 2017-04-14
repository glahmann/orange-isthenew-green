/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Creates an about pane that displays authors.
 */
public class AboutPane extends AbstractAction {

	/**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -3408885330650984421L;
	
	/**
	 * Constructs the button for the about pane.
	 */
	public AboutPane() {
		super("About...");
		// add mnemonic
	}
	
	/**
	 * Action listener for showing the about page.
	 */
	@Override
	public void actionPerformed(ActionEvent theAction) {
		
	}

}
