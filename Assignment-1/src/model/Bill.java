package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Donald Muffler
 * @version 20170516
 */
@JsonPropertyOrder({"Bill Name", "Bill Ammount", "Start Date", "End Date"})
final public class Bill {
	
	/**
	 * Name of the bill.
	 */
	final String myName;
	
	/**
	 * Amount of the bill.
	 */
	private final double myAmount;
	
	/**
	 * Begin date of the bill.
	 */
	private final int myBeginMonth;

	private final int myBeginYear;
	
	/**
	 * End date of the bill.
	 */
	private final int myEndMonth;

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
}