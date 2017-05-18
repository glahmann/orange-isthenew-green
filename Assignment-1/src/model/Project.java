package model;

import java.util.ArrayList;

/**
 * Stores items for the user.
 * 
 * @author Donald Muffler
 * @version 20170517
 */
final public class Project {
	
	/**
	 * Name of the project.
	 */
	private final String myName;
	
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
	public Project(final String theName) {
		myName = theName;
		mySavings = 0;
		myCost = 0;
		myItems = new ArrayList<Item>();
	}
	
	/**
	 * Getter for the name of the project.
	 * @return the project's name.
	 */
	public final String getName() {
		return myName;
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

	/**
	 * Getter for the lit of items.
	 * @return the list of items.
	 */
	public final ArrayList<Item> getItems() {
		// returns a deep copy.
		return null;
	}

	/**
	 * Adds the item to the project.
	 * @param theItem the item to add.
	 */
	public final void addItem(final Item theItem) {
		myItems.add(theItem);
	}
	
	/**
	 * Removes the item from the project.
	 * @param theItem the item to remove.
	 */
	public final void removeItem(final Item theItem) {
		int currentIndex = 0;
		boolean found = false;
		
		while(!found && currentIndex < myItems.size()) {
			if (myItems.get(currentIndex).getName().equals(theItem.getName())) {
				myItems.remove(currentIndex);
				found = true;
			}
			currentIndex++;
		}
	}
	
	/**
	 * Adds to the total savings.
	 * @param theAmount the amount to be added.
	 */
	public final void addToSavings(final double theAmount) {
		mySavings += theAmount;
	}
	
	/**
	 * Adds to the total amount.
	 * @param theAmount
	 */
	public final void addToCost(final double theAmount) {
		myCost += theAmount;
	}
}