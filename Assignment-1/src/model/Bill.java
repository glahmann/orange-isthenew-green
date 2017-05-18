package model;

import java.util.Date;

/**
 * @author Donald Muffler
 * @version 20170516
 */
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
	 */
	public Bill(final String theName, final double theAmount,
			final Date theBeginDate, final Date theEndDate) {
		myName = theName;
		myAmount = theAmount;
		myBeginDate = theBeginDate;
		myEndDate = theEndDate;
	}
	
	/**
	 * Getter for the name of the bill.
	 * @return the bill's name.
	 */
	public final String getName() {
		return myName;
	}

	/**
	 * Getter for the bill amount.
	 * @return the amount of the bill.
	 */
	public final double getAmount() {
		return myAmount;
	}
	
	/**
	 * Getter for the begin date of the bill.
	 * @return the begin date of the bill.
	 */
	public final Date getBeginDate() {
		return (Date) myBeginDate.clone();
	}
	
	/**
	 * Getter for the end date of the bill.
	 * @return the end date of the bill.
	 */
	public final Date getEndDate() {
		return (Date) myEndDate.clone();
	}
}