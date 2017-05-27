/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Bill;
import model.Project;
import model.Residence;

/**
 * Test the Residence Class
 * @author Yaro Salo
 */
public class ResidenceTest {

	/** Name of the residence. */
	private static final String NAME = "Super Cool House";
	
	/** The projected bill. */
	private static final double PROBILL = 100.00;
	
	/** The list of bills for the residence. */
	private ArrayList<Bill> myBills;
	
	/** The list of projects for the residence. */
	private ArrayList<Project> myProjects;
	
	/** Instance of the residence to be tested. */
	private Residence myHouse;
	
	/** A project instance. */
	private Project myProject;
	
	/** A bill instance. */
	private Bill myBill;
	
	/**
	 * Set up method before each test.
	 * @author Yaro Salo
	 */
	@Before
	public void setUp() {
		myBill = new Bill("Bill", 50, 1, 2017, 2, 2017);
		myBills = new ArrayList<>();
		myProjects = new ArrayList<>();
		myBills.add(myBill);
		myProject = new Project("Project");
		myProjects.add(myProject);
		myHouse = new Residence(NAME, PROBILL,myBills, myProjects);
	}

	/**
	 * Test the default constructor. 
	 * @author Yaro Salo
	 */
	@Test
	public void testDefaultConstructor() {
		new Residence(NAME);
	}

	/**
	 * Test the copy constructor. 
	 * @author Yaro Salo
	 */
	@Test
	public void testCopyConstructor() {
		new Residence(NAME, PROBILL, myBills, myProjects);
	}

	/**
	 * Test getName() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testGetName() {
		assertTrue("getName() failed", myHouse.getName().equals(NAME));
	}

	/**
	 * Test the getProjectedBill() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testGetProjectedBill() {
		assertTrue("getProjectedBill() failed", myHouse.getProjectedBill() == PROBILL);
	}

	/**
	 * Test the geBills() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testGetBills() {
		final ArrayList<Bill> b = new ArrayList<>();
	
    	b.add(new Bill("Bill", 50, 1, 2017, 2, 2017));
    	assertTrue("getBills() doesn't return the expected result",
    			myHouse.getBills().equals(b));
	}

	/**
	 * Test that getBills() returns a copy. 
	 * @author Yaro Salo
	 */
	@Test
	public void testGetBillsDeepCopy() { 
		ArrayList<Bill> b = myHouse.getBills();
    	assertFalse("getItems() does not return a copy", myHouse.getBills() == b);
	}
	/**
	 * Test the getProjects() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testGetProjects() {
		final ArrayList<Project> p = new ArrayList<>();
		
    	p.add(new Project("Project"));
    	assertTrue("getProjcets() doesn't return the expected result",
    			myHouse.getProjects().equals(p));
	}

	/**
	 * Test that the getProjects() method returns a copy.
	 */
	@Test
	public void testGetProjectsDeepCopy() {
		ArrayList<Project> p = myHouse.getProjects();
    	assertFalse("getItems() does not return a copy", myHouse.getProjects() == p);	
	}
	/**
	 * Test the addProject() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testAddProject() {
		final Project project = new Project("Another Project");
		myHouse.addProject(project);
		assertTrue(myHouse.getProjects().contains(project));
	}

	/**
	 * Test the removeProjects() method with existing project.
	 * @author Yaro Salo
	 */
	@Test
	public void testRemoveProjectExists() {
		myHouse.removeProject(myProject);
		assertFalse("removeProject() failed", myHouse.getProjects().contains(myProject));
	}
	
	/**
	 * Test the removeProjcet() method with an non existing project.
	 */
	@Test
	public void testRemoveProjectNotExists() {
		final Project project = new Project("Another Project");
		final int sizeBefRemove = myHouse.getProjects().size();
		
		myHouse.removeProject(project);
		
		assertTrue("Ammount of projects should not change", 
				sizeBefRemove == myHouse.getProjects().size());
	}

	/**
	 * Test the addBill() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testAddBill() {
		final Bill bill = myBill = new Bill("Another Bill", 100, 1, 2017, 2, 2017);
		myHouse.addBill(bill);
		assertTrue(myHouse.getBills().contains(bill));
	}

	/**
	 * Test the removeBill() method with existing bill. 
	 * @author Yaro Salo
	 */
	@Test
	public void testRemoveBillExists() {
		myHouse.removeBill(myBill);
		assertFalse("removeBill() fails", myHouse.getBills().contains(myBill));
	}
	
	/**
	 * Test the removeBill() method with non existing bill. 
	 * @author Yaro Salo
	 */
	@Test 
	public void testRemoveBillNotExists() {
		final Bill bill = new Bill("Another Bill", 100, 1, 2017, 2, 2017);
		final int sizeBefRemove = myHouse.getBills().size();
		
		myHouse.removeBill(bill);
		
		assertTrue("Ammount of bills should not change", 
				sizeBefRemove == myHouse.getBills().size());
	}
	
	/**
	 * Test the hashCode() method.
	 * @author Yaro Salo
	 */
	@Test
	public void testHashCode() {
    	final ArrayList<Project> proList = new ArrayList<>();
      	final ArrayList<Bill> billList = new ArrayList<>();
    	final Project project = new Project("Project");
    	final Bill bill = new Bill("Bill", 50, 1, 2017, 2, 2017);
   
    	proList.add(project);
    	billList.add(bill);
    	final Residence otherHouse = new Residence(NAME, PROBILL, billList, proList);

    	
    	assertTrue(myHouse.hashCode() == otherHouse.hashCode());
	}
}
