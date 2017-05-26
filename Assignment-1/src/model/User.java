
 package model;
import java.util.ArrayList;
import java.util.Observable;

import com.fasterxml.jackson.annotation.JsonCreator;
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
final public class User extends Observable {
	
	/** The name of the user. */
	private String myName;
	
	/** The email of the user. */
	private String myEmail;
	
	/** List of residences. */
	@JsonProperty("Residences")private final ArrayList<Residence> myResidences;
	
	/**
	 * Initialize instance fields. 
	 * 
	 * @param theName the name of the user.
	 * @param theEmail the email of the user.
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
	 * 
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
	 */
	@JsonProperty("User Name")
	public String getName() {
		return myName;
	}

	/**
	 * Gets the email of the user. 
	 * @return the email of the user.
	 */
	@JsonProperty("User Email")
	public String getEmail() {
		return myEmail;
	}

	/**
	 * Sets the name of the user. 
	 * @param theName the name to set to.
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * Sets the email of the user.
	 * @param theEmail the email to set to.
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
	}
	
	/**
	 * Removes a project from this residence.
	 * @param theProject the project to be removed.
	 * @author Donald Muffler
	 */
	public final void removeResidence(final Residence theResidence) {
		int currentIndex = 0;
		boolean found = false;
		
		while(!found && currentIndex < myResidences.size()) {
			if (myResidences.get(currentIndex).getName().equals(theResidence.getName())) {
				myResidences.remove(currentIndex);
				found = true;
			}
			currentIndex++;
		}
	}
}