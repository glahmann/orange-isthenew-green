package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComboBox;

/**
 * A class to hold items from the database matching the selected type.
 * 
 * @author Garrett Lahmann
 * @version 6 June 2016
 */
public class Market {

    /**
     * List of items to display on screen.
     */
    private final ArrayList<Item> myAppliances;
    
    /**
     * List of items to display on screen.
     */
    private final ArrayList<Item> myInsulation;
    
    /**
     * List of items to display on screen.
     */
    private final ArrayList<Item> myLighting;
    
    /**
     * List of items to display on screen.
     */
    private final ArrayList<Item> myWindows;
    
    
    private Map<String, JComboBox<Integer>> myMap;
    
    /**
     * Creates a list of items 
     */
    public Market() {
        myAppliances = new ArrayList<Item>();
        myInsulation = new ArrayList<Item>();
        myLighting = new ArrayList<Item>();
        myWindows = new ArrayList<Item>();
        myMap = new HashMap<String, JComboBox<Integer>>();
        populateLists();
    }
    
    /**
     * Populates a list with all items of given type from database.
     * 
     * @param theType the item type to be added to list (OK: lighting, appliances, insulation, windows).
     */
    public void populateLists() {
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:item.db");
            conn.setAutoCommit(false);
            String[] types = {"appliances", "insulation", "lighting", "windows"};

            stmt = conn.createStatement();
            for (String type: types) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE type='" + type + "';");
                while (rs.next()) {
                    Item entry = new Item(rs.getString("type"), rs.getString("name"), 
                                          rs.getDouble("cost"), rs.getDouble("evalue"));
                    switch(type) {
                        case "appliances":
                            myAppliances.add(entry);
                            break;
                        case "insulation":
                            myInsulation.add(entry);
                            break;
                        case "lighting":
                            myLighting.add(entry);
                            break;
                        case "windows":
                            myWindows.add(entry);
                            break;
                    }
                }
                rs.close();
            }
            stmt.close();            
            conn.close();
        } catch (Exception theEx) {
            System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
            System.exit(0);
        }
    } 
    
    /**
     * Returns a copy of the specified list of items.
     * 
     * @return an ArrayList containing all items of the current type.
     */
    public ArrayList<Item> getItems(final String theType) {
        String type = theType.toLowerCase();
        ArrayList<Item> items = null;
        switch(type) {
            case "appliances":
                items = new ArrayList<Item>(myAppliances);
                break;
            case "insulation":
                items = new ArrayList<Item>(myInsulation);
                break;
            case "lighting":
                items = new ArrayList<Item>(myLighting);
                break;
            case "windows":
                items = new ArrayList<Item>(myWindows);
                break;
        }
        return items;
    }
    
    /**
     * 
     * @param theName
     * @param theCounter
     */
    public void addItemPair(final String theName, final JComboBox<Integer> theCounter) {
        myMap.put(theName, theCounter);
    }
    
    /**
     * 
     * @return a list of the selected items.
     */
    public ArrayList<Item> getSelected() {
        ArrayList<Item> selected = new ArrayList<Item>();
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:item.db");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            
            for(Entry<String, JComboBox<Integer>> entry : myMap.entrySet()) {
                int count = (int) entry.getValue().getSelectedItem();
                if (count > 0) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE name='" + entry.getKey() + "';");
                    Item itm = new Item(rs.getString("type"), rs.getString("name"),
                                        rs.getDouble("cost"), rs.getDouble("evalue"));
                    for (int i = 1; i <= count; i++) {
                        selected.add(itm);
                    }
                }
            }
            
            stmt.close();
            conn.close();
            
        } catch (Exception theEx) {
            System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
            System.exit(0);
        }
        return selected;
    }
    
}
