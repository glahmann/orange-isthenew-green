package Model;

import java.sql.Date;

/**
 * @author Donald Muffler
 * @version 20170516
 */
public class Bill {
	
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
	public Bill(final double theAmount, final Date theBeginDate, final Date theEndDate) {
		myAmount = theAmount;
		myBeginDate = theBeginDate;
		myEndDate = theEndDate;
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