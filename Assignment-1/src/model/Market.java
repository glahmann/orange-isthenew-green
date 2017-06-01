package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A class to hold items from the database matching the selected type.
 * 
 * @author Garrett Lahmann
 * @version 30 May 2016
 */
public class Market {

    /**
     * List of items to display on screen.
     */
    private final ArrayList<Item> myItems;
    
    /**
     * Creates a list of items 
     */
    public Market() {
        myItems = new ArrayList<Item>();
        changeTab("light");
    }
    
    /**
     * Populates a list with all items of given type from database.
     * 
     * @param theType the item type to be added to list (OK: light, appliance, insulation, window).
     */
    public void changeTab(final String theType) {
        myItems.clear();
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:item.db");
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE type='" + theType + "';");
            while (rs.next()) {
                Item entry = new Item(rs.getString("type"), rs.getString("name"), 
                                      rs.getDouble("cost"), rs.getDouble("evalue"));
                myItems.add(entry);
            }
            rs.close();
            stmt.close();            
            conn.close();
        } catch (Exception theEx) {
            System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
            System.exit(0);
        }
    } 
    
    /**
     * Returns the current list of items of a certain type.
     * TODO Better encapsulation
     * 
     * @return an ArrayList containing all items of the current type.
     */
    public ArrayList<Item> getItems() {
        return myItems;
    }
}
