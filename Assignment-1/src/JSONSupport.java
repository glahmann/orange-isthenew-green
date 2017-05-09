import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonPropertyOrder({"name", "email"})
public class JSONSupport {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private JSONSupport() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * Given a user object and a file path writes the user object to that file.
     * If the file does not exist one is created.
     */
    public static final void writeJSON(User theUser, String thePath) {
    	final File file = new File(thePath);
    	try {
			// Convert object to JSON string and save into a file directly
			MAPPER.writeValue(file, theUser);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    /**
     * Given a path to JSON file returns a User object. 
     */
    public static final User readJSON(String thePath) {
		User user = null; //initialize variable so it can be returned.
    	try {
			final File file = new File(thePath);
			// Convert JSON string from file to Object
			user = MAPPER.readValue(file, User.class);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	return user; 		
    }

}
