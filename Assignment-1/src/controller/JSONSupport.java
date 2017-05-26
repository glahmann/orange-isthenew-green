package controller;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.User;

/**
 * Allows to write a JASON file from a User Object and reverse.
 * @author Yaro Salo
 * @version May 15, 2017
 */
final public class JSONSupport {
	
	/**
	 * Object Mapper.
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();
    
	/**
     * Private constructor, to prevent instantiation of this class.
     * @author Yaro Salo
     */
    private JSONSupport() {
        throw new IllegalStateException("Utility Class Instantiation.");
    }
    
    /**
     * Given a user object and a file writes the user object to that file.
     * @author Yaro Salo
     */
    public static final void writeJSON(User theUser, File theFile) {
    	
    	try {
			//enable indentation
    		MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    		//convert object to JSON string and save into a file directly
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
     * @author Yaro Salo
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