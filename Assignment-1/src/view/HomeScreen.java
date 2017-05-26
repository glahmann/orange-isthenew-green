package view;import javax.swing.JPanel;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import controller.HomeActions;

import javax.swing.UIManager;

/**
 * Singleton that represents the home screen.
 * 
 * @author Donald Muffler
 * @version 20172505
 */
public class HomeScreen extends JPanel {
	
	/**
	 * Instance of this class.
	 */
	private static HomeScreen myScreen = null;
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -3497623772546977289L;

	/**
	 * Button size.
	 */
	private final static Dimension BUTTON_SIZE = new Dimension(500, 250);
	
	/**
	 * Button text size.
	 */
	private final static int TEXT_SIZE = 20;

	/**
	 * Builds the home screen.
	 */
	private HomeScreen() {
		setBackground(Color.GREEN);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(new MigLayout(new LC().align("center", "center")));
		buildPanel();
	}
	
	/**
	 * Getter for the home screen.
	 * @return the homescreen.
	 */
	public static final HomeScreen getInstance() {
		
		if (myScreen == null) {
			myScreen = new HomeScreen();
		}
		return myScreen;
	}
	
	/**
	 * Builds the home panel.
	 */
	private final void buildPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Home", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][][]", "[][][][][][][][][]"));

		final Action homeAction = new HomeActions();
		panel.add(buildButton("Create Project", homeAction), "cell 1 2,growx");
		panel.add(buildButton("Manage Projects", homeAction), "cell 5 2,growx");
		panel.add(buildButton("Manage Residences", homeAction), "cell 1 6");
		panel.add(buildButton("Save/Exit", homeAction), "cell 5 6,growx");

	}
	
	/**
	 * Creates a button to add to the panel.
	 * @param theButtonName the name of the button.
	 * @param theAction the action tied to the button.
	 * @return the button.
	 */
	private final JButton buildButton(final String theButtonName, final Action theAction) {
		final JButton button = new JButton(theButtonName);
		button.setMinimumSize(BUTTON_SIZE);
		button.setPreferredSize(BUTTON_SIZE);
		button.setFont(new Font("Times New Roman", Font.BOLD, TEXT_SIZE));
		button.addActionListener(theAction);
		return button;
	}
}