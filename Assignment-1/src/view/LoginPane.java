package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	private static LoginPane myLoginPane = null;
	
	/**
	  * Size of email text field.
	  */
	 private static final int TEXT_FIELD_SIZE = 15;

 	/**
 	 * Action to login or setup a new account.
 	 */
 	private Action myAction;

 	/**
 	 * Email field.
 	 */
 	private final JTextField myEmailField;
 
	/**
	 * Constructs the login pane.
	 * @param theAction the action that deals with logging in or setting up an account.
	 */
	public LoginPane() {
		myEmailField = new JTextField(TEXT_FIELD_SIZE);
		//myAction = theAction;
//		buildLogin();
	}
	
	public static final LoginPane getInstance() {
		if (myLoginPane == null) {
			myLoginPane = new LoginPane();
		}
		return myLoginPane;
	}
	
	public final void setAction(final Action theAction) {
		myAction = theAction;
		buildLogin();
	}
	
	public final JTextField getEmailField() {
		return myEmailField;
	}

	private final void buildLogin() {
		setLayout(new MigLayout(new LC().align("center", "center")));
		final JPanel topPanel = new JPanel(new MigLayout());
		topPanel.add(new JLabel("Email"));
		myEmailField.addActionListener(myAction);
		topPanel.add(myEmailField);
		add(topPanel, "wrap");
		
		final JPanel bottomPanel = new JPanel(new MigLayout());
		final JButton newUserButton = new JButton("New User?");
		bottomPanel.add(newUserButton);
		
		newUserButton.setBorderPainted(false);
		newUserButton.setContentAreaFilled(false);
		newUserButton.setForeground(Color.BLUE);
		
		newUserButton.addActionListener(myAction);
		
		final JButton loginButton = new JButton("Login");
		loginButton.addActionListener(myAction);
		bottomPanel.add(loginButton);
		add(bottomPanel);
	}
}