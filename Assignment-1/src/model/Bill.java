package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Donald Muffler
 * @version 20170516
 */
@JsonPropertyOrder({"Bill Name", "Bill Ammount", "Start Month", 
	"Start Year", "End Month", "End Year"})
final public class Bill {
	
	/** Name of the bill. */
	final String myName;
	
	/** Amount of the bill. */
	private final double myAmount;
	
	/** Beginning month of the bill. */
	private final int myBeginMonth;

	/** Beginning year of the bill. */
	private final int myBeginYear;
	
	/** End month of the bill. */
	private final int myEndMonth;

	/** End year of the bill. */
	private final int myEndYear;

	/**
	 * Constructs the bill with an amount and the dates associated.
	 * @param theAmount amount of the bill.
	 * @param theBeginMonth begin date of the bill.
	 * @param theBeginYear begin date of the bill.
	 * @param theEndMonth end date of the bill.
	 * @param theEndYear end date of the bill.
	 */
	@JsonCreator
	public Bill(@JsonProperty("Bill Name")final String theName, 
			@JsonProperty("Bill Ammount")final double theAmount,
			@JsonProperty("Start Month")final int theBeginMonth,
			@JsonProperty("Start Year")final int theBeginYear,
			@JsonProperty("End Month")final int theEndMonth,
			@JsonProperty("End Year")final int theEndYear){
		myName = theName;
		myAmount = theAmount;
		myBeginMonth = theBeginMonth;
		myBeginYear = theBeginYear;
		myEndMonth = theEndMonth;
		myEndYear = theEndYear;
	}
	
	/**
	 * Getter for the name of the bill.
	 * @return the bill's name.
	 */
	@JsonProperty("Bill Name")
	public final String getName() {
		return myName;
	}

	/**
	 * Getter for the bill amount.
	 * @return the amount of the bill. 
	 */
	@JsonProperty("Bill Ammount")
	public final double getAmount() {
		return myAmount;
	}
	
	/**
	 * Getter for the begin date of the bill.
	 * @return the begin date of the bill.
	 */
	@JsonProperty("Start Month")
	public final int getBeginMonth() {
		return myBeginMonth;
	}

	/**
	 * Getter for the begin date of the bill.
	 * @return the begin date of the bill.
	 */
	@JsonProperty("Start Year")
	public final int getBeginYear() {
		return myBeginYear;
	}

	/**
	 * Getter for the end date of the bill.
	 * @return the end date of the bill.
	 */
	@JsonProperty("End Month")
	public final int getEndMonth() {
		return myEndMonth;
	}

	/**
	 * Getter for the end date of the bill.
	 * @return the end date of the bill.
	 */
	@JsonProperty("End Year")
	public final int getEndYear() {
		return myEndYear;
	}
	
    /**
     * {@inheritDoc}
     * 
     * Returns true if the specified object is equivalent to this Bill, and false 
     * otherwise. Two Bills are equivalent if the have the same fields.
     * 
     * @param theOther is the Object being tested.
     * @return true if objects are equal and false otherwise.
     * @author Yaro Salo
     */
    @Override
    public boolean equals(final Object theOther) {
        
        boolean returnValue = false;
        
        if (this == theOther) { //is the Object being tested this Object?
            returnValue = true;
        
        } else if (theOther != null && this.getClass() == theOther.getClass()) { //is theOther Object a User object? 
            
        
            final Bill otherBill = (Bill) theOther; //theOther can be safely casted. 
           
            //if all fields are equal the objects are equal
            returnValue = Objects.equals(myName, otherBill.myName)
                       && Objects.equals(myBeginMonth, otherBill.myBeginMonth)
                       && Objects.equals(myBeginYear, otherBill.myBeginYear)
                       && Objects.equals(myEndMonth, otherBill.myEndMonth)
                       && Objects.equals(myEndYear, otherBill.myEndYear);
        } 
        
        return returnValue;
    }
    
    /**
     * {@inheritDoc}
     * 
     * Returns and integer hash code for a Bill.
     * @return hash code as an integer.
     * @author Yaro Salo
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myBeginMonth, myBeginYear, myEndMonth, myEndYear);
    }
}