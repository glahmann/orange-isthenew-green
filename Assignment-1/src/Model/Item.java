package Model;

/**
 * An item to be included in projects.
 * 
 * @author Donald Muffler
 * @version 20170517
 */
public class Item {

	/**
	 * The name of the item.
	 */
	private final String myName;
	
	/**
	 * The cost of the item.
	 */
	private double myCost;
	
	
	/**
	 * Constructs the item.
	 * @param theName the item's name.
	 * @param theCost the item's cost.
	 */
	public Item(final String theName, final double theCost) {
		myName = theName;
		myCost = theCost;
	}
	
	/**
	 * Getter for the item's name.
	 * @return name of the item.
	 */
	public final String getName() {
		return myName;
	}
	
	/**
	 * Getter for the cost of the item.
	 * @return the cost of the item.
	 */
	public final double getCost() {
		return myCost;
	}
}