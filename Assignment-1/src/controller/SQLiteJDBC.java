/**
 * 
 */
package controller;
import java.sql.*;
import java.util.Scanner;


/**
 * 
 * 
 * @author Garrett Lahmann
 * @version 25 March 2017
 */
public class SQLiteJDBC {
  public static void main(String args[]) {  
	  Scanner console = new Scanner(System.in);
//	  Connection conn = getConnection();
	  System.out.println("Add table to database? y/n");
	  if (console.nextLine().equalsIgnoreCase("y")) {
		  createTable(/*conn*/);
	  }
	  
//	  conn.close();
	  console.close();
  }
  
  /**
   * Prompts user to add energy items to the database.
   */
  private void addEntries(final Scanner theConsole) {
	  double cost, eValue;
	  Scanner input = new Scanner(System.in);
	  String name, type, again = "y";
	  
	  // Add new items to db
	  // TODO put in separate method?
	  while (again.equalsIgnoreCase("y")) { 
		  System.out.println("Enter item name: ");
		  name = input.nextLine();
		  System.out.println("Enter item cost: ");
		  cost = input.nextDouble();
		  System.out.println("Enter item energy value: ");
		  cost = input.nextDouble();
		  System.out.println("Enter item type: ");
		  type = input.nextLine();
		  
		  System.out.println("Add another? y/n");
		  again = input.nextLine();
	  }
	  
	  //TODO INSERT commands
	  
	  input.close();
  }
  
  /**
   * 
   * @param theConn an open database connection.
   */
  private static void createTable(/*final Connection theConn*/) {
	  Connection c = null;
	  Statement stmt = null;
	  try {
	    Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:item.db");
	    System.out.println("Opened database successfully");
	
	    stmt = c.createStatement();
	    String sql = "CREATE TABLE ITEM " +
	                 "(TYPE TEXT PRIMARY KEY  NOT NULL, " +
	                 " NAME           TEXT    NOT NULL, " + 
	                 " COST           REAL    NOT NULL, " + 
	                 " EVALUE         REAL    NOT NULL)"; 
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
