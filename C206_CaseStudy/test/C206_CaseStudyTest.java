import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Customer c1;
	private Customer c2;
	
	private ArrayList<Customer> customerList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		c1= new Customer("Mary Tan", "Customer", "Marytan@abc123.com", "NIL", "New");
		c2= new Customer("John Lim", "Customer", "Johnlim@def456.com", "NIL", "New");
		
		customerList = new ArrayList<Customer>();
	}

	
	
	@Test
	public void deleteCustomerTest() {
	
	}
	
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		customerList = null;
	}

}
