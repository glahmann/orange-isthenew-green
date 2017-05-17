package Model;

import java.util.ArrayList;

/**
 * Stores items for the user.
 * 
 * @author Donald Muffler
 * @author 
 * @version 20170517
 */
public class Project {
	
	/**
	 * Savings for the project.
	 */
	private double mySavings;
	
	/**
	 * Total cost of the project.
	 */
	private double myCost;
	
	/**
	 * List of items.
	 */
	private final ArrayList<Item> myItems;

	/**
	 * Constructs the project for the user.
	 */
	public Project() {
		mySavings = 0;
		myCost = 0;
		myItems = new ArrayList<Item>();
	}
	
	/**
	 * Adds the item to the project.
	 * @param theItem the item to add.
	 */
	public final void addItem(final Item theItem) {
		
	}
	
	/**
	 * Removes the item from the project.
	 * @param theItem the item to remove.
	 */
	public final void removeItem(final Item theItem) {
		
	}
	
	/**
	 * Adds to the total savings.
	 * @param theAmount the amount to be added.
	 */
	public final void addToSavings(final double theAmount) {
		
	}
	
	/**
	 * Adds to the total amount.
	 * @param theAmount
	 */
	public final void addToCost(final double theAmount) {
		
	}
	
	/**
	 * Getter for the total savings of the project.
	 * @return the total savings.
	 */
	public final double getSavings() {
		return mySavings;
	}
	
	/**
	 * Getter for the total cost of the project.
	 * @return the total cost.
	 */
	public final double getCost() {
		return myCost;
	}
}