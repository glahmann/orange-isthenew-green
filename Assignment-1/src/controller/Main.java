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
    	User user = new User("Slavik Salo" , "ysalo@uw.edu");
    	File file = new File("file.json");
    	Project project = new Project("Super Cool Project");
    	Item item = new Item("Super Cool Item", 100);
    	Bill bill = new Bill("Super Cool Bill", 50, new Date(), new Date());
    	Residence house = new Residence("Super Cool House");
    	project.addItem(item);
    	
    	house.addBill(bill);
    	house.addProject(project);
    	user.addResidence(house);
    	JSONSupport.writeJSON(user, file);
    	User newUser = JSONSupport.readJSON(file);
    	System.out.println(newUser.getName() + " " + newUser.getEmail());
    	
    	
//    	EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Gui().start();
//            }
//        });
    }
}