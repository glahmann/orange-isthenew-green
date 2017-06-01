package view;


import java.awt.CardLayout;
import javax.swing.*;

/**
 * User Interface for application.
 * 
 * @author Donald Muffler
 * @author Zira Cook
 * @version 20170516
 */
final public class Gui extends JFrame {

    /**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -2373129258052117658L;
	
	/**
	 * Singleton Gui.
	 */
	private static Gui myGui = null;

	/**
	 * Holds the panels for this gui frame.
	 */
	private static JPanel myPanelHolder;
	
	/**
	 * Constructor for Gui.
	 */
	private Gui() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		myPanelHolder = new JPanel(new CardLayout());
		add(myPanelHolder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	/**
	 * Getter for the gui.
	 * @return the gui.
	 */
	public final static Gui getInstance() {
		if (myGui == null) {
			myGui = new Gui();
		}
		return myGui;
	}
	
	/**
	 * Displays the sleceted panel in the panel holder.
	 * @param thePanelTag the panel tag.
	 */
	public final void displayPanel(final String thePanelTag) {
		CardLayout layout = (CardLayout) myPanelHolder.getLayout();
		layout.show(myPanelHolder, thePanelTag);
		setVisible(true);
	}
	
	/**
	 * Adds a panel to the holder with a tag as a reference.
	 * @param theComponent the panel.
	 * @param thePanelTag the reference.
	 */
	public final void addPanel(final JComponent theComponent, final String thePanelTag) {
		myPanelHolder.add(theComponent, thePanelTag);
	}
	
	/**
	 * Sets the frame's menu bar.
	 * @param theMenuBar the menu bar.
	 */
	public final void setMenu(final JMenuBar theMenuBar) {
		setJMenuBar(theMenuBar);
	}
}