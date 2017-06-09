package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Donald Muffler
 * @author Yaro Salo (Json, hash, equals)
 * @version 20170516
 */
@JsonPropertyOrder({"Bill Ammount", "Start Month", 
	"Start Year", "End Month", "End Year", "EValue"})
final public class Bill {
	
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
	
	/** The total kWh used. **/
	private final double myEValue;

	/**
	 * Constructs the bill with an amount and the dates associated.
	 * @param theAmount amount of the bill.
	 * @param theBeginMonth begin date of the bill.
	 * @param theBeginYear begin date of the bill.
	 * @param theEndMonth end date of the bill.
	 * @param theEndYear end date of the bill.
	 * @param theEValue the evalue per kWh.
	 */
	@JsonCreator
	public Bill(@JsonProperty("Bill Ammount")final double theAmount,
			@JsonProperty("Start Month")final int theBeginMonth,
			@JsonProperty("Start Year")final int theBeginYear,
			@JsonProperty("End Month")final int theEndMonth,
			@JsonProperty("End Year")final int theEndYear,
			@JsonProperty("EValue")final double theEValue){
		myAmount = theAmount;
		myBeginMonth = theBeginMonth;
		myBeginYear = theBeginYear;
		myEndMonth = theEndMonth;
		myEndYear = theEndYear;
		myEValue = theEValue;
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
	 * Getter for the eValue of the bill.
	 * @return the eValue of the bill.
	 */
	@JsonProperty("EValue")
	public final double getEValue() {
		return myEValue;
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
            returnValue = Objects.equals(myBeginMonth, otherBill.myBeginMonth)
                       && Objects.equals(myBeginYear, otherBill.myBeginYear)
                       && Objects.equals(myEndMonth, otherBill.myEndMonth)
                       && Objects.equals(myEndYear, otherBill.myEndYear)
                       && Objects.equals(myEValue, otherBill.myEValue);
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
        
        return Objects.hash(myBeginMonth, myBeginYear, myEndMonth, myEndYear, myEValue);
    }
}