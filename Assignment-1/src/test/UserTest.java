package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Residence;
import model.User;

/**
 * Unit Tests for User class
 *
 * @author Zira Cook
 * @version 14 April 2017
 */
final public class UserTest {

    /** Constant for initialized user name. */
    private static final String NAME = "Billy Bob";

    /** Constant for intialized user email. */
    private static final String EMAIL = "billyiscool@aol.com";

    /** User object for tests. */
    private User myUser;
    
    /** Residence Object for tests. */
    private Residence myHouse;

    @Before
    public void setUp() {
    	
        myUser = new User(NAME, EMAIL);
        myHouse = new Residence("Super Cool House");
        myUser.addResidence(myHouse);
    }

    /**
     * Test the copy constructor. 
     * @author Yaro Salo 
     */
    @Test 
    public void testCopyConst() {
    	final User user = new User(myUser.getName(), myUser.getEmail(), myUser.getResidences());
    	assertEquals("Copy Constructor fails", myUser, user);
    }
    @Test
    public void testGetName() throws Exception {
        assertEquals("Get name failed", NAME, myUser.getName());

    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("Get email failed", EMAIL, myUser.getEmail());
    }

    /**
     * Test getResidences() and addResidence().
     * @author Yaro Salo
     */
    @Test
    public void testGetResidences() {
    	final ArrayList<Residence> res = new ArrayList<>();
    	res.add(new Residence("Super Cool House"));
    	assertEquals("getResidences() doesn't return the expected result", myUser.getResidences(), res);
    }
   
    /** 
     * Test that getResidences() returns a copy not the same object. //Not done
     * @author Yaro Salo
     */
    @Test
    public void testGetResidencesDeepCopy() {
    	ArrayList<Residence> res = myUser.getResidences();
    	assertFalse("Get residences does not return a copy", myUser.getResidences() == res);
    }
    
    @Test
    public void testSetName() throws Exception {
        final String difName = "Jimmy John";
        myUser.setName(difName);
        assertEquals("Set name failed", difName, myUser.getName());
    }

    @Test
    public void testSetEmail() throws Exception {
        final String difEmail = "billyisrad@aol.com";
        myUser.setEmail(difEmail);
        assertEquals("Set name failed", difEmail, myUser.getEmail());
    }
    
    
    /**
     * Test equals() with NULL
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsNull() {
    	assertFalse("Null should always return false", myUser.equals(null));
    }
    
    /**
     * Test equals() with different Object.
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsDiffObject() {
    	assertFalse("equals() should be false when objects are of different type", 
    			myUser.equals(new String("Hello")));
    }
    /** 
     * Test the equals() method for reflexivity.
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsIsReflexive() { 
        assertTrue(myUser.equals(myUser)); 
        
    }

    /**
     * Test equals() method for symmetry.
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsIsSymmetric() {
    	ArrayList<Residence> list1 = new ArrayList<>();
    	ArrayList<Residence> list2 = new ArrayList<>();
    	list1.add(new Residence("Super Cool House"));
    	list2.add(new Residence("Super Cool House"));
        assertEquals(myUser, new User(NAME, EMAIL, list1)); 
        assertEquals(new User(NAME, EMAIL, list2), myUser);
        
    }
    
    /**
     * Test equals() for transitivity.
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsIsTransitive() {
    	final ArrayList<Residence> list1 = new ArrayList<>();
    	final ArrayList<Residence> list2 = new ArrayList<>();
    	final ArrayList<Residence> list3 = new ArrayList<>();
   
    	list1.add(new Residence("Super Cool House"));
    	list2.add(new Residence("Super Cool House"));
    	list3.add(new Residence("Super Cool House"));
        final User otherUser = new User(NAME, EMAIL, list1);
        
        assertEquals(myUser, new User(NAME, EMAIL, list2));
        assertEquals(new User(NAME, EMAIL, list2), otherUser);
        assertTrue(myUser.equals(otherUser));
        
    }
   
    /**  
     * Test not equals() all fields. 
     * @author Yaro Salo
     */
    @Test 
    public void testEqualsNotAllFields() {
    	final ArrayList<Residence> list1 = new ArrayList<>();
    	list1.add(new Residence("Semi Cool House"));
    	final User otherUser = new User(NAME + "extra", EMAIL + "extra", list1);
    	assertNotEquals("Names are different", myUser.getName(), otherUser.getName());
    	assertNotEquals("Emails are different", myUser.getEmail(), otherUser.getEmail());
    	assertNotEquals("Residences are different", myUser.getResidences(), otherUser.getResidences());
    }
    
    /**
     * Test hashCode(). 
     * @author Yaro Salo
     */
    @Test 
    public void testHashCodeBulk() {
    	final ArrayList<Residence> list1 = new ArrayList<>();
    	list1.add(new Residence("Super Cool House"));
    	final User otherUser = new User(NAME, EMAIL, list1);

        //Same items should have the same hash code.
    	assertTrue(myUser.hashCode() == otherUser.hashCode());
    }
}