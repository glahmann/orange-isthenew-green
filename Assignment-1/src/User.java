/**
 * 
 */

/**
 * @author donal
 *
 */
public class User {
	private String myName;
	private String myEmail;
	public User(final String theName, final String theEmail) {
		myName = theName;
		myEmail = theEmail;
	}
	
	public String getName() {
		return myName;
	}
	public String getEmail() {
		return myEmail;
	}
	public void setName(String theName) {
		myName = theName;
	}
	
	public void setEmail(String theEmail) {
		myEmail = theEmail;
	}
	
	
	
}
