package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An item to be included in projects.
 * 
 * @author Donald Muffler
 * @author Garrett Lahmann
 * @version 20170517
 */
@JsonPropertyOrder({"Item Name", "Item Cost"})
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
	 * TODO use generic type here?
	 * The energy value of the item.
	 */
	private double myEValue;
	
	/**
	 * The type of the item.
	 */
	private String myType;
	
	
	
	/**
	 * Constructs the item.
	 * @param theName the item's name.
	 * @param theCost the item's cost.
	 */
	@JsonCreator
	public Item(@JsonProperty("Item Name")final String theName, 
			@JsonProperty("Item Cost")final double theCost,
			@JsonProperty("Item Energy Value")final double theEValue,
			@JsonProperty("Item Type")final String theType) {
		myName = theName;
		myCost = theCost;
		myEValue = theEValue;
		myType = theType;
	}
	
	/**
	 * Getter for the item's name.
	 * @return name of the item.
	 */
	@JsonProperty("Item Name")
	public final String getName() {
		return myName;
	}
	
	/**
	 * Getter for the cost of the item.
	 * @return the cost of the item.
	 */
	@JsonProperty("Item Cost")
	public final double getCost() {
		return myCost;
	}
	
	/**
	 * Getter for the cost of the item.
	 * @return the cost of the item.
	 */
	@JsonProperty("Item Energy Value")
	public final double getEValue() {
		return myEValue;
	}
	
	/**
	 * Getter for the type of the item.
	 * @author Garrett Lahmann
	 * @return the type of the item.
	 */
	@JsonProperty("Item Type")
	public final String getType() {
		return myType;
	}
}