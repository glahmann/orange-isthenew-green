package view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * TODO save name and email
 * Creates a setup pane that asks for name and email.
 * 
 * @author Garrett Lahmann
 * @version 13 April 2017
 */
final public class SetupPane extends JPanel {

	/**
	 * The setup panel.
	 */
	private static SetupPane mySetupPane = null;
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 6841876535294172703L;
	
	/**
	 * The text field for user name entry.
	 */
	private final JTextField myNameField;
	
	/**
	 * The text field for user email entry.
	 */
	private final JTextField myEmailField;
	
	/**
	 * Ok button.
	 */
	private final JButton myOKButton;
	
	/**
	 * Constructs the button for the setup pane.
	 */
	private SetupPane() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		final JLabel nameLabel = new JLabel("Name:", SwingConstants.CENTER);
		myNameField = new JTextField(20);
		final JLabel emailLabel = new JLabel("Email:", SwingConstants.CENTER);
		myEmailField = new JTextField(20);
		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		add(myNameField, c);
		c.gridx = 0;
		c.gridy = 1;
		add(emailLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		add(myEmailField, c);
		c.gridx = 1;
		c.gridy = 2;
		myOKButton = new JButton("OK");
		add(myOKButton, c);
	}
	
	public static final SetupPane getInstance() {
		if (mySetupPane == null) {
			mySetupPane = new SetupPane();
		}
		return mySetupPane;
	}
	
	/**
	 * @author Donald Muffler
	 * 
	 * Sets the action for this panel's buttons.
	 * @param theAction the action to be set.
	 */
	public final void setAction(final Action theAction) {
		myNameField.addActionListener(theAction);
		myEmailField.addActionListener(theAction);
		myOKButton.addActionListener(theAction);
	}
	
	/**
	 * @author Donald Muffler
	 * 
	 * Getter for user name.
	 * @return user name.
	 */
	public final JTextField getNameField() {
		return myNameField;
	}
	
	/**
	 * @author Donald Muffler
	 * 
	 * Getter for user email.
	 * @return user email.
	 */
	public final JTextField getEmailField() {
		return myEmailField;
	}
}