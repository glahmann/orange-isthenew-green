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
	  Connection c = null;
	  Statement stmt = null;
	  try {
	    Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:item.db");
	    System.out.println("Opened database successfully");
	
	    stmt = c.createStatement();
	    String sql = "CREATE TABLE COMPANY " +
	                 "(ID INT PRIMARY KEY     NOT NULL," +
	                 " NAME           TEXT    NOT NULL, " + 
	                 " AGE            INT     NOT NULL, " + 
	                 " ADDRESS        CHAR(50), " + 
	                 " SALARY         REAL)"; 
	    stmt.executeUpdate(sql);
	    stmt.close();
	    c.close();
	  } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	  }
	  System.out.println("Table created successfully");
	  
  }
  
  /**
   * 
   */
  private void addEntries() {
	  double cost;
	  Scanner input = new Scanner(System.in);
	  String name, type, again = "y";
	  
	  // Add new items to db
	  // TODO put in separate method?
	  while (again.equalsIgnoreCase("y")) { 
		  System.out.println("Enter item name: ");
		  name = input.nextLine();
		  System.out.println("Enter item cost: ");
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
   * 
   * @author Garrett Lahmann
   * @return an open database connection.
   */
  public Connection getConnection() {
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
