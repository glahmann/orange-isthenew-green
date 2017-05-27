package model;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Stores items for the user.
 * 
 * @author Donald Muffler
 * @version 20170517
 */
@JsonPropertyOrder({"Project Name", "Savings", "Cost", "Items"})
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

	public Project(final String theName) {
		myName = theName;
		mySavings = 0;
		myCost = 0;
		myItems = new ArrayList<Item>();
	}
	
	/**
	 * Copy constructor. Used in JSON deserialization.
	 * 
	 * @param theName project name
	 * @param theSavings savings
	 * @param theCost cost
	 * @param theItems items 
	 * 
	 * @author Yaro Salo
	 */
	@JsonCreator
	public Project(@JsonProperty("Project Name")final String theName,
			@JsonProperty("Savings")final double theSavings,
			@JsonProperty("Cost")final double theCost,
			@JsonProperty("Items")final ArrayList<Item> theItems) {
		myName = theName;
		mySavings = theSavings;
		myCost = theCost;
		myItems = theItems;
	}
	/**
	 * Getter for the name of the project.
	 * @return the project's name.
	 */
	@JsonProperty("Project Name")
	public final String getName() {
		return myName;
	}

	/**
	 * Getter for the total savings of the project.
	 * @return the total savings.
	 */
	@JsonProperty("Savings")
	public final double getSavings() {
		return mySavings;
	}

	/**
	 * Getter for the total cost of the project.
	 * @return the total cost.
	 */
	@JsonProperty("Cost")
	public final double getCost() {
		return myCost;
	}

	/** 
	 * Getter for the list of items.
	 * @return the list of items.
	 * 
	 * @author Yaro Salo write deep copying
	 */
	@JsonProperty("Items")
	public final ArrayList<Item> getItems() {
		ArrayList<Item> copyItems = new ArrayList<>();
		for(Item i: myItems) { //deep copy of items
			copyItems.add(new Item(i.getName(), i.getCost()));
		}
		return copyItems;
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
	 * @author Donald Muffler 
	 * @author Yaro Salo
	 */
	public final void removeItem(final Item theItem) {
		if(myItems.contains(theItem)) {
			myItems.remove(theItem);
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
	
    /**
     * {@inheritDoc}
     * 
     * Returns true if the specified object is equivalent to this Projects, and false 
     * otherwise. Two Projects are equivalent if the have the same fields.
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

            final Project otherProject = (Project) theOther; //theOther can be safely casted. 
          
            //if all fields are equal the objects are equal
            returnValue = Objects.equals(myName, otherProject.myName)
                       && Objects.equals(myCost, otherProject.myCost) 
                       && Objects.equals(myItems, otherProject.myItems);
            
        } 
        return returnValue;
    }
    
    /**
     * {@inheritDoc}
     *
     * Returns and integer hash code for a Project.
     * @return hash code as an integer.
     * @author Yaro Salo
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myCost, myItems);
    }
}