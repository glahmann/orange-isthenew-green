package model;

import java.util.ArrayList;

/**
 * Class to contain User house information and projects associated
 * with this residence.
 * 
 * @author Donald Muffler
 * @version 20170516
 */
final public class Residence {
	
	/**
	 * Name of the residence.
	 */
	private final String myName;
	
	/**
	 * The projected amount for the next bill.
	 */
	private double myProjectedBill;
	
	/**
	 * List of previous bills.
	 */
	private final ArrayList<Bill> myBills;
	
	/**
	 * List of projects.
	 */
	private final ArrayList<Project> myProjects;

	/**
	 * Constructs the user's residence.
	 * @param theName the name of the residence.
	 */
	public Residence(final String theName) {
		myName = theName;
		myProjectedBill = 0;
		myBills = new ArrayList<Bill>();
		myProjects = new ArrayList<Project>();
	}
	
	/**
	 * Getter for the residence's name.
	 * @return the name of the residence.
	 */
	public final String getName() {
		return myName;
	}
	
	/**
	 * Getter for the projected bill.
	 * @return the project bill amount.
	 */
	public final double getProjectedBill() {
		return myProjectedBill;
	}

	/**
	 * Getter for the list of bills.
	 * @return the list of bills.
	 */
	public final ArrayList<Bill> getBills() {
		// returns a deep copy.
		return null;
	}

	/**
	 * Getter for the list of projects.
	 * @return the list of projects.
	 */
	public final ArrayList<Project> getProjects() {
		// returns a deep copy.
		return null;
	}

	/**
	 * Adds a project to this residence.
	 * @param theProject the project to be added.
	 */
	public final void addProject(final Project theProject) {
		myProjects.add(theProject);
	}
	
	/**
	 * Removes a project from this residence.
	 * @param theProject the project to be removed.
	 */
	public final void removeProject(final Project theProject) {
		int currentIndex = 0;
		boolean found = false;
		
		while(!found && currentIndex < myProjects.size()) {
			if (myProjects.get(currentIndex).getName().equals(theProject.getName())) {
				myProjects.remove(currentIndex);
				found = true;
			}
			currentIndex++;
		}
	}
	
	/**
	 * Adds a bill to this residence.
	 * @param theBill the bill to be added.
	 */
	public final void addBill(final Bill theBill) {
		myBills.add(theBill);
	}
	
	/**
	 * Removes a bill from this residence.
	 * @param theBill the bill to be removed.
	 */
	public final void removeBill(final Bill theBill) {
		int currentIndex = 0;
		boolean found = false;
		
		while(!found && currentIndex < myProjects.size()) {
			if (myProjects.get(currentIndex).getName().equals(theBill.getName())) {
				myProjects.remove(currentIndex);
				found = true;
			}
			currentIndex++;
		}
	}
}