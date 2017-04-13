/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * User Interface for application.
 */
public class Gui extends JFrame {

    /**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -2373129258052117658L;

	/** 
     * ToolKit. 
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** 
     * Dimensions of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	
	/**
	 * Menu bar that contains File.
	 */
	private final JMenuBar myMenu;
	
	/**
	 * Constructor for Gui.
	 */
	public Gui() {
		setPreferredSize(new Dimension(500, 500));
		myMenu = new JMenuBar();
	}
	
	/**
	 * Creates the Gui and its components.
	 */
	public final void start() {
		buildFileMenu();
		
		setJMenuBar(myMenu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setCentered();
		setVisible(true);
	}
	
	/**
	 * Builds the file menu.
	 */
	private final void buildFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		final Action aboutAction = new AboutPane();
		final JMenuItem aboutMenu = new JMenuItem(aboutAction);
		fileMenu.add(aboutMenu);	
		
		// Make setup option
		final Action setupAction = new SetupPane(this);
		final JMenuItem setupMenuItem = new JMenuItem(setupAction);
		setupMenuItem.setMnemonic('s');
		fileMenu.add(setupMenuItem);	
		
		myMenu.add(fileMenu);
	}
	
	/**
	 * Centers the frame on the screen.
	 */
    private void setCentered() {
        
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
        		SCREEN_SIZE.height / 2 - getHeight() / 2);
    }   
}