package model;

import java.util.ArrayList;

/**
 * Shopping cart data model
 * @author Isaac Seemann
 * @version 5/31/17
 * 
 */
public class Cart {

	private ArrayList<Item> myItems;
	
	private double myTotal;
	
	/**Empty cart constructor*/
	public Cart() {
		myTotal = 0.0;
		myItems = new ArrayList<>();
	}
	
	/**
	 * Cart constructor with existing ArrayList of items
	 * @param theItems list of items to initialize the cart with
	 */
	public Cart(final ArrayList<Item> theItems) {
		myTotal = 0.0;
		myItems = new ArrayList<>();
		myItems.addAll(theItems);
		
		for(Item item : theItems){
			myTotal += item.getCost();
		}
	}
	
	/**
	 * Remove an item to the cart
	 * @param theItem
	 */
	public void removeItem(final Item theItem){
		myItems.remove(theItem);
	}
	/**Total number of items in the cart
	 * @return Item count in cart
	 */
	public int getTotalItems(){
	    return myItems.size();
	}
	/**Total cost of items in the cart
	 * @return Item count in cart
	 */
	public double getTotalCost(){
	    return myTotal;
	}
	/**
	 * Add the items to project, include total cost and Evalue->savings(TBD)
	 * @param theProject
	 */
	public void checkout(final Project theProject){
		//double totalEValue = 0.0;
		for(Item item : myItems){
			theProject.addItem(item);
			String type = item.getType();
			//TODO calculate savings based on type of item
			switch(type){
				case "Light":
					break;
				case "Appliance":
					break;
				case "Window":
					break;
				case "Insulation":
					break;
				default:
					System.err.println("Error adding " + item.getName() + " to project");
					break;
			}
			//totalEValue += item.getEValue();
		}
		theProject.addToCost(myTotal);	
				
	}
	
	

}
