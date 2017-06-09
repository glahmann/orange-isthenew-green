package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that calculates savings.
 * 
 * @author Garrett Lahmann
 * @version 20170531
 */
final public class Calc {

    /**
     * Keeps doubles at 2 decimal places.
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(".##");
    
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
	            case "appliances":
                    prev = 1300.0; //power used in Watts
	                if (eValue < prev) {
                        savings += (prev - eValue) / 12;
                    }
	                break;
	            case "insulation":
	                // 12% energy savings according to energy star
                    prev = 7.0;
                    if (eValue < prev) {
                        savings += (prev - eValue) / 12;
                    }

	                break;
	            case "lighting":
	                prev = 15.0;
	                if (eValue < prev) {
	                    savings += (prev - eValue) / 12;
	                }
	                break;
	            case "windows":
                    prev = 4.0;
					if (eValue < prev) {
                        savings += (prev - eValue) / 12;
                    }
                    break;
	        }
	            
	    }
		return Double.parseDouble(DECIMAL_FORMAT.format(savings));
	}
}