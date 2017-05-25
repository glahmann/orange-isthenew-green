package model;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
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
	 * Returns a list of bills for a residence.
	 * @return the list of bills.
	 * @author Yaro Salo
	 */
	@JsonProperty("Bills")
	public final ArrayList<Bill> getBills() {
		ArrayList<Bill> copyBills = new ArrayList<>();
		for(Bill b: myBills) {
			copyBills.add(new Bill(b.getName(), b.getAmount(),
					b.getBeginMonth(), b.getBeginYear(),
					b.getEndMonth(), b.getEndYear()));
		}
		return copyBills;
	}

	/**
	 * Returns a list of projects for a residence.
	 * @return the list of projects.
	 * @author Yaro Salo 
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
	
    /**
     * {@inheritDoc}
     * 
     * Returns true if the specified object is equivalent to this Residence, and false 
     * otherwise. Two Residences are equivalent if the have the same fields.
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

        
            final Residence otherRes = (Residence) theOther; //theOther can be safely casted. 
           
            //if all fields are equal the objects are equal
            returnValue = Objects.equals(myName, otherRes.myName)
                       && Objects.equals(myProjectedBill, otherRes.myProjectedBill)
                       && Objects.equals(myBills, otherRes.myBills)
                       && Objects.equals(myProjects, otherRes.myProjects);
        } 
        
        return returnValue;
    }
    
    /**
     * {@inheritDoc}
     * 
     * Returns and integer hash code for a Residence.
     * @return hash code as an integer.
     * @author Yaro Salo
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myProjectedBill, myBills, myProjects);
    }
}