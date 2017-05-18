package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Creates an about pane that displays authors.
 * 
 * @author Isaac Seemann
 * @author Donald Muffler
 * @version 20170516
 */
final public class AboutPane extends AbstractAction {

	/**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -3408885330650984421L;
	
	/**
	 * JFrame of the Gui.
	 */
	private final JFrame myFrame;
	
	/**
	 * Constructs the button for the about pane.
	 */
	public AboutPane(final JFrame theFrame) {
		super("About...");
		myFrame = theFrame;
	}
	
	/**
	 * Action listener for showing the about page.
	 */
	@Override
	public final void actionPerformed(ActionEvent theAction) {
		final String authors = "Zira Cook\nGarrett Lahmann\nDonald Muffler\n" + 
				"Yaro Salo\nIsaac Seemann";
		JOptionPane.showMessageDialog(myFrame, authors, "Authors", JOptionPane.INFORMATION_MESSAGE);
	}

}
