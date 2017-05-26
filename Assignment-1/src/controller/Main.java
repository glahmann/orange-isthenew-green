package controller;
/*
 * Starts the GUI application. 
 */

import java.awt.EventQueue;

import view.Gui;

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