import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class SetupPane extends AbstractAction {

	/**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = 3908963322824885539L;
	
	/**
	 * Frame to attach option pane to.
	 */
	private final JFrame myFrame;
	
	/**
	 * The setup panel.
	 */
	private final JPanel mySetupPanel;
	
	/**
	 * Constructs the button for the setup pane.
	 * 
	 * @param theFrame	a frame to attach option pane to.
	 */
	public SetupPane(final JFrame theFrame) {
		super("Setup...");
		myFrame = theFrame;
		mySetupPanel = new JPanel();
		mySetupPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		final JLabel nameLabel = new JLabel("Name:", SwingConstants.CENTER);
		final JTextField nameField = new JTextField(20);
		final JLabel emailLabel = new JLabel("Email:", SwingConstants.CENTER);
		final JTextField emailField = new JTextField(20);
		c.gridx = 0;
		c.gridy = 0;
		mySetupPanel.add(nameLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		mySetupPanel.add(nameField, c);
		c.gridx = 0;
		c.gridy = 1;
		mySetupPanel.add(emailLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		mySetupPanel.add(emailField, c);
	}
	
	/**
	 * Action listener for showing the about page.
	 */
	@Override
	public void actionPerformed(ActionEvent theAction) {
		JOptionPane.showMessageDialog(myFrame, mySetupPanel, "Setup", 
                JOptionPane.INFORMATION_MESSAGE);
	}

}