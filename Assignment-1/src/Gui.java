import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * 
 */

/**
 *
 */
public class Gui extends JFrame {

    /** ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** Dimensions of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width;
    
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;
	
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
		
		myMenu.add(fileMenu);
	}
	
	/**
	 * Centers the frame on the screen.
	 */
    private void setCentered() {
        
        setLocation(SCREEN_WIDTH / 2 - getWidth() / 2, 
                            SCREEN_HEIGHT / 2 - getHeight() / 2);
    }
    
}
