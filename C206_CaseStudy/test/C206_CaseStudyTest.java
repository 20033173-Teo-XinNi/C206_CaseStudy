import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Customer c1;
	private Customer c2;
	
	private Quotation q1;
	private Quotation q2;
	
	private QuotationRequest qr1;
	private QuotationRequest qr2;
	
	private Package p1;
	private Package p2;
	
	private ArrayList<Customer> customerList;
	private ArrayList<Quotation> quotationList;
	private ArrayList<QuotationRequest> QuotationRequestList; 
	private ArrayList<Package> packageList;

	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		//Customer test data
		c1= new Customer("Mary Tan", "Customer", "Marytan@abc123.com", "NIL", "New");
		c2= new Customer("John Lim", "Customer", "Johnlim@def456.com", "NIL", "New");
		customerList = new ArrayList<Customer>();
		
		//Quotation Request test data
		qr1 = new QuotationRequest("1", "98766789", "XN123@yeahoomail.com", "HDB", "Kitchen",
				0, 0, "70 sq m", "Modern", "11-12-2021", 10000, 'N');
		qr2 = new QuotationRequest("2", "98766789", "XN123@yeahoomail.com", "HDB", "Toilet", 
				0, 2, "70 sq m", "Modern", "11-12-2021", 8000, 'N' );
		QuotationRequestList = new ArrayList<QuotationRequest>();

		q1 = new Quotation("1", "1", "Kitchen", "Includes cabinet", "Bryan", "1/11/2021", "10");
		q2 = new Quotation("2", "2", "Living Room", "Includes flooring", "John", "1/12/2021", "5");
		
		quotationList = new ArrayList<Quotation>();

	}

	@Test
	public void RetrieveAllCustomerTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Customer arraylist to retrieve customers", customerList);
				
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allCustomer= C206_CaseStudy.retrieveAllCustomer(customerList);
		String testOutput = "";
		assertEquals("Check that viewAllCustomerList", testOutput, allCustomer);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCustomer(customerList, c1);
		C206_CaseStudy.addCustomer(customerList, c2);
		assertEquals("Test that Customer arraylist size is 2", 2, customerList.size());
				
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allCustomer= C206_CaseStudy.retrieveAllCustomer(customerList);
		testOutput = String.format("%-15s %-15s %-35s %-10s %-15s\n","Mary Tan", "Customer", "Marytan@abc123.com", "-", "New");
		testOutput += String.format("%-15s %-15s %-35s %-10s %-15s\n","John Lim", "Customer", "Johnlim@def456.com", "-", "New");
		assertEquals("Test that viewAllCustomerList", testOutput, allCustomer);
				
	}
	

	@Test
	public void AddCustomerTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Customer arraylist to add to", customerList);
				
		//Given an empty list, after adding 1 item, the size of the list is 
		C206_CaseStudy.addCustomer(customerList, c1);		
		assertEquals("Test if that Customer arraylist size is 1?", 1, customerList.size());
				
		//The item just added is as same as the first item of the list
		assertSame("Test that Customer is added same as 1st item of the list?", c1, customerList.get(0));
				
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addCustomer(customerList, c2);
		assertEquals("Test that Customer arraylist size is 2?", 2, customerList.size());

		
		//Package test data
		p1 = new Package("P01", "Fragile", "1/5/2021", "1/6/2021", 5);
		p2 = new Package("P02", "Solid", "1/7/2021", "1/8/2021", 10);
		
		packageList = new ArrayList<Package>();
	}

		
	@Test
	public void DeleteCustomerTest() {
		// Test that Customer list is not null, so can delete
		assertNotNull("Check if there is valid customer arraylist to delete from", customerList);
						
		//Given adding two customers to the list
		C206_CaseStudy.addCustomer(customerList, c1);	
		C206_CaseStudy.addCustomer(customerList, c2);
//		//After adding 2 customers, after deleting 1 customer, the size of the list is 1
		C206_CaseStudy.deleteCustomer(customerList, customerList.get(0).getName());
		assertEquals("Check that customer arraylist size is 1", 1, customerList.size());	
		// Test if customer list is not null but empty after deleting customer
		assertNotNull("Test that customer arraylist is not null but empty after deleting customer", customerList );
	}				

	
	@Test
	public void doAddQuotationRequest() {
		
		
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		//Test that after adding a request, the size of the array list is 1.
		assertEquals("Check that the QuotationRequestList size is 1: ", 1, QuotationRequestList.size());
		//Test that after adding a request, the item added is same as the item added in the array list.
		assertSame("Check that the QuotationRequest qr1 is added: ", qr1, QuotationRequestList.get(0));
		
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr2);
		//Test that adding a second request, the size of the array list is 2.
		assertEquals("Check that the QuotationRequestList size is 2: ", 2, QuotationRequestList.size());
		//Test that after adding a request, the item added is same as the item added in the array list.
		assertSame("Check that the QuotationRequest qr1 is added: ", qr2, QuotationRequestList.get(1));
		

		//Test that the array list is not null so that new request can be added to it.
		assertNotNull("Check that there is a valid arrayList to add to: ", QuotationRequestList);

	}
	

	public void doDeleteQuotationRequest() {
		
		//Test that the array list is not null but empty.
		assertNotNull("Check that there is a valid arrayList to delete from: ", QuotationRequestList);

		//Given after adding two items
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr2);
		//Test that when a request deleted, the size of the Quotation Request List is 0.
		C206_CaseStudy.deleteQuotationRequest(QuotationRequestList, qr1.getRequestName());
		assertEquals("Check that the QuotationRequestList size is 1: ", 1, QuotationRequestList.size());
		
		//Test that the Quotation Request List is empty but not null after removing all the requests
		C206_CaseStudy.deleteQuotationRequest(QuotationRequestList, qr2.getRequestName());
		assertTrue("Check that QuotationRequestList is empty after deleting all requests: ", QuotationRequestList.isEmpty());
		assertEquals("Check that the QuotationRequestList size is 0: ", 0, QuotationRequestList.size());
		
		//Test that when the request name entered is found in array list.
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		boolean isDeleted = C206_CaseStudy.deleteQuotationRequest(QuotationRequestList, "1") ;
		assertTrue("Check that when request name is deleted - true ", isDeleted);	
		
		//Test when the request name entered is not found in Quotation Request List.
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		isDeleted = C206_CaseStudy.deleteQuotationRequest(QuotationRequestList, "7") ;
		assertFalse("Check that when request name is deleted - false ", isDeleted);

		
	}
	
	public void RetrieveAllQuotationTest() {
		//fail("Not yet implemented");
		// Test if quotation list is not null but empty - boundary
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item from", quotationList);
		
		//test if the list of quotation retrieved from C206_CaseStudy is empty - boundary
		String allQuotation= C206_CaseStudy.retrieveAllQuotations(quotationList);
		String testOutput = "";
		assertEquals("Test that the retrieved Chromebooklist is empty?", testOutput, allQuotation);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addQuotation(quotationList, q1);
		C206_CaseStudy.addQuotation(quotationList, q2);
		assertEquals("Test that quotationList is 2 after adding 2 item", 2, quotationList.size());
		
		
		//test if the expected output string same as the list of quotations retrieved from C206_CaseStudy
		allQuotation= C206_CaseStudy.retrieveAllQuotations(quotationList);
		testOutput = String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n","1", "1", "Kitchen", "Includes cabinet", "Bryan", "1/11/2021", "10");
		testOutput += String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n","2", "2", "Living Room", "Includes flooring", "John", "1/12/2021", "5");	
		assertEquals("Test that ViewAllChromebooklist", testOutput, allQuotation);
	}
	
	
	public void addQuotation() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", quotationList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addQuotation(quotationList, q1);
		assertEquals("Check that Quotation arraylist size is 1", 1, quotationList.size());
		assertSame("Check that Quotation is added", q1, quotationList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addQuotation(quotationList, q2);
		assertEquals("Check that Quotation arraylist size is 2", 2, quotationList.size());
		assertSame("Check that Quotation is added", q2, quotationList.get(1));

	}
	
	@Test
	public void deleteQuotationTest() {
		// Test that Quotation list is not null, so that can delete - boundary
		assertNotNull("Check if there is valid Quotation arraylist to delete from", quotationList);
				
		//Adding two Quotations to list
		C206_CaseStudy.addQuotation(quotationList, q1);	
		C206_CaseStudy.addQuotation(quotationList, q2);
		//Given a list with two Quotation, after deleting 1 Quotation, the size of the list is 1
		C206_CaseStudy.deleteQuotation(quotationList, quotationList.get(0).getQuotationID());
		assertEquals("Check that Quotation arraylist size is 1", 1, quotationList.size());
		
		// Test if quotation list is not null but empty after deleting quotation - boundary
		assertNotNull("Test that Quotation arraylist is not null but empty after deleting quotation", quotationList);
				
				
	}
	
	@Test
	public void addPackageTest() {
			assertNotNull(packageList);
			C206_CaseStudy.addPackage(packageList, p1);
			assertEquals(1, packageList.size());
			assertSame(p1, packageList.size());
			
			C206_CaseStudy.addPackage(packageList, p2);
			assertEquals(2, packageList.size());
			assertEquals(p2, packageList.size());
	}
	
	@Test 
	public void retrieveAllPackageTest() {
		assertNotNull(packageList);
		
		String allPackage = C206_CaseStudy.retrieveAllPackage(packageList);
		String outputTest = "";
		assertEquals(outputTest, allPackage);
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals(2, packageList.size());
		
		allPackage = C206_CaseStudy.retrieveAllPackage(packageList);
		outputTest = String.format("%-10s %-30s %-10s %-10s %-10d\n", "P01", "Fragile", "1/5/2021", "1/6/2021", 5);
		outputTest = String.format("%-10s %-30s %-10s %-10s %-10d\n", "P02", "Solid", "1/7/2021", "1/8/2021", 10);
		
		assertEquals(outputTest, allPackage);
	}
	@Test
	public void deletePackageTest() {
		assertNotNull(packageList);
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		
		C206_CaseStudy.deletePackage(packageList, p1);
		assertEquals(1, packageList.size());
		
		C206_CaseStudy.deletePackage(packageList, p2);
		assertEquals(0, packageList.size());
		
		boolean test = (packageList.remove(p1));
		assertFalse(test);
	}
	
	

	
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		customerList = null;
		
		q1 = null;
		q2 = null;
		quotationList = null;
		
		qr1 = null;
		qr2 = null;
		QuotationRequestList = null;
	}

	

}
