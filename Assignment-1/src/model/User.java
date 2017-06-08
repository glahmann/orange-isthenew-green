
 package model;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

/**
 * Represents a user that has a name and an email.
 * 
 * @author Yaro Salo
 * @version April 12, 2017
 */
@JsonPropertyOrder({"User Name", "User Email", "Residences"})
@JsonIgnoreProperties({"currentResidence"})
final public class User extends Observable {
	
	/** The name of the user. */
	private String myName;
	
	/** The email of the user. */
	private String myEmail;
	
	/** List of residences. */
	private final ArrayList<Residence> myResidences;
	
	private Residence myCurrentRes;
	
	/**
	 * Default constructor that allows to create an empty user.
	 * @author Yaro Salo
	 */
	public User() {
		myName = "";
		myEmail = "";
		myResidences = new ArrayList<Residence>(); 
	}
	
	/**
	 * Initialize instance fields.
	 * 
	 * @param theName the name of the user.
	 * @param theEmail the email of the user.
	 * @author Yaro Salo
	 */ 
	public User(final String theName, final String theEmail) {
		myName = theName;
		myEmail = theEmail;
		myResidences = new ArrayList<Residence>();
	}
	
	/**
	 * Copy constructor. Used in JSON deserialization.
	 * @param theName user name
	 * @param theEmail user email 
	 * @param theResidences user residences
	 * @author Yaro Salo	
	 */
	@JsonCreator 
	public User(@JsonProperty("User Name")final String theName, 
			@JsonProperty("User Email")final String theEmail,
			@JsonProperty("Residences") ArrayList<Residence> theResidences) {
		myName = theName;
		myEmail = theEmail;
		myResidences = theResidences;
	}
	
	/**
	 * Gets the name of the user.
	 * @return the name of the user.
	 * @author Yaro Salo
	 */
	@JsonProperty("User Name")
	public String getName() {
		return myName;
	}

	/**
	 * Gets the email of the user. 
	 * @return the email of the user.
	 * @author Yaro Salo
	 */
	@JsonProperty("User Email")
	public String getEmail() {
		return myEmail;
	}

	public final void setCurrentResidence(final String theResidenceName) {
		for (Residence currentRes: myResidences) {
			if (theResidenceName.equals(currentRes.getName())) {
				myCurrentRes = currentRes;
			}
		}
	}
	
	//@JsonIgnore
	public final Residence getCurrentResidence() {
		return myCurrentRes;
	}

	/**
	 * Returns the list of residences for a user.
	 * @return list of residences
	 * @author Yaro Salo
	 */
	@JsonProperty("Residences") 
	public ArrayList<Residence> getResidences() {
		
//		ArrayList<Residence> copyRes = new ArrayList<>();
//		for(Residence r: myResidences) {
//			copyRes.add(new Residence(r.getName(), r.getType(), r.getProjectedBill(),
//					r.getBills(), r.getProjects()));	
//		}
//		return copyRes;
		return myResidences;
	}
	/**
	 * Sets the name of the user. 
	 * @param theName the name to set to.
	 * @author Yaro Salo
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * Sets the email of the user.
	 * @param theEmail the email to set to.
	 * @author Yaro Salo
	 */
	public void setEmail(String theEmail) {
		myEmail = theEmail;
	}
	
	/**
	 * Adds a residence to this user.
	 * @param theResidence the residence to be added.
	 * @author Donald Muffler
	 */
	public final void addResidence(final Residence theResidence) {
		myResidences.add(theResidence);
		setChanged();
		notifyObservers(resInfo());
	}
	
	/**
	 * Removes a project from this residence.
	 * @param theResidence the project to be removed.
	 * @author Donald Muffler
	 * @author Yaro Salo
	 */
	public final void removeResidence(final Residence theResidence) {
		if(myResidences.contains(theResidence)) {
			myResidences.remove(theResidence);
		}
		setChanged();
		notifyObservers(resInfo());
	}
	
	/**
	 * Removes a residence by name.
	 * @param theResidenceName the residence to be removed.
	 * @author Donald Muffler
	 */
	public final void removeResidence(final String theResidenceName) {
		int currentIndex = 0;
		boolean found = false;
		
		while(!found && currentIndex < myResidences.size()) {
			if (myResidences.get(currentIndex).getName().equals(theResidenceName)) {
				myResidences.remove(currentIndex);
				found = true;
			}
			currentIndex++;
		}
		setChanged();
		notifyObservers(resInfo());
	}
	
	public final void updateInfo() {
		setChanged();

        //For residence screen
		notifyObservers(resInfo());

        updateBillInfo();

        updateItemInfo();
	}

    private final void updateBillInfo() {
        setChanged();
        notifyObservers(billInfo());
    }

    private final void updateItemInfo() {
        setChanged();
        notifyObservers(itemInfo());
    }
	
    /**
     * {@inheritDoc}
     * 
     * Returns true if the specified object is equivalent to this User, and false 
     * otherwise. Two Users are equivalent if the have the same fields.
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
           
            final User otherUser = (User) theOther; //theOther can be safely casted. 
          
            //if all fields are equal the objects are equal
            returnValue = Objects.equals(myName, otherUser.myName)
                       && Objects.equals(myEmail, otherUser.myEmail)  
                       && Objects.equals(myResidences, otherUser.myResidences);
        }  
        
        return returnValue;
    }
    
    /**
     * {@inheritDoc} 
     * 
     * Returns and integer hash code for a User.
     * @return hash code as an integer.
     * @author Yaro Salo
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myEmail, myResidences);
    }

    /**
     * Gets readable info from all residences.
     * @return residence info
     */
	private final ArrayList<String> resInfo() {
		final ArrayList<String> list = new ArrayList<>();
		
		for (Residence currentRes: myResidences) {
			list.add(currentRes.getName());
			list.add(currentRes.getType().name());
			list.add(String.valueOf(currentRes.getProjects().size()));
		}
		list.add("String Check"); // for observer to check if list type is of type String.
		return list;
	}

    /**
     * Gets readable bill info.
     * @return bill info
     */
	private ArrayList<Double> billInfo() {
        ArrayList<Double> billList = new ArrayList<>();

        for (Residence currentRes: myResidences) {
            for (Bill currentBill: currentRes.getBills()) {
                billList.add((double) currentBill.getBeginMonth());
                billList.add((double) currentBill.getBeginYear());
                billList.add(currentBill.getAmount());
                billList.add(currentBill.getEValue());
            }
        }

        return billList;
    }

    /**
     * Gets readable item info.
     * @return item info.
     */
    private ArrayList<Item> itemInfo() {
        ArrayList<Item> items = new ArrayList<>();

        for (Residence currentRes: myResidences) {
            for (Project currentProject: currentRes.getProjects()) {
                items.addAll(currentProject.getItems());
            }
        }

        return items;
    }
}