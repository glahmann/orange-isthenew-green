package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * User Interface for application.
 */
public class Gui extends JFrame implements Observer{

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
	 * Main panel. TODO Change.
	 */
	private DisplayPanel myCenterPanel;
	
	/**
	 * Constructor for Gui.
	 */
	public Gui() {
		setPreferredSize(new Dimension(500, 500));
		myCenterPanel = new DisplayPanel(); 	// TODO Maybe not necessary.
		myMenu = new JMenuBar();
	}
	
	/**
	 * Creates the Gui and its components.
	 */
	public final void start() {
		buildFileMenu();
		
		setJMenuBar(myMenu);
		add(myCenterPanel, BorderLayout.CENTER);
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
		
		// Make login option
		final Action loginAction = new LoginPane(this);
		final JMenuItem loginMenuItem = new JMenuItem(loginAction);
		loginMenuItem.setMnemonic('L');
		fileMenu.add(loginMenuItem);
		
		// Make setup option
		final Action setupAction = new SetupPane(this);
		final JMenuItem setupMenuItem = new JMenuItem(setupAction);
		setupMenuItem.setMnemonic('S');
		fileMenu.add(setupMenuItem);
		
		// Make about option
		final Action aboutAction = new AboutPane(this);
		final JMenuItem aboutMenuItem = new JMenuItem(aboutAction);
		aboutMenuItem.setMnemonic('A');
		fileMenu.add(aboutMenuItem);	
		
		myMenu.add(fileMenu);
	}
	
	/**
	 * Centers the frame on the screen.
	 */
    private void setCentered() {
        
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
        		SCREEN_SIZE.height / 2 - getHeight() / 2);
    }

    // TODO fix badbadbadbad coupling
    public void updateDisplay(String theEmail) {
    	myCenterPanel.updatePanel(theEmail);
    }
    
    /**
     * 
     */
	@Override
	public void update(Observable theO, Object theArg) {
		// TODO Auto-generated method stub
		
	}   
}