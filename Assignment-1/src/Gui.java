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
	 * 
	 */
	private final JMenuBar myMenu;
	
	/**
	 * 
	 */
	public Gui() {
		setPreferredSize(new Dimension(500, 500));
		myMenu = new JMenuBar();
	}
	
	/**
	 * 
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
	 * 
	 */
	private final void buildFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		final Action aboutAction = new AboutPane();
		final JMenuItem aboutMenu = new JMenuItem(aboutAction);
		//aboutMenu.setMnemonic('A');
		fileMenu.add(aboutMenu);
		
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