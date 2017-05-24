package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Class to contain User house information and projects associated
 * with this residence.
 * 
 * @author Donald Muffler
 * @version 20170516
 */
@JsonPropertyOrder({"Residence Name", "Projected Bill", "Bills", "Projects"})
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
	 * Copy constructor. Used in JSON deserialization.
	 * 
	 * @param theName residence name
	 * @param theProjectedBill the projected bill
	 * @param theBills residence bills 
	 * @param theProjects residence projects
	 * 
	 * @author Yaro Salo
	 */
	@JsonCreator
	public Residence(@JsonProperty("Residence Name")final String theName,
			@JsonProperty("Projected Bill")final double theProjectedBill,
			@JsonProperty("Bills")ArrayList<Bill> theBills,
			@JsonProperty("Projects")final ArrayList<Project> theProjects) {
		myName = theName;
		myProjectedBill = 0;
		myBills = theBills;
		myProjects = theProjects;
	}
	/**
	 * Getter for the residence's name.
	 * @return the name of the residence.
	 */
	@JsonProperty("Residence Name")
	public final String getName() {
		return myName;
	}
	
	/**
	 * Getter for the projected bill.
	 * @return the project bill amount.
	 */
	@JsonProperty("Projected Bill")
	public final double getProjectedBill() {
		return myProjectedBill;
	}

	/**
	 * Getter for the list of bills.
	 * @return the list of bills.
	 * 
	 * @author Yaro Salo write deep copying
	 */
	@JsonProperty("Bills")
	public final ArrayList<Bill> getBills() {
		ArrayList<Bill> copyBills = new ArrayList<>();
		for(Bill b: myBills) {
			copyBills.add(new Bill(b.getName(), b.getAmount(),
					b.getBeginMonth(), b.getBeginYear(),
					b.getEndMonth(), b.getEndYear()));
		}
		
		// returns a deep copy.
		return copyBills;
	}

	/**
	 * Getter for the list of projects.
	 * @return the list of projects.
	 * 
	 * @author Yaro Salo write deep copying
	 */
	@JsonProperty("Projects")
	public final ArrayList<Project> getProjects() {
		 
		ArrayList<Project> copyProjects = new  ArrayList<>();
		 for(Project p: myProjects) {   //deep copy
			 copyProjects.add(new Project(p.getName(),p.getSavings(),
					 p.getCost(), p.getItems()));
		 }
		return copyProjects;
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