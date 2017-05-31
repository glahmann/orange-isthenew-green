package view;

import java.awt.Color;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 * Login screen that takes an email.
 * 
 * @author Donald Muffler
 * @version 20170528
 */
public class LoginPane extends JPanel{
	
	/**
	 * 
	 */
	private static LoginPane myLoginPane = null;
	
	/**
	  * Size of email text field.
	  */
	private static final int TEXT_FIELD_SIZE = 15;
 	
	
 	private final JButton myLoginButton;
 	
 	
 	private final JButton myNewUserButton;

 	/**
 	 * Email field.
 	 */
 	private final JTextField myEmailField;
 
	/**
	 * Constructs the login pane.
	 * @param theAction the action that deals with logging in or setting up an account.
	 */	private LoginPane() {
		myEmailField = new JTextField(TEXT_FIELD_SIZE);
		myLoginButton = new JButton("Login");
		myNewUserButton = new JButton("New User?");
		buildLogin();
	}
	
	public static final LoginPane getInstance() {
		if (myLoginPane == null) {
			myLoginPane = new LoginPane();
		}
		return myLoginPane;
	}
	
	public final void setAction(final Action theAction) {
		myLoginButton.addActionListener(theAction);
		myNewUserButton.addActionListener(theAction);
		myEmailField.addActionListener(theAction);
	}
	
	
	public final JTextField getEmailField() {
		return myEmailField;
	}

	
	private final void buildLogin() {
		setLayout(new MigLayout(new LC().align("center", "center")));
		final JPanel topPanel = new JPanel(new MigLayout());
		topPanel.add(new JLabel("Email"));

		topPanel.add(myEmailField);
		add(topPanel, "wrap");
		
		final JPanel bottomPanel = new JPanel(new MigLayout());
		bottomPanel.add(myNewUserButton);
		
		myNewUserButton.setBorderPainted(false);
		myNewUserButton.setContentAreaFilled(false);
		myNewUserButton.setForeground(Color.BLUE);

		bottomPanel.add(myLoginButton);
		add(bottomPanel);
	}
}
