/**
 * 
 */

/**
 *
 */
public class User {
	/** The name of the user. */
	private String myName;
	private String myEmail;
	
	/**
	 * 
	 * @param theName
	 * @param theEmail
	 */
	public User(final String theName, final String theEmail) {
		myName = theName;
		myEmail = theEmail;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return myEmail;
	}
	
	/**
	 * 
	 * @param theName
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * 
	 * @param theEmail
	 */
	public void setEmail(String theEmail) {
		myEmail = theEmail;
	}
}
