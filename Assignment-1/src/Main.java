/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

import java.awt.EventQueue;

/**
 * Start the GUI application.
 * 
 * @author Yaro Salo
 * @version April 12, 2017
 */
public final class Main {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private Main() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * The main method, invokes the Gui. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
    	User user = new User("Yaro Salo", "ysalo@uw.edu");    
		JSONSupport.writeJSON(user, "C:\\Users\\Slavik\\Desktop\\testFile.json");
		User newUser = JSONSupport.readJSON("C:\\Users\\Slavik\\Desktop\\testFile.json");
		System.out.println(newUser.getEmail()+ newUser.getName());
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().start();
            }
        });
    }
}