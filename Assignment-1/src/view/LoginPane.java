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
	 * Serial ID.
	 */
	private static final long serialVersionUID = 7579908892110274745L;

	/**
	 * Starting login pane for singleton use.
	 */
	private static LoginPane myLoginPane = null;
	
	/**
	  * Size of email text field.
	  */
	private static final int TEXT_FIELD_SIZE = 15;

	/**
	 * Button to login.
	 */
 	private final JButton myLoginButton;

    /**
     * Button to create a new user.
     */
 	private final JButton myNewUserButton;

 	/**
 	 * Email field.
 	 */
 	private final JTextField myEmailField;
 
	/**
	 * Constructs the login pane.
	 */
	private LoginPane() {
		myEmailField = new JTextField(TEXT_FIELD_SIZE);
		myLoginButton = new JButton("Login");
		myNewUserButton = new JButton("New User?");
		buildLogin();
	}

    /**
     * @return a singleton instance of the login pane
     */
	public static final LoginPane getInstance() {
		if (myLoginPane == null) {
			myLoginPane = new LoginPane();
		}
		return myLoginPane;
	}

    /**
     * Sets actions for the buttons.
     * @param theAction actions for all the buttons and email field
     */
	public final void setAction(final Action theAction) {
		myLoginButton.addActionListener(theAction);
		myNewUserButton.addActionListener(theAction);
		myEmailField.addActionListener(theAction);
	}

    /**
     * @return text field for the email
     */
	public final String getEmail() {
		return myEmailField.getText();
	}

    /**
     * Builds the login pane.
     */
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
