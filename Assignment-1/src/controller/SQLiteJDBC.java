/**
 * 
 */
package controller;
import java.sql.*;
import java.util.Scanner;


/**
 * A class to create and manage the database.
 * 
 * @author Garrett Lahmann
 * @version 30 March 2017
 */
public class SQLiteJDBC {
    /**
     * Driver for database management.
     * 
     * @param theArgs
     */
	public static void main(String theArgs[]) {  
		Scanner console = new Scanner(System.in);
//	    Connection conn = getConnection();
	    System.out.println("Add table to database? y/n");
	    if (console.nextLine().equalsIgnoreCase("y")) {
		    createTable();
	    }
	    System.out.println("Add items to database? y/n");
	    if (console.nextLine().equalsIgnoreCase("y")) {
            addEntries(console);
        }
	    displayEntries();
	    
	    System.out.println("Delete an entry? y/n");
	    if (console.nextLine().equalsIgnoreCase("y")) {
	        deleteEntry(console);
	    }
//	  conn.close();
	    console.close();
	}
  
    /**
     * Prompts user to add energy items to the database.
     * 
     * @param theConsole a scanner connection for io.
     */
    private static void addEntries(final Scanner theConsole) {
    	double cost, eValue;
	    String name, type, sql, again = "y";
	    Connection conn = null;
	    Statement stmt = null;
	  
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	conn = DriverManager.getConnection("jdbc:sqlite:item.db");
	    	System.out.println("Opened database successfully");
	    	
	    	// Add new items to db
	    	while (again.equalsIgnoreCase("y")) { 
	    		System.out.println("Enter item type: ");
	    		type = theConsole.nextLine();
	    		System.out.println("Enter item name: ");
	    		name = theConsole.nextLine();
	    		System.out.println("Enter item cost: ");
	    		cost = theConsole.nextDouble();
	    		System.out.println("Enter item energy value: ");
	    		eValue = theConsole.nextDouble();
	    		theConsole.nextLine(); // consume '\n'
			  
	    		// Insert entry into db
	    		stmt = conn.createStatement();
	    		sql = "INSERT INTO ITEM (TYPE,NAME,COST,EVALUE)" +
	    			  "VALUES ('" + type + "', '" + name + "', " + cost + ", '" + eValue + "');";
	    		stmt.executeUpdate(sql);
	    		stmt.close();
			  			  
	    		System.out.println("Add another? y/n");
	    		again = theConsole.nextLine();
	    	}
	    	
	    	conn.close();
	    } catch (Exception theEx) {
		    System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
		    System.exit(0);
	    }
	    
    }
    
    /**
     * Allows user to delete a specified entry based on name.
     * 
     * @param theConsole a scanner connection for io.
     */
    private static void deleteEntry(final Scanner theConsole) {
        String sql, delete;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:item.db");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            
            System.out.println("Enter an item NAME to delete: ");
            delete = theConsole.nextLine();
            System.out.println(delete);
            sql = "DELETE FROM item WHERE name = '" + delete +"';";
            stmt.executeUpdate(sql);
            conn.commit();

            rs = stmt.executeQuery("SELECT * FROM item;");
            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                double cost  = rs.getDouble("cost");
                double evalue = rs.getDouble("evalue");

                System.out.println("Type = " + type);
                System.out.println("Name = " + name);
                System.out.println("Cost = " + cost );
                System.out.println("Energy value = " + evalue);
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }
    
    /**
     * Displays all entries in database.
     */
    private static void displayEntries() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:item.db");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item;");
            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                double cost  = rs.getDouble("cost");
                double evalue = rs.getDouble("evalue");

                System.out.println("Type = " + type);
                System.out.println("Name = " + name);
                System.out.println("Cost = " + cost );
                System.out.println("Energy value = " + evalue);
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception theEx) {
            System.err.println(theEx.getClass().getName() + ": " + theEx.getMessage() );
            System.exit(0);
        }
    }
  
    /**
     * Creates a table within the database.
     */
    private static void createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:item.db");
            System.out.println("Opened database successfully");
	
            stmt = c.createStatement();
            String sql = "CREATE TABLE ITEM" +
                         "(TYPE TEXT NOT NULL, " +
                         " NAME TEXT PRIMARY KEY NOT NULL, " + 
                         " COST REAL NOT NULL, " + 
                         " EVALUE REAL NOT NULL);"; 
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception theEx) {
            System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
  
    /**
     * Establishes a connection with the item database or creates one if it doesn't exist.
     * 
     * @return an open database connection.
     */
    private static Connection getConnection() {
	    Connection conn = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection("jdbc:sqlite:item.db");
	    } catch (Exception theEx) {
	      System.err.println( theEx.getClass().getName() + ": " + theEx.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return conn;
    }
}
