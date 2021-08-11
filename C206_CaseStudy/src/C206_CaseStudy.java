import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3; // Refactor Extract constants

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<QuotationRequest> QuotationRequestList = new ArrayList<QuotationRequest>();
		
		quotationList.add(new Quotation("Q01", "1", "Kitchen", "Includes cabinet", "Bryan", "1/11/2021", "10"));
		quotationList.add(new Quotation("Q02", "2", "Living Room", "Includes flooring", "John", "1/12/2021", "5"));
		
		customerList.add(new Customer("Mary Tan", "Customer", "Marytan@abc123.com", "NIL", "New"));
		customerList.add(new Customer("John Lim", "Customer", "Johnlim@def456.com", "NIL", "New"));
		
		QuotationRequestList.add(new QuotationRequest("1", "98766789", "XN123@yeahoomail.com", "HDB", "Kitchen",
				0, 0, "70 sq m", "Modern", "11-12-2021", 10000, 'N'));
		QuotationRequestList.add(new QuotationRequest("2", "98766789", "XN123@yeahoomail.com", "HDB", "Toilet", 
				0, 2, "70 sq m", "Modern", "11-12-2021", 8000, 'N'));
		
		
		int option = 0;

		while (option != OPTION_QUIT) {
			homePageMenu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				int option2 = 0;
				while (option2 != 4) {
					customerMenu();
					option2 = Helper.readInt("Enter option > ");
					if (option2 == 1) {
						manageRegistration();
						option2 = Helper.readInt("Enter option > ");
						if (option2 == 1) {
							// method for visitor account registration
							Customer c = inputCustomer();
							C206_CaseStudy.addCustomer(customerList, c);
						}
					} else if (option2 == 2) {
						// method for request for quotation
						manageQuotationRequest();
						option2 = Helper.readInt("Enter option > ");
						if (option2 == 1) {
							// method for view all quotation request
							
						} else if (option2 == 2) {
							// method for add a quotation request
							QuotationRequest qr = inputQuotationRequest();
							addQuotationRequest(QuotationRequestList, qr);
						} else if (option2 == 3) {
							// method for delete a quotation request
							
						} else if (option2 == 4) {
							
						} else {
							System.out.println("Invalid option");
						}
					} else if (option2 == 3) {
						// method for manage appointment
					} else {
						System.out.println("Invalid option!");
					}
				}

			} else if (option == 2) {
				int option1 = 0;

				Helper.line(80, "-");
				while (option1 != 6) {
					adminMenu();
					option1 = Helper.readInt("Enter option > ");
					if (option1 == 1) {
						// method for manage customer
						manageCustomer();
						option1 = Helper.readInt("Enter option > ");
						if (option1 == 1) {
							// method for view all customers
							C206_CaseStudy.viewAllCustomer(customerList);
						} else if (option1 == 2) {
							// method for add a customer
							Customer c = inputCustomer();
							C206_CaseStudy.addCustomer(customerList, c);
						} else if (option1 == 3) {
							// method for delete a customer
//							Customer c = inputCustomer();
							C206_CaseStudy.deleteCustomer(customerList);
						} else if (option1 == 4) {
							
						} else {
							System.out.println("Invalid option");
						}
					} else if (option1 == 2) {
						// method for manage package
					} else if (option1 == 3) {
						// method for manage request for quotation
					} else if (option1 == 4) {
						// method for manage quotation
						int option3 = 0;
						while (option3 != 4) {
							manageQuotation();
							option3 = Helper.readInt("Enter option > ");
							if (option3 == 1) {
								// method for view all quotations
								viewAllQuotations(quotationList);
							} else if (option3 == 2) {
								// method for add a quotation
								Quotation q = inputQuotation(quotationList);
								addQuotation(quotationList,q);
							} else if (option3 == 3) {
								// method for delete a quotation
								deleteQuotation(quotationList);
							} else if (option3 == 4) {

							} else {
								System.out.println("Invalid option!");
							}
						}
					} else if (option1 == 5) {
						// method for manage appointment
					} else if (option1 == 6) {

					} else {
						System.out.println("Invalid option!");
					}
				}

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option!");
			}
		}
	}

	// =================================UI interface for home page=================================
	public static void homePageMenu() {
		C206_CaseStudy.setHeader("SELECT HOME PAGE");
		System.out.println("1. Home Page for Customers");
		System.out.println("2. Home Page for Admin/Designers");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void customerMenu() {
		C206_CaseStudy.setHeader("CUSTOMER HOME PAGE");
		System.out.println("1. Visitor account Registration");
		System.out.println("2. Request for Quotation");
		System.out.println("3. Manage Appointment");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}

	public static void adminMenu() {
		C206_CaseStudy.setHeader("ADMIN/DESIGNER HOME PAGE");
		System.out.println("1. Manage Customer");
		System.out.println("2. Manage Package");
		System.out.println("3. Manage Request for Quotation");
		System.out.println("4. Manage Quotation");
		System.out.println("5. Manage Appointment");
		System.out.println("6. Back");
		Helper.line(80, "-");
	}
	
	public static void manageCustomer() {
		C206_CaseStudy.setHeader("MANAGE CUSTOMER");
		System.out.println("1. View All Users");
		System.out.println("2. Add a New User");
		System.out.println("3. Delete a User");
		System.out.println("4. Back");
	}
	
	public static void manageRegistration() {
		C206_CaseStudy.setHeader("NEW CUSTOMER REGISTRATION");
		System.out.println("1. Register as New User");
		System.out.println("2. Back");
	}

	public static void manageQuotation() {
		C206_CaseStudy.setHeader("MANAGE QUOTATION");
		System.out.println("1. View All Quotations");
		System.out.println("2. Add a Quotation");
		System.out.println("3. Delete a Quotation");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}
	
	public static void manageQuotationRequest() {
		C206_CaseStudy.setHeader("MANAGE QUOTATION REQUEST");
		System.out.println("1. View All Quotation Requests");
		System.out.println("2. Add a Quotation Requests");
		System.out.println("3. Delete a Quotation Requests");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}
	
	// =================================Manage Quotation Request Methods=========================
	public static QuotationRequest inputQuotationRequest() {
		String requestName = Helper.readString("Enter Request Name > ");
		String contactNumber = Helper.readString("Enter Contact Number > ");
		String email = Helper.readString("Enter Email > ");
		String propertyType = Helper.readString("Enter Property Type > ");
		String renovationType = Helper.readString("Enter Renovation Type > ");
		int rooms = Helper.readInt("Number of Rooms to Renovate > ");
		int toilets = Helper.readInt("Number of toilets to Renovate > ");
		String areaSize = Helper.readString("Enter Area Size > ");
		String renovationStyle = Helper.readString("Enter Renovation Style > ");
		String targetCompletionDate = Helper.readString("Enter Target Completion Date > ");
		int budget = Helper.readInt("Enter Budget > ");
		char requestUrgency = Helper.readChar("Enter Request Urgency (Y/N) > ");
		
		QuotationRequest qr = new QuotationRequest(requestName, contactNumber, email, propertyType, renovationType
				,rooms, toilets, areaSize, renovationStyle, targetCompletionDate, budget, requestUrgency);
		
		return qr;
	}
	public static void addQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList, QuotationRequest qr1) {
		
		
		int size = QuotationRequestList.size();
		boolean duplicate = false;
		String requestName = qr1.getRequestName();
		for (int i = 0; i < size; i++) {
			String requestNameDuplicate = QuotationRequestList.get(i).getRequestName();
			
			if(requestNameDuplicate.equalsIgnoreCase(requestName)) {
				duplicate = true;
				break;
			}else {
				duplicate = false;
			}
		}
		
		if(duplicate == true) {
			System.out.println("Error! Duplicate Quotaion Requests!");
		} else {
			QuotationRequestList.add(qr1);
			System.out.println("Quotation Request added");
		}
		
		
	}
	
	// =================================Manage Customer Methods==================================
	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
		String output = "";
		for (int i = 0; i < customerList.size(); i++) {

			output += String.format("%-25s %-15s %-35s %-15s\n", 
									customerList.get(i).getName(),
									customerList.get(i).getRole(), 
									customerList.get(i).getEmail(),
									customerList.get(i).getStatus());
			
		}
		return output;
	}
	
	public static void viewAllCustomer(ArrayList<Customer> customerList) {
		Helper.line(80, "-");
		String output = String.format("%-25s %-15s %-35s %-15s\n", 
								"NAME", "ROLE", "EMAIL", "STATUS");
		output += retrieveAllCustomer(customerList);
		System.out.println(output);
	}
	
	
	public static Customer inputCustomer() {
		String name = Helper.readString("Enter full name: ");
		String role = Helper.readString("Enter role: ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter password: ");
		String status = Helper.readString("Enter status: ");

		Customer c = new Customer(name, role, email, password, status);
		return c;
		
	}
	
	public static void addCustomer(ArrayList<Customer> customerList, Customer c1) {
		int size = customerList.size();
		boolean duplicate = false;
		String name = c1.getName();
		for (int i = 0; i < size; i++) {
			String duplicateName = customerList.get(i).getName();
			if(duplicateName.equalsIgnoreCase(name)) {
				duplicate = true;
				break;
			} else {
				duplicate = false;
			}
		}
		if (duplicate == true) {
			System.out.println("Error! Duplicate Name!");
		} else {
				customerList.add(c1);
				System.out.println("Customer added");
			
			}
		}



	public static void deleteCustomer(ArrayList<Customer> customerList) {
		String name = Helper.readString("Enter name: ");
		for (int i = 0; i < customerList.size(); i++) {
			if (name.equalsIgnoreCase(customerList.get(i).getName())) {
				customerList.remove(i).getName();
				
				System.out.println("User " + name + " deleted Successfully!");
				break;
			} else {
				System.out.println("Invalid Name entered!");
			}
		}
	}
	
	// =================================Manage Quotation Methods=================================
	

	public static String retrieveAllQuotations(ArrayList<Quotation> quotationList) {
		String output = "";
		int size = quotationList.size();
		for (int i = 0; i < size; i++) {
			String quotationID = quotationList.get(i).getQuotationID();
			String requestID = quotationList.get(i).getRequestID();
			String renoCategory = quotationList.get(i).getRenoCategory();
			String description = quotationList.get(i).getDescription();
			String designerName = quotationList.get(i).getDesignerName();
			String date = quotationList.get(i).getDate();
			String amount = quotationList.get(i).getAmount();
			output += String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n", quotationID,
					requestID, renoCategory,
					description, designerName,
					date, amount);
		}
		return output;
	}
	
	public static void viewAllQuotations(ArrayList<Quotation> quotationList) {
		C206_CaseStudy.setHeader("QUOTATIONS LIST");
		String output = String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n", "QUOTATION_ID", "REQUEST_ID",
				"RENOVATION Category", "DESCRIPTION", "DESIGNER NAME", "EARLIST START DATE", "TOTAL QUOTATION AMOUNT");

		output += retrieveAllQuotations(quotationList);
		System.out.println(output);
	
	}
	
	public static Quotation inputQuotation(ArrayList<Quotation> quotationList) {
		String quotationID = Helper.readString("Enter Quotation ID: ");
		String requestID = Helper.readString("Enter Request ID: ");
		String renoCategory = Helper.readString("Enter Renovation Category: ");
		String description = Helper.readString("Enter Description: ");
		String name = Helper.readString("Enter Designer name: ");
		String date = Helper.readString("Enter Earliest Start Date: ");
		String amount = Helper.readString("Enter Total Quotation Amount: ");
		Quotation q = new Quotation(quotationID, requestID,renoCategory, description, name, date, amount);
		return q;
			}
		
	

	public static void addQuotation(ArrayList<Quotation> quotationList, Quotation q) {
		boolean duplicate = false;
		int size = quotationList.size();
		for (int i = 0; i < size; i++) {
			String quotationID = q.getQuotationID();
			String quotationID2 = quotationList.get(i).getQuotationID();
			if(quotationID2.equalsIgnoreCase(quotationID)) {
				duplicate = true;
				break;
			}else {
				duplicate = false;
			}
		}
		
		if (duplicate == true) {
			System.out.println("Error! Duplicate Quotation ID!");
		}else {
			System.out.println("Quotation added sucessfully");
			quotationList.add(q);
		}
	}


	public static void deleteQuotation(ArrayList<Quotation> quotationList) {
		String quotationID = Helper.readString("Enter Quotation ID: ");
		int size = quotationList.size();
		for (int i = 0; i < size; i++) {
			String quotationID2 = quotationList.get(i).getQuotationID();
			if (quotationID.equalsIgnoreCase(quotationID2)) {
				quotationList.remove(i).getRequestID();
			
				System.out.println("Quotation with ID: " + quotationID + " deleted successfully!");
				break;
			} else {
				System.out.println("Invalid Quotation ID!");
			}
		}
		

		
		
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	

}
