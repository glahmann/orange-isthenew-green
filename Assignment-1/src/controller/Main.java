package controller;
/*
 * Starts the GUI application. 
 */

import java.awt.EventQueue;

import model.User;
import view.Gui;
import view.HomeScreen;
import view.LoginPane;
import view.ManageResidenceScreen;
import view.ThisMenuBar;

/**
 * Start the GUI application.
 * 
 * @author Yaro Salo
 * @version April 12, 2017
 */
public final class Main {

    /**
     * Private constructor, to prevent instantiation of this class.
     * @author Yaro Salo
     */
    private Main() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * The main method, invokes the GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     * @author Yaro Salo
     * @author Donald Muffler
     */
    public static void main(final String[] theArgs) {  

    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	start();
            }
        });
    }
    
    /**
     * @author Donald Muffler
     * Helper method for instantiating and passing dependencies.
     */
    private final static void start() {
    	final User user = new User(null, null); // TODO: overload constructor.
    	final MenuActions menuAction = new MenuActions(user);
    	final LoginPane login = new LoginPane(menuAction);
    	final ThisMenuBar menu = new ThisMenuBar(menuAction);
    	Gui.getInstance().setMenu(menu);
    	
    	// add panels to the frame.
    	Gui.getInstance().addPanel(HomeScreen.getInstance(), "Home");
    	Gui.getInstance().addPanel(ManageResidenceScreen.getInstance(), "Manage Residences");
    	
    	final HomeActions homeAction = new HomeActions(user);
    	final ManageResidenceActions residenceAction = new ManageResidenceActions(user);
    	
    	// add actions to panels.
    	HomeScreen.getInstance().connectPanelToAction(homeAction);
    	
    	Gui.getInstance().displayPanel("Home");
    }
}