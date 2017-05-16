package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controller.JSONSupport;
import Model.User;

public class JSONSupportTest {

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

    @Before
    public void setUp() {
    	myUser = new User(USER_NAME, USER_EMAIL);
    }
	
	@Test
	public void testPort() {
		//this method actually tests import and export at the same time.
		File jSONFile = new File("test");
		JSONSupport.writeJSON(myUser, jSONFile);
		User testUser = JSONSupport.readJSON(jSONFile);
		assertEquals("Getting correct name failed.", myUser.getName(), testUser.getName());
		assertEquals("Getting correct email failed.", myUser.getEmail(), testUser.getEmail());
	}
	
	@After
	public void cleanup() throws IOException {
		Path path = Paths.get("test");
		Files.deleteIfExists(path);
	}
}