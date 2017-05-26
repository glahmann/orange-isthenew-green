package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.JSONSupport;
import model.Bill;
import model.Item;
import model.Project;
import model.Residence;
import model.User;

/**
 * Test class for import/export JSON
 * 
 * @author Donald Muffler
 * @version 20170516
 */
final public class JSONSupportTest {

	/**
	 * User name for testing.
	 */
	private final String USER_NAME = "Hoss";
	
	/**
	 * User email for testing.
	 */
	private final String USER_EMAIL = "bobsbestfriend@example.com";
	
	/**
	 * The user used for testing.
	 */
	private User myUser;

	/**
	 * Set up method for the tests. 
	 * @author Donald Muffler start method 
	 * @author Yaro Salo finish method
	 */
    @Before 
    public void setUp() {
    	myUser = new User(USER_NAME, USER_EMAIL);
    	Project project = new Project("Kind of Cool Project");
    	Item item = new Item("Kind of Cool Item", 100);
    	Bill bill = new Bill("Kind of Cool Bill", 50, 1, 2017, 2, 2017);
    	Residence house = new Residence("Kind of Cool House");
    	project.addItem(item);
    	
    	house.addBill(bill);
    	house.addProject(project);
    	myUser.addResidence(house);
    }
    
    /**
     * Test import/export feature at the same time.
     * 
     * @author Donald Muffler start method 
     * @author Yaro Salo finish method
     */
	@Test
	public void testPort() {
		
		File jSONFile = new File("test.json");
		JSONSupport.writeJSON(myUser, jSONFile);
		User testUser = JSONSupport.readJSON(jSONFile);
		assertTrue("JSON process failed", myUser.equals(testUser));	
	} 
	
	@After
	public void cleanup() throws IOException {
		Path path = Paths.get("test.json");
		Files.deleteIfExists(path);
	}
}