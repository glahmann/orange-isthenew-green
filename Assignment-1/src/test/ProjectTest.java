package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Item;
import model.Project;

/**
 * Test the project class.
 * 
 * @author Yaro Salo
 * @version May 25, 2017
 */
public class ProjectTest {
 
	
	/** The name of the project. */
	static final String NAME = "Super Cool Project"; 
	
	/** The saving of the project. */
	static final double SAVINGS = 50.00;
	
	/** The cost of the project. */
	static final double COST = 10.00;
	
	/** The list of items for a project. */
	private ArrayList<Item> myItems;
	
	/** Project instance to test. */ 
	private Project myProject; 
	

	/**
	 * Set up the method before each test.
	 * @author Yaro Salo
	 */
    @Before
    public void setUp() {
    	myItems = new ArrayList<>();
    	final Item item1 = new Item("Super Cool Item", 38.80);
    	final Item item2 = new Item("Super Lame Item", 40.71);
    	myItems.add(item1);
    	myItems.add(item2);
    	myProject = new Project(NAME, SAVINGS, COST, myItems);
    	
    }
    
    /**
     * Test the default constructor. 
     * @author Yaro Salo 
     */
    @Test 
    public void testDefaultConstructor() {
    	new Project(NAME);
    }
    
    /**
     * Test the copy constructor. 
     * @author Yaro Salo
     */
    @Test 
    public void testCopyConstructor() {
    	
    	new Project(NAME, SAVINGS, COST, myItems);
    }
    
    /**
     * Test the getName(). 
     * @author Yaro Salo
     */
    @Test
    public void testGetName() {
    	assertTrue("getName() failed", myProject.getName().equals(NAME));
    }
   
    /**
     * Test getSavings(), addToSavings() methods.
     */
    @Test 
    public void testSavings() {
    	myProject.addToSavings(SAVINGS);
    	assertTrue("adding to savings failed", (SAVINGS + SAVINGS) == (myProject.getSavings()));
    }
    
    /**
     * Test getCost(), addToCost methods.
     */
    @Test
    public void testCosts() {
    	myProject.addToCost(COST);
    	assertTrue("adding to savings failed", (COST + COST) == (myProject.getCost()));
    }
    
    /**
     * Test getResidences() and addResidence().
     * @author Yaro Salo
     */ 
    @Test
    public void testGetItems() {
    	final ArrayList<Item> it = new ArrayList<>();
    	it.add(new Item("Super Cool Item", 38.80));
    	it.add(new Item("Super Lame Item", 40.71));
    	
    	assertTrue("getItems() doesn't return the expected result", myProject.getItems().equals(it));
    }
   
    /** 
     * Test that the getItems() method returns a copy.
     * @author Yaro Salo
     */
    @Test
    public void testGetItemsDeepCopy() {
    	ArrayList<Item> it = myProject.getItems();
    	assertFalse("getItems() does not return a copy", myProject.getItems() == it);
    }
	
    /**
     * Test the addItem() method.
     *@author Yaro Salo
     */ 
    @Test  
    public void testAddItem() {
    	final Item item = new Item("Kind of Cool Item", 25.15);
    	myProject.addItem(item);
    	assertTrue(myProject.getItems().get(2).equals(item));
    }
    
    /**
     * Test the removeItem() method.
     * @author Yaro Salo 
     */
    @Test 
    public void testRemoveItem() {
    	final Project project = new Project("Super Cool Project");
    	final Item item = new Item("Super Cool Item", 100);
    	final Item item2 = new Item("Semi Cool Item", 100);
    	final Item item3 = new Item("Kind of Cool Item", 100);
    	project.addItem(item);
    	project.addItem(item2);
    	int sizeBefRemove = project.getItems().size(); //test remove on non existing residence
    	project.removeItem(item3);
    	assertTrue("The number of residences should not change", 
    			project.getItems().size() == sizeBefRemove);
    	 
    	project.removeItem(item); //test remove on existing residence
    	assertFalse("Failed to remove a residence", project.getItems().contains(item));
    }
    /**
     * Test hashCode() metod
     * @author Yaro Salo
     */
    @Test
    public void testHashCode() { 
    	
    	final ArrayList<Item> list1 = new ArrayList<>();
    	final Item item1 = new Item("Super Cool Item", 38.80);
    	final Item item2 = new Item("Super Lame Item", 40.71);
    	list1.add(item1);
    	list1.add(item2);
    	final Project otherProject = new Project(NAME,SAVINGS,COST, list1);
    	
    	assertTrue(myProject.hashCode() == otherProject.hashCode());
    	
    }
    
}
