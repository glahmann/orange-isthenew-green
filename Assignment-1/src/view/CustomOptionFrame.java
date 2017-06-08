package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Donald Muffler
 * @version 20170531
 */
public final class CustomOptionFrame extends JFrame {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1741636894831569745L;

	/**
	 * Singleton for the custom option frame.
	 */
	private static CustomOptionFrame myCustomFrame = null;
	
	/**
	 * Holds the panels for this gui frame.
	 */
	private static JPanel myPanelHolder;
	
	/** 
	 * ToolKit. 
	 */
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	 
	/** 
	 * Dimensions of the screen.
	 */
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	
	/**
	 * Constructs a custom frame.
	 */
	private CustomOptionFrame() {
		myPanelHolder = new JPanel(new CardLayout());
		add(myPanelHolder);
	}
	
	/**
	 * Getter for the custom option frame singleton.
	 * @return custom option frame singleton.
	 */
	public static final CustomOptionFrame getInstance() {
		if (myCustomFrame == null) {
			myCustomFrame = new CustomOptionFrame();
		}
		return myCustomFrame;
	}
	
	/**
	 * Displays the sleceted panel in the panel holder.
	 * @param theString the panel tag.
	 */
	public final void displayPanel(final String thePanelTag) {
		CardLayout layout = (CardLayout) myPanelHolder.getLayout();
		layout.show(myPanelHolder, thePanelTag);
		pack();
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
        		SCREEN_SIZE.height / 2 - getHeight() / 2);
        setTitle(thePanelTag);
		setVisible(true);
	}
	
	/**
	 * Adds a panel to the holder with a tag as a reference.
	 * @param theComponent the panel.
	 * @param theString the reference.
	 */
	public final void addPanel(final JComponent theComponent, final String thePanelTag) {
		myPanelHolder.add(theComponent, thePanelTag);
	}
}