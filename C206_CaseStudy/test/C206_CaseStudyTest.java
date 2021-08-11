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
	public void deleteCustomerTest() {
	
	}
	
	@Test
	public void doAddQuotationRequest() {
		
		//Test that the array list is not null so that new request can be added to it.
		assertNotNull("Check that there is a valid arrayList to add to: ", QuotationRequestList);
		
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		//Test that after adding a request, the size of the array list is 1.
		assertEquals("Check that the QuotationRequestList size is 1: ", 1, QuotationRequestList.size());
		//Test that after adding a request, the item added is same as the item added in the array list.
		assertSame("Check that the QuotationRequest qr1 is added: ", qr1, QuotationRequestList.get(0));
		
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr2);
		//Test that adding a second request, the size of the array list is 2.
		assertEquals("Check that the QuotationRequestList size is 2: ", 2, QuotationRequestList.size());
		//Test that after adding a request, the item added is same as the item added in the array list.
		assertSame("Check that the QuotationRequest qr2 is added: ", qr2, QuotationRequestList.get(1));
		
	}
	
	@Test
	public void doViewQuotationRequest() {
		
		//Test that the array list is not null but empty.
		assertNotNull("Check that there is a valid arrayList to retrieve from: ", QuotationRequestList);
		
		//Test if the list of quotation request retrieved is empty - boundary
		String allQuotation= C206_CaseStudy.retrieveAllQuotationRequest(QuotationRequestList);
		String testOutput = "";
		assertEquals("Test that the retrieved quotationlist is empty?", testOutput, allQuotation);
		
		//Test that after request have been added, the size of the output list is 2.
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr1);
		C206_CaseStudy.addQuotationRequest(QuotationRequestList, qr2);
		assertEquals("Check that the QuotationRequestList size is 2: ", 2, QuotationRequestList.size());
		
		//Test that after requests have been added, the expected output string matches the list of requests added.
		String allQuotationRequest= C206_CaseStudy.retrieveAllQuotationRequest(QuotationRequestList);
		testOutput += String.format("%-30s %-30s %-30s %-30s %-30s %-30d %-30d %-30s %-30s %-30s %-30d %c\n", "1", "98766789", "XN123@yeahoomail.com", 
				"HDB", "Kitchen", 0, 0, "70 sq m", "Modern", "11-12-2021", 10000, 'N');
		testOutput += String.format("%-30s %-30s %-30s %-30s %-30s %-30d %-30d %-30s %-30s %-30s %-30d %c\n", "2", "98766789", "XN123@yeahoomail.com", "HDB", "Toilet", 
				0, 2, "70 sq m", "Modern", "11-12-2021", 8000, 'N');
		assertEquals(testOutput, allQuotationRequest);
			
	}
	
	@Test
	public void doDeleteQuotationRequest() {
		//Test that the array list is not null but empty.
		assertNotNull("Check that there is a valid arrayList to delete the Quotation Request: ", QuotationRequestList);
		
		//Test that 
		
		
	}
	
	
	
	@After
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
	
	

}
