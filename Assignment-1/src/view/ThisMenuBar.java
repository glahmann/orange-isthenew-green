package view;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The menu bar for the gui.
 * 
 * @author Donald Muffler
 * @author Zira Cook
 * @version 20170527
 */
public final class ThisMenuBar extends JMenuBar {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 2349500176859494038L;

	/**
	 * Action set for the menu items.
	 */
	private final Action myMenuAction;

    /**
     * Users name for the user menu option.
     */
    private final String myUserName;

	/**
	 * Constructs the menu.
	 * @param theAction action associated to the menu.
	 */
	public ThisMenuBar(final Action theAction, final String theUserName) {
		myMenuAction = theAction;
        myUserName = theUserName;
		buildMenu();
	}

	/**
	 * Builds the menu.
     * @author Donald Muffler
     * @author Zira Cook
	 */
	private final void buildMenu() {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		fileMenu.add(populateMenu("Home"));
		fileMenu.add(populateMenu("About..."));

		final JMenu userMenu = new JMenu("User");
		userMenu.setMnemonic('U');

        //Displays the users name as a disabled item
        JMenuItem userDisplayName;

        userDisplayName = new JMenuItem(myUserName);

        userMenu.add(userDisplayName);
        userDisplayName.setEnabled(false);

		add(fileMenu);
		add(userMenu);
	}
	
	/**
	 * Creates a button and sets an action.
	 * @param theName name of the button.
	 * @return the button.
	 * @author Donald Muffler
	 */
	private final JMenuItem populateMenu(final String theName) {
		final JMenuItem item = new JMenuItem(theName);
		item.setMnemonic(theName.charAt(0));
		item.addActionListener(myMenuAction);
		return item;
	}
}