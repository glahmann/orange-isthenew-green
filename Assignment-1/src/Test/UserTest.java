package Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.User;

/**
 * Unit Tests for User class
 *
 * @author Zira Cook
 * @version 14 April 2017
 */
public class UserTest {

    /** Constant for initialized user name. */
    private static final String NAME = "Billy Bob";

    /** Constant for intialized user email. */
    private static final String EMAIL = "billyiscool@aol.com";

    /** User object for tests. */
    private User myUser;

    @Before
    public void setUp() {
        myUser = new User(NAME, EMAIL);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Get name failed", NAME, myUser.getName());

    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("Get email failed", EMAIL, myUser.getEmail());
    }

    @Test
    public void testSetName() throws Exception {
        final String difName = "Jimmy John";
        myUser.setName(difName);
        assertEquals("Set name failed", difName, myUser.getName());
    }

    @Test
    public void testSetEmail() throws Exception {
        final String difEmail = "billyisrad@aol.com";
        myUser.setEmail(difEmail);
        assertEquals("Set name failed", difEmail, myUser.getEmail());
    }
}