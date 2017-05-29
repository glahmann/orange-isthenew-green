package view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

//	/**
//	 * The setup panel.
//	 */
//	private final JPanel mySetupPanel;
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 6841876535294172703L;

	/**
	 * The user name.
	 */
	private String myName;
	
	/**
	 * The text field for user name entry.
	 */
	private JTextField myNameField;
	
	/**
	 * The user email.
	 */
	private String myEmail;
	
	/**
	 * The text field for user email entry.
	 */
	private JTextField myEmailField;
	
	/**
	 * Constructs the button for the setup pane.
	 */
	public SetupPane() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		final JLabel nameLabel = new JLabel("Name:", SwingConstants.CENTER);
		myNameField = new JTextField(20);
		myName = myNameField.getText();
		final JLabel emailLabel = new JLabel("Email:", SwingConstants.CENTER);
		myEmailField = new JTextField(20);
		myEmail = myEmailField.getText();
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
	}
	
	/**
	 * @author Donald Muffler
	 * 
	 * Getter for user name.
	 * @return user name.
	 */
	public final String getName() {
		return myName;
	}
	
	/**
	 * @author Donald Muffler
	 * 
	 * Getter for user email.
	 * @return user email.
	 */
	public final String getEmail() {
		return myEmail;
	}
}