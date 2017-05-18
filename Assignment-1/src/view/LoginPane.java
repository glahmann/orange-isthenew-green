package view;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;


/**
 * TODO save name and email
 * Creates a setup pane that asks for name and email.
 * 
 * @author Garrett Lahmann
 * @version 15 May 2017
 */
final public class LoginPane extends AbstractAction {

	/**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -3408885330650984421L;
	
	/**
	 * JFrame of the Gui.
	 */
	private final Gui myFrame;
	
	/**
	 * The user email.
	 */
	private String myEmail; // TODO Make local?
	
	/**
	 * Constructs the button for the about pane.
	 */
	public LoginPane(final Gui theFrame) {
		super("Login...");
		myFrame = theFrame;
	}
	
	/**
	 * Action listener for showing the about page.
	 */
	@Override
	public void actionPerformed(ActionEvent theAction) {
	     myEmail = JOptionPane.showInputDialog("Enter your email: "); 
	     // TODO Error checking
	     
	     myFrame.updateDisplay(myEmail);
	}

}

