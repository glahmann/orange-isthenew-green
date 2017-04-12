/**
 * 
 */

/**
 * @author donal
 *
 */
public class User {
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
	public User(final String theName, final String theEmail) {
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
