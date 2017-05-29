package view;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The menu bar for the gui.
 * 
 * @author Donald Muffler
 * @version 20170527
 */
public final class ThisMenuBar extends JMenuBar {
	
	/**
	 * Action set for the menu items.
	 */
	private final Action myMenuAction;

	/**
	 * Constructs the menu.
	 * @param theAction action associated to the menu.
	 */
	public ThisMenuBar(final Action theAction) {
		myMenuAction = theAction;
		buildMenu();
	}

	/**
	 * Builds the menu.
	 */
	private final void buildMenu() {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		fileMenu.add(populateMenu("Login..."));
		fileMenu.add(populateMenu("Setup..."));
		fileMenu.add(populateMenu("About..."));

		final JMenu userMenu = new JMenu("User");
		userMenu.setMnemonic('U');
		
		userMenu.add(populateMenu("Default"));

		add(fileMenu);
		add(userMenu);
	}
	
	/**
	 * Creates a button and sets an action.
	 * @param theName name of the button.
	 * @return the button.
	 */
	private final JMenuItem populateMenu(final String theName) {
		final JMenuItem item = new JMenuItem(theName);
		item.setMnemonic(theName.charAt(0));
		item.addActionListener(myMenuAction);
		return item;
	}
}