/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Item;

/**
 * Test the Item class
 * 
 * @author Isaac Seemann
 * @version May 29, 2017
 */
public class ItemTest {

	static final String NAME = "Super Saver 3000";
	
	static final double COST = 99.99;
	
	private Item myItem;
			
	/**
	 * Setup instances of Item for testing
	 */
	@Before
	public void setUp() throws Exception {
		myItem = new Item(NAME, COST);
	}

	
	/**
	 * Test Item constructor
	 * @author Isaac Seemann
	 */
	@Test
	public void testConstructor() {
		assertNotNull(new Item(NAME, COST));
	}
	
	/**
	 * Test Item name getter
	 * @author Isaac Seemann
	 */
	@Test
	public void testGetName() {
		assertTrue("Item's getName() failed", myItem.getName().equals(NAME));
	}
	
	/**
	 * Test Item cost getter
	 * @author Isaac Seemann
	 */
	@Test
	public void testGetCost() {
		assertEquals(COST, myItem.getCost(), 0.005);
	}
	
	/**
	 * Test Item hashCode method
	 * @author Isaac Seemann
	 */
	@Test
	public void testHashCode() {
		Item testItem = new Item(NAME, COST);
		assertEquals("Hash values not equal", myItem.hashCode(), testItem.hashCode());
	}
}