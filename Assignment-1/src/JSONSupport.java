import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Allows to write a JASON file from a User Object and reverse.
 * @author Yaro Salo
 * @version May 15, 2017
 *
 */
@JsonPropertyOrder({"name", "email"})
public class JSONSupport {
	
	/**
	 * Object Mapper.
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private JSONSupport() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * Given a user object and a file writes the user object to that file.
     */
    public static final void writeJSON(User theUser, File theFile) {
    	try {
			// Convert object to JSON string and save into a file directly
			MAPPER.writeValue(theFile, theUser);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    /**
     * Converts a JSON file into a user object. 
     */
    public static final User readJSON(File theFile) {
		User user = null; //initialize variable so it can be returned.
    	try {
			// Convert JSON string from file to Object
			user = MAPPER.readValue(theFile, User.class);
			
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
