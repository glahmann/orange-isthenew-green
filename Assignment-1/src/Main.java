/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

import java.awt.EventQueue;

/**
 * Main entry point for the simple Gui.
 */
public final class Main {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private Main() {
        throw new IllegalStateException();
    }
    
    /**
     * The main method, invokes the SnapShop GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().start();
            }
        });
    }
}