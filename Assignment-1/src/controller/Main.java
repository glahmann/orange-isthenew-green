package controller;
/*
 * Starts the GUI application. 
 */

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

import model.User;
import view.*;

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
    	
    	// add user data to actions.
    	final HomeActions homeAction = new HomeActions(user);
    	final ManageResidenceActions residenceAction = new ManageResidenceActions(user);
    	
    	// add menu actions to panels.
    	final MenuActions menuAction = new MenuActions(user);
    	LoginPane.getInstance().setAction(menuAction);
    	SetupPane.getInstance().setAction(menuAction);
    	
    	// add home actions to panels.
    	HomeScreen.getInstance().connectPanelToAction(homeAction);
    	CreateProject.getInstance().setAction(homeAction);
    	
    	// add residence action to residence panel
    	ManageResidenceScreen.getInstance().setAcion(residenceAction);
    	
    	// add JMenu to the main frame.
    	final ThisMenuBar menu = new ThisMenuBar(menuAction);
    	Gui.getInstance().setMenu(menu);
    	
    	// add panels to the main frame.
    	Gui.getInstance().addPanel(HomeScreen.getInstance(), "Home");
    	Gui.getInstance().addPanel(ManageResidenceScreen.getInstance(), "Manage Residences");
		Gui.getInstance().addPanel(ProjectMarket.getInstance(), "Market");
		Gui.getInstance().addPanel(CalcPane.getInstance(), "Calculator");
    	
    	// add panels to the custom dialogue frame.
    	CustomOptionFrame.getInstance().addPanel(LoginPane.getInstance(), "Login");
    	CustomOptionFrame.getInstance().addPanel(SetupPane.getInstance(), "Setup");
    	CustomOptionFrame.getInstance().addPanel(CreateProject.getInstance(), "Create Project");
    	
    	// displays login page.
    	CustomOptionFrame.getInstance().displayPanel("Login");
    }
}