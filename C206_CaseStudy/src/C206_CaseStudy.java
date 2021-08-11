import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3; // Refactor Extract constants

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<QuotationRequest> QuotationRequestList = new ArrayList<QuotationRequest>();
		ArrayList<Package> packageList = new ArrayList<Package>();
		
		quotationList.add(new Quotation("Q01", "1", "Kitchen", "Includes cabinet", "Bryan", "1/11/2021", "10"));
		quotationList.add(new Quotation("Q02", "2", "Living Room", "Includes flooring", "John", "1/12/2021", "5"));

		customerList.add(new Customer("Mary Tan", "Customer", "Marytan@abc123.com", "-", "New"));
		customerList.add(new Customer("John Lim", "Customer", "Johnlim@def456.com", "-", "New"));

		packageList.add(new Package("P01", "Fragile", "1/5/2021", "1/6/2021", 5));
		
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
							Customer c = inputCustomer(customerList);
							addCustomer(customerList, c);
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
							

							doDeleteQuotationRequest(QuotationRequestList);
						} else if (option2 == 4) {
							System.out.println("Thank You!");

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
							viewAllCustomer(customerList);
						} else if (option1 == 2) {
							// method for add a customer
							Customer c = inputCustomer(customerList);
							addCustomer(customerList, c);
						} else if (option1 == 3) {
							// method for delete a customer
							String deleteInput = inputDeleteCustomer(customerList);
							deleteCustomer(customerList, deleteInput);
						} else if (option1 == 4) {

						} else {
							System.out.println("Invalid option");
						}
					} else if (option1 == 2) {
						// method for manage package
						C206_CaseStudy.managePackage(packageList);
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
								addQuotation(quotationList, q);
							} else if (option3 == 3) {
								// method for delete a quotation

								String deleteInput = inputDeleteQuotation(quotationList);
								deleteQuotation(quotationList, deleteInput);

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

	// =================================UI interface for home
	// page=================================
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

	// =================================Manage Package Methods==================================
	public static void managePackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("MANAGE PACKAGE");
		System.out.println("1. Add New Package");
		System.out.println("2. View All Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Back");
		Helper.line(80, "-");
		
		int option = Helper.readInt("Enter an option > ");
		
		if (option == 1) {
			Package p1 = inputPackage();
			C206_CaseStudy.addPackage(packageList, p1);
		
		} else if (option == 2) {
			C206_CaseStudy.viewAllPackage(packageList);
		
		} else if (option == 3) {
			Package p1 = C206_CaseStudy.inputDeletePackage(null);
			C206_CaseStudy.deletePackage(packageList, p1);
			
		} else if (option > 4 || option < 0) {
			System.out.println("Invalid Option");
			C206_CaseStudy.adminMenu();
		}
	}
			
	public static Package inputDeletePackage(ArrayList<Package> packageList) {
		Package p1 = null;
		if (packageList.size() != 0) {
			String pID = Helper.readString("Enter Package ID > ");
			for (Package p : packageList) {
				if (p.getpCode().equals(pID)) {
					p1 = p;
					break;
				}
			}
		} else {
			System.out.println("There are no package");
		}
		return p1;	
	}
	
	public static void addPackage(ArrayList<Package> packageList, Package p1) {
		
		if (p1 != null && packageList.add(p1)) {
			System.out.println("Package added successfully");
		}
	}
	
	public static Package inputPackage() {
		Package p1 = null;
		
		String pID = Helper.readString("Enter Package ID > ");
		boolean pIDCheck = validInput("Package ID", pID);
		
		if (pIDCheck != true) {
			pID = Helper.readString("Enter Package ID > ");
			pIDCheck = validInput("Package ID", pID);
		}
		
		String pDesc = Helper.readString("Enter Package Description > ");
		boolean pDescCheck = validInput("Package Type", pDesc);
		
		if (pDescCheck != true) {
			pDesc = Helper.readString("Enter Package Description > ");
			pDescCheck = validInput("Package Type", pDesc);
		}
		
		String pStartDate = Helper.readString("Enter Start Date > ");
		boolean pStartDateCheck = validInput("Date", pStartDate);
		
		if (pStartDateCheck != true) {
			pStartDate = Helper.readString("Enter Start Date > ");
			pStartDateCheck = validInput("Date", pStartDate);
		}
		
		String pEndDate = Helper.readString("Enter End Date > ");
		boolean pEndDateCheck = validInput("Date", pEndDate);
		
		if (pEndDateCheck != true) {
			pEndDate = Helper.readString("Enter End Date > ");
			pEndDateCheck = validInput("Date", pEndDate);
		}
		
		int pAmount = Helper.readInt("Enter Package Amount > ");
		boolean pAmountCheck = validInput("Package Amount", String.valueOf(pAmount));
		
		if (pAmountCheck != true) {
			pAmount = Helper.readInt("Enter Package Amount > ");
			pAmountCheck = validInput("Package Amount", String.valueOf(pAmount));
		}
		
		p1 = new Package(pID, pDesc, pStartDate, pEndDate, pAmount);
		
		return p1;
	}

	private static boolean validInput(String string, String pDesc) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-10s\n", "PACKAGE ID", "PACKAGE DESCRIPTION",
						"START DATE", "END DATE", "QUANTITY");
		output += retrieveAllPackage(packageList);
		System.out.println(output);
	}
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		// TODO Auto-generated method stub
		String output = "";
		
		for (Package p : packageList) {
				output += String.format("%s", p.doStringPackage());
		}
		return output;
	}

	public static void deletePackage(ArrayList<Package> packageList, Package p1){
		
		if (p1 != null && packageList.remove(p1)) {
				System.out.println("Package successfully deleted");
		} else {
				System.out.println("Invalid package for deletion");
		}
	}
	

	// =================================Manage Quotation Request
	// Methods=========================

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

		QuotationRequest qr = new QuotationRequest(requestName, contactNumber, email, propertyType, renovationType,
				rooms, toilets, areaSize, renovationStyle, targetCompletionDate, budget, requestUrgency);

		return qr;
	}

	public static void addQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList, QuotationRequest qr1) {

		int size = QuotationRequestList.size();
		boolean duplicate = false;
		String requestName = qr1.getRequestName();
		for (int i = 0; i < size; i++) {
			String requestNameDuplicate = QuotationRequestList.get(i).getRequestName();

			if (requestNameDuplicate.equalsIgnoreCase(requestName)) {
				duplicate = true;
				break;
			} else {
				duplicate = false;
			}
		}

		if (duplicate == true) {
			System.out.println("Error! Duplicate Quotation Requests!");
		} else {
			QuotationRequestList.add(qr1);
			System.out.println("Quotation Request added");
		}

	}

	// =================================Manage Quotation Request Methods==================================


	public static String viewAllQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList) {

		Helper.line(80, "-");
		String output = String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %s\n",
				"REQUEST NAME", "CONTACT NUMBER", "EMAIL", "PROPERTY TYPE", "RENOVATION TYPE", "ROOMS TO RENOVATE",
				"TOILETS TO RENOVATE", "AREA SIZE", "RENOVATION STYLE", "TARGET COMPLETION DATE", "BUDGET",
				"REQUEST URGENCY");

		output += retrieveAllQuotationRequest(QuotationRequestList);
		System.out.println(output);
		return output;
	}

	public static String retrieveAllQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList) {

		String output = "";

		for (int i = 0; i < QuotationRequestList.size(); i++) {
			QuotationRequest e = QuotationRequestList.get(i);
			output += String.format("%-30s %-30s %-30s %-30s %-30s %-30d %-30d %-30s %-30s %-30s %-30d %c\n",
					e.getRequestName(), e.getContactNumber(), e.getEmail(), e.getPropertyType(), e.getRenovationType(),
					e.getRooms(), e.getToilets(), e.getAreaSize(), e.getRenovationStyle(), e.getTargetCompletionDate(),
					e.getBudget(), e.getRequestUrgency());
		}

		return output;

	}

	public static boolean deleteQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList, String requestName) {

		boolean verify = true;
		for (int i = 0; i < QuotationRequestList.size(); i++) {
			String requestNameVerify = QuotationRequestList.get(i).getRequestName();
			if (requestName.equalsIgnoreCase(requestNameVerify)) {
				verify = true;
				QuotationRequestList.remove(i);

			} else {
				verify = false;
			}

		}

		return verify;

	}

	public static void doDeleteQuotationRequest(ArrayList<QuotationRequest> QuotationRequestList) {
		String requestName = Helper.readString("Enter Request Name > ");
		boolean deleteStatus = deleteQuotationRequest(QuotationRequestList, requestName);

		if (deleteStatus == true) {
			System.out.println("Request Name: " + requestName + " deleted");
		} else {
			System.out.println("Invalid Request Name");
		}

	}

	// =================================Manage Customer Methods==================================
	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
		String output = "";
		int size = customerList.size();
		for (int i = 0; i < size; i++) {
			String name = customerList.get(i).getName();
			String role = customerList.get(i).getRole();
			String email = customerList.get(i).getEmail();
			String password = customerList.get(i).getPassword();
			String status = customerList.get(i).getStatus();
			
			output += String.format("%-15s %-15s %-35s %-10s %-15s\n", name,
					role, email, password, status);
		}
		return output;
	}
	
	public static void viewAllCustomer(ArrayList<Customer> customerList) {
		C206_CaseStudy.setHeader("CUSTOMERS LIST");
		String output = String.format("%-15s %-15s %-35s %-10s %-15s\n", "NAME", "ROLE",
				"EMAIL", "PASSWORD", "STATUS");

		output += retrieveAllCustomer(customerList);
		System.out.println(output);
	
	}
	
	public static Customer inputCustomer(ArrayList<Customer> customerList) {
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role: ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter password: ");
		String status = Helper.readString("Enter status: ");
		
		Customer c = new Customer(name, role, email, password, status);
		return c;
		}

	public static void addCustomer(ArrayList<Customer> customerList, Customer c) {
		boolean duplicate = false;
		int size = customerList.size();
		for (int i = 0; i < size; i++) {
			String name = c.getName();
			String name2 = customerList.get(i).getName();
			if(name2.equalsIgnoreCase(name)) {
				duplicate = true;
				break;
			}else {
				duplicate = false;
			}
		}
		
		if (duplicate == true) {
			System.out.println("Error! Duplicate Name!");
		}else {
			System.out.println("Customer added sucessfully!");
			customerList.add(c);
		}
	}
	
	public static String inputDeleteCustomer(ArrayList<Customer> customerList) {
		String deleteCustomerName = Helper.readString("Enter name: ");
		return deleteCustomerName;
			}

	public static void deleteCustomer(ArrayList<Customer> customerList, String deleteCustomerName) {
		int size = customerList.size();
		for (int i = 0; i < size; i++) {
			String name2 = customerList.get(i).getName();
			if (deleteCustomerName.equalsIgnoreCase(name2)) {
				customerList.remove(i).getName();
			
				System.out.println("Customer " + deleteCustomerName + " deleted successfully!");
				break;
			} else {
				System.out.println("Invalid Customer name!");
				break;
			}
		}
		
	}
	// =================================Manage Quotation
	// Methods=================================

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
				System.out.println("Quotation added sucessfully!");
				quotationList.add(q);
			}
		}
		
		public static String inputDeleteQuotation(ArrayList<Quotation> quotationList) {
			String deleteQuotationID = Helper.readString("Enter Quotation ID: ");
			return deleteQuotationID;
				}

		public static void deleteQuotation(ArrayList<Quotation> quotationList, String deleteQuotationID) {
			int size = quotationList.size();
			for (int i = 0; i < size; i++) {
				String quotationID2 = quotationList.get(i).getQuotationID();
				if (deleteQuotationID.equalsIgnoreCase(quotationID2)) {
					quotationList.remove(i).getRequestID();
				
					System.out.println("Quotation with ID: " + deleteQuotationID + " deleted successfully!");
					break;
				} else {
					System.out.println("Invalid Quotation ID!");
					break;
				}
			}
			
		}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


		
		

}