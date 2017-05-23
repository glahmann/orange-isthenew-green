package model;

import java.util.Calendar;
import java.util.Date;

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
	private final Date myBeginDate;
	
	/**
	 * End date of the bill.
	 */
	private final Date myEndDate;

	/**
	 * Constructs the bill with an amount and the dates associated.
	 * @param theAmount amount of the bill.
	 * @param theBeginDate begin date of the bill.
	 * @param theEndDate end date of the bill.
	 * 
	 */
	@JsonCreator
	public Bill(@JsonProperty("Bill Name")final String theName, 
			@JsonProperty("Bill Ammount")final double theAmount,
			@JsonProperty("Start Date")final Date theBeginDate, 
			@JsonProperty("End Date")final Date theEndDate) {
		myName = theName;
		myAmount = theAmount;
		myBeginDate = theBeginDate;
		myEndDate = theEndDate;
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
	@JsonProperty("Start Date")
	public final Date getBeginDate() {
		return (Date) myBeginDate.clone();
	}
	
	/**
	 * Getter for the end date of the bill.
	 * @return the end date of the bill.
	 */
	@JsonProperty("End Date")
	public final Date getEndDate() {
		return (Date) myEndDate.clone();
	}
}