import java.awt.Dimension;

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
}
