package view;

import javax.swing.JOptionPane;

/**
 * Creates an about pane that displays authors.
 * 
 * @author Isaac Seemann
 * @author Donald Muffler
 * @version 20170516
 */
final public class AboutPane {

	/**
	 * Constructs the button for the about pane.
	 */
	public AboutPane() {
		final String authors = "Zira Cook\nGarrett Lahmann\nDonald Muffler\n" + 
				"Yaro Salo\nIsaac Seemann";
		JOptionPane.showMessageDialog(Gui.getInstance(), authors, "Authors", JOptionPane.INFORMATION_MESSAGE);
	}
}