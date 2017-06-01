package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that calculates savings.
 * 
 * @author Donald Muffler
 * @author Garrett Lahmann
 * @version 20170531
 */
final public class Calc {
    
    /**
     * Average cost per kilowatt hour.
     */
    private static final double POWER_COST = 0.11;
    
    /**
     * Average power usage of Tacoma household (kWh/month).
     * TODO is this necessary?
     */
    private static final double AVG_USAGE = 992.0;

	/**
	 * Private constructor prevents instantiation.
	 */
	private Calc() {
		// prevents instantiation.
	}
	
	/**
	 * Calculates the savings of a project.
	 * @author Garrett Lahmann
	 * @param theListOfItems the list of items of the project.
	 * TODO add parameter replacedItems, an arraylist of same size as current param
	 * TODO make output percentage based? 
	 * TODO make function of time used
	 * TODO make function of product longevity
	 * @return the energy savings in Watts.
	 */
	public static final double calculate(ArrayList<Item> theListOfItems) {
	    double eValue, prev, savings = 0.0;
	    Iterator<Item> itr = theListOfItems.listIterator();
	    Item current;
	    String type;
	    while (itr.hasNext()) {
	        current = itr.next();
	        eValue = current.getEValue();
	        type = current.getType();
	        switch (type) { // TODO this is temporary
	            case "appliance":
	                prev = 1300.0; //power used in Watts
	                if (eValue < prev) {
                        savings += (prev - eValue);
                    }
	                break;
	            case "insulation":
	                // 12% energy savings according to energy star
	                break;
	            case "light": 
	                prev = 60.0;
	                if (eValue < prev) {
	                    savings += (prev - eValue);
	                }
	                break;
	            case "window":
                    // 
                    break;
	        }
	            
	    }
		return savings;
	}
}