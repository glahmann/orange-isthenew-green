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
	/** Name of test item*/
	static final String NAME = "Super Saver 3000";
	/** Cost of test item*/
	static final double COST = 99.99;
	/** Energy value of test item*/
	static final double EVALUE = 5.5;
	/** Type of test item*/
	static final String TYPE = "Window";
	/** Name of test item object*/
	private Item myItem;
			
	/**
	 * Setup instances of Item for testing
	 */
	@Before
	public void setUp() throws Exception {
		myItem = new Item(NAME, COST, EVALUE, TYPE);
	}

	
	/**
	 * Test Item constructor
	 * @author Isaac Seemann
	 */
	@Test
	public void testConstructor() {
		assertNotNull(new Item(NAME, COST, EVALUE, TYPE));
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
	 * Test Item eValue getter
	 * @author Isaac Seemann
	 */
	@Test
	public void testGetEValue() {
		assertEquals(EVALUE, myItem.getEValue(), 0.05);
	}
	
	/**
	 * Test Item Type getter
	 * @author Isaac Seemann
	 */
	@Test
	public void testGetType() {
		assertEquals(TYPE, myItem.getType());
	}
	/**
	 * Test Item hashCode method
	 * @author Isaac Seemann
	 */
	@Test
	public void testHashCode() {
		Item testItem = new Item(NAME, COST, EVALUE, TYPE);
		assertEquals("Hash values not equal", myItem.hashCode(), testItem.hashCode());
	}
}