/**
 * 
 */
package test;

import static org.junit.Assert.*;

import model.Bill;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the bill class.
 * 
 * @author Garrett Lahmann
 * @version 30 May 2017
 */
public class BillTest {
    /** Amount of the bill. */
    private static final double AMOUNT = 300.00;

    /** Beginning month of the bill. */
    private static final int BEGIN_MONTH = 2;

    /** Beginning year of the bill. */
    private static final int BEGIN_YEAR = 2017;

    /** End month of the bill. */
    private static final int END_MONTH = 4;

    /** End year of the bill. */
    private static final int END_YEAR = 2017;

    /** The total kWh used. **/
    private static final double EVALUE = 12.5;

    private Bill myBill;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myBill = new Bill(AMOUNT, BEGIN_MONTH, BEGIN_YEAR, END_MONTH, END_YEAR, EVALUE);
    }

    @Test
    public void tesConstructor() {
        assertNotNull(new Bill(AMOUNT, BEGIN_MONTH, BEGIN_YEAR, END_MONTH, END_YEAR, EVALUE));
    }

    @Test
    public void testGetAmount() {
        assertEquals(AMOUNT, myBill.getAmount(), 0.05);
    }

    @Test
    public void testGetBeginMonth() {
        assertEquals(BEGIN_MONTH, myBill.getBeginMonth());
    }

    @Test
    public void testGetBeginYear() {
        assertEquals(BEGIN_YEAR, myBill.getBeginYear());
    }

    @Test
    public void testGetEndMonth() {
        assertEquals(END_MONTH, myBill.getEndMonth());
    }

    @Test
    public void testGetEndYear() {
        assertEquals(END_YEAR, myBill.getEndYear());
    }

    @Test
    public void testGetEValue() {
        assertEquals(EVALUE, myBill.getEValue(), 0.05);
    }

    @Test
    public void testHashCode() {
        Bill testBill = new Bill(AMOUNT, BEGIN_MONTH, BEGIN_YEAR, END_MONTH, END_YEAR, EVALUE);
        assertEquals("Hashcodes not equal", myBill.hashCode(), testBill.hashCode());
    }

}
