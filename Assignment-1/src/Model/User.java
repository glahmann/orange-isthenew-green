package Model;
import java.util.Observable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Assignment-1: Simple GUI that takes user email and name. 
 */

/**
 * Represents a user that has a name and an email.
 * 
 * @author Yaro Salo
 * @version April 12, 2017
 */
public class User extends Observable {
	
	/** The name of the user. */
	private String myName;
	
	/** The email of the user. */
	private String myEmail;
	
	/**
	 * Initialize instance fields. 
	 * 
	 * @param theName the name of the user.
	 * @param theEmail the email of the user.
	 */
	@JsonCreator 
	public User(@JsonProperty("name")final String theName, @JsonProperty("email")final String theEmail) {
		myName = theName;
		myEmail = theEmail;
	}
	
	/**
	 * Gets the name of the user.
	 * @return the name of the user.
	 */
	public String getName() {
		return myName;
	}

	/**
	 * Gets the email of the user. 
	 * @return the email of the user.
	 */
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
}