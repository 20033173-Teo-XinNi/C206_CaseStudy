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
	
	private ArrayList<Customer> customerList;
	private ArrayList<Quotation> quotationList;
	private ArrayList<QuotationRequest> QuotationRequestList; 
	
	
	
	
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
		assertEquals("Check that viewAllCustomerlist", testOutput, allCustomer);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCustomer(customerList, c1);
		C206_CaseStudy.addCustomer(customerList, c2);
		assertEquals("Test that Customer arraylist size is 2", 2, customerList.size());
				
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allCustomer= C206_CaseStudy.retrieveAllCustomer(customerList);
		testOutput = String.format("%-25s %-15s %-35s %-15s\n","Mary Tan", "Customer", "Marytan@abc123.com", "New");
		testOutput += String.format("%-25s %-15s %-35s %-15s\n","John Lim", "Customer", "Johnlim@def456.com", "New" );
		assertEquals("Test that viewAllCustomerlist", testOutput, allCustomer);
				
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
		
		}
	
	@Test
	public void DeleteCustomerTest() {
		// Test that Customer list is not null, so can delete
		assertNotNull("Check if there is valid customer arraylist to delete from", customerList);
						
		//Given adding two customers to the list
		C206_CaseStudy.addCustomer(customerList, c1);	
		C206_CaseStudy.addCustomer(customerList, c2);
		//After adding 2 customers, after deleting 1 customer, the size of the list is 1
		C206_CaseStudy.deleteCustomer(customerList, c1);
		assertEquals("Check that customer arraylist size is 1", 1, customerList.size());	
		// Test if customer list is not null but empty after deleting customer
		assertNotNull("Test that customer arraylist is not null but empty after deleting customer", customerList);
						
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
	

	@Test
	public void RetrieveAllQuotationTest() {
		//fail("Not yet implemented");
		// Test if quotation list is not null but empty - boundary
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item from", quotationList);
		
		//test if the list of quotations retrieved from C206_CaseStudy is empty - boundary
		String allQuotation= C206_CaseStudy.retrieveAllQuotations(quotationList);
		String testOutput = "";
		assertEquals("Test that the retrieved Chromebooklist is empty?", testOutput, allQuotation);
		
		//Given an empty list, after adding 2 Quotations, test if the size of the list is 2 - normal
		C206_CaseStudy.addQuotation(quotationList, q1);
		C206_CaseStudy.addQuotation(quotationList, q2);
		assertEquals("Test that quotationList is 2 after adding 2 item", 2, quotationList.size());
		
		
		//test if the expected output string same as the list of quotations retrieved from C206_CaseStudy
		allQuotation= C206_CaseStudy.retrieveAllQuotations(quotationList);
		testOutput = String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n","1", "1", "Kitchen", "Includes cabinet", "Bryan", "1/11/2021", "10");
		testOutput += String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n","2", "2", "Living Room", "Includes flooring", "John", "1/12/2021", "5");	
		assertEquals("Test that ViewAllChromebooklist", testOutput, allQuotation);
	}
	
	@Test
	public void addQuotationTest() {
		// Test that Quotation list is not null, so that can add a new quotation - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", quotationList);
		//Given an empty list, after adding 1 Quotation, the size of the list is 1 - normal
		//The Quotation just added is as same as the first Quotation of the list
		C206_CaseStudy.addQuotation(quotationList, q1);
		assertEquals("Check that Quotation arraylist size is 1", 1, quotationList.size());
		assertSame("Check that Quotation is added", q1, quotationList.get(0));
		
		//Add another Quotation. test The size of the list is 2? -normal
		//The Quotation just added is as same as the second Quotation of the list
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
	
	

	@After
	public void tearDown() throws Exception {
		
		c1 = null;
		c2 = null;
		customerList = null;
		q1 = null;
		q2 = null;
		quotationList = null;
	}
	
}
