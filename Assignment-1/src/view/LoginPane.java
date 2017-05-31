package view;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * Login screen that takes an email.
 * 
 * @author Donald Muffler
 * @version 20170528
 */
public class LoginPane extends JPanel {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 7441787967042276275L;

	/**
	  * Size of email text field.
	  */
	 private static final int TEXT_FIELD_SIZE = 15;

 	/**
 	 * Action to login or setup a new account.
 	 */
 	private final Action myAction;
 
	/**
	 * Constructs the login pane.
	 * @param theAction the action that deals with logging in or setting up an account.
	 */
	public LoginPane(final Action theAction) {
		myAction = theAction;
		buildLogin();
	}

	private final void buildLogin() {
		
		setLayout(new MigLayout());
		add(new JLabel("Email"));
		final JTextField emailText = new JTextField(TEXT_FIELD_SIZE);
		add(emailText);
		final JButton newUserButton = new JButton("New User?");
		add(newUserButton, "cell 1 1");
		
		newUserButton.setBorderPainted(false);
		newUserButton.setContentAreaFilled(false);
		newUserButton.setForeground(Color.BLUE);
		
		newUserButton.addActionListener(myAction);
		
		JOptionPane.showMessageDialog(Gui.getInstance(), this);

		final String enteredEmail = emailText.getText();
//
//		if(!enteredEmail.equals("")) {
//			myUserMenuItem.setText(enteredEmail);
//		}
	}
}
