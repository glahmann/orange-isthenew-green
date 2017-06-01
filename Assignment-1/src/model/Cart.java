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
		double myTotal = 0.0;
		myItems = new ArrayList<>();
	}
	
	/**
	 * Cart constructor with existing ArrayList of items
	 * @param theItems list of items to initialize the cart with
	 */
	public Cart(final ArrayList<Item> theItems) {
		double myTotal = 0.0;
		myItems = new ArrayList<>();
		myItems.addAll(theItems);
		
		for(Item item : theItems){
			myTotal += item.getCost();
		}
	}
	/**
	 * Add an item to the cart
	 * @param theItem
	 */
	public void addItem(final Item theItem){
		myItems.add(theItem);
	}
	/**
	 * Remove an item to the cart
	 * @param theItem
	 */
	public void removeItem(final Item theItem){
		myItems.remove(theItem);
	}
	/**Total number of items in the cart*/
	public int getTotalItems(){
	    return myItems.size();
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
