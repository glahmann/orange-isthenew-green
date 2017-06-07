package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.HousingType;
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
        myHouse = new Residence("Super Cool House", HousingType.APARTMENT);
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
    	res.add(new Residence("Super Cool House", HousingType.APARTMENT));
    	assertEquals("getResidences() doesn't return the expected result", myUser.getResidences(), res);
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
     * Test the removeResidence() with an existing residence.
     * @author Yaro Salo
     */
    @Test 
    public void testRemoveResidences() {
    	
    	final User user = new User("Bond", "bond@jamesbond");
    	final Residence house = new Residence("Bonds Place", HousingType.APARTMENT);
    	final Residence house2 = new Residence("Not Bonds Place", HousingType.APARTMENT);
    	
    	user.addResidence(house);
    	user.addResidence(myHouse);
    	
    	int sizeBefRemove = user.getResidences().size(); //test remove on non existing residence
    	user.removeResidence(house2);
    	assertTrue("The number of residences should not change", 
    			user.getResidences().size() == sizeBefRemove);
    	 
    	user.removeResidence(house); //test remove on existing residence
    	assertFalse("Failed to remove a residence", user.getResidences().contains(house));	
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
    	list1.add(new Residence("Super Cool House", HousingType.APARTMENT));
    	list2.add(new Residence("Super Cool House", HousingType.APARTMENT));
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
   
    	list1.add(new Residence("Super Cool House", HousingType.APARTMENT));
    	list2.add(new Residence("Super Cool House", HousingType.APARTMENT));
    	list3.add(new Residence("Super Cool House", HousingType.APARTMENT));
        final User otherUser = new User(NAME, EMAIL, list1);
        
        assertEquals(myUser, new User(NAME, EMAIL, list2));
        assertEquals(new User(NAME, EMAIL, list2), otherUser);
        assertTrue(myUser.equals(otherUser));
        
    }
    
    /**  
     * Test not equals() all possible combinations of true/false of the fields. 
     * @author Yaro Salo
     */ 
    @Test 
    public void testEquals() {
    	// Order of 1's and 0's: Name Email Residence 
    	// 1 means the fields are the same 0 means the fields are different. 
    	// 1 1 1 is tested by other methods.
    	
    	//Test  1 1 0
    	final ArrayList<Residence> list1 = new ArrayList<>();
     	list1.add(new Residence("Semi Cool House", HousingType.APARTMENT));
    	final User otherUser = new User(NAME, EMAIL, list1);
    	assertFalse("Residences are different", myUser.equals(otherUser));
    	
    	//Test 1 0 0 
    	otherUser.setEmail(EMAIL + "extra");
    	assertFalse("Residences and email are different", myUser.equals(otherUser));
    	
    	//Test 0 1 0 
    	otherUser.setEmail(EMAIL); //reset email
    	otherUser.setName(NAME + "extra");
    	assertFalse("Residences and name are different", myUser.equals(otherUser));
    	
    	//Test 0 0 0
    	otherUser.setEmail(EMAIL + "extra");
    	assertFalse("All fields are different", myUser.equals(otherUser));
    	
    	//Test 0 0 1
    	list1.remove(0); //reset residence list
    	list1.add(myHouse);
    	assertFalse("Name and email are different", myUser.equals(otherUser));
    	
    	//Test 0 1 1 
    	otherUser.setEmail(EMAIL);
    	assertFalse("Name is different", myUser.equals(otherUser));
    	
    	//Test 1 0 1
    	otherUser.setName(NAME);
    	otherUser.setEmail(EMAIL + "extra");
    	assertFalse("Email is different", myUser.equals(otherUser));
    }
    /**
     * Test hashCode(). 
     * @author Yaro Salo
     */
    @Test 
    public void testHashCode() {
    	final ArrayList<Residence> list1 = new ArrayList<>();
    	list1.add(new Residence("Super Cool House", HousingType.APARTMENT));
    	final User otherUser = new User(NAME, EMAIL, list1);

    	assertTrue(myUser.hashCode() == otherUser.hashCode());
    }
}