package controller;
/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

import java.awt.EventQueue;
import java.io.File;
import java.util.Date;

import model.Bill;
import model.Item;
import model.Project;
import model.Residence;
import model.User;
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
     */
    private Main() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * The main method, invokes the Gui. Command line arguments are
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