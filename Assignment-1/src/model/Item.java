package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An item to be included in projects.
 * 
 * @author Donald Muffler (Created class and did basic methods i.e. getters and constructor excluding Json.)
 * @author Garrett Lahmann
 * @author Yaro Salo (Json, hash, equals)
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
	public Item(@JsonProperty("Item Type")final String theType,
	        @JsonProperty("Item Name")final String theName, 
			@JsonProperty("Item Cost")final double theCost,
			@JsonProperty("Item Energy Value")final double theEValue) {
	    myType = theType;
	    myName = theName;
		myCost = theCost;
		myEValue = theEValue;
		
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
	 * @author Garrett Lahmann
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
  
    /**
     * {@inheritDoc}
     * 
     * Returns true if the specified object is equivalent to this Item, and false 
     * otherwise. Two Items are equivalent if the have the same fields.
     * 
     * @param theOther is the Object being tested.
     * @return true if objects are equal and false otherwise.
     * @author Yaro Salo
     */
    @Override
    public boolean equals(final Object theOther) {
        
        boolean returnValue = false;
        
        if (this == theOther) { //is the Object being tested this Object?
            returnValue = true;
        
        } else if (theOther != null && this.getClass() == theOther.getClass()) { //is theOther Object a User object? 
            
        
            final Item otherItem = (Item) theOther; //theOther can be safely casted. 
           
            //if all fields are equal the objects are equal
            returnValue = Objects.equals(myName, otherItem.myName)
                       && Objects.equals(myCost, otherItem.myCost)
                       && Objects.equals(myEValue, otherItem.myEValue)
                       && Objects.equals(myType, otherItem.myType);
        } 
        
        return returnValue;
    }
    
    /**
     * {@inheritDoc}
     * 
     * Returns and integer hash code for an Item.
     * @return hash code as an integer.
     * @author Yaro Salo
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myCost);
    }
    
    /**
     * @return Formatted string summary of Item
     * @author Isaac Seemann
     */
    @Override
    public String toString(){
    	return myName + "\nType: " + myType + "\nEnergy: " + String.valueOf(myEValue) + " Watts\nCost: $" +
    			String.valueOf(myCost);
    }
}