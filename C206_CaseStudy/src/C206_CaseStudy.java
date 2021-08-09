import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3; // Refactor Extract constants

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();

		Quotation a = new Quotation("hi", "hi", "hi", "hi", "hi", "hi", "hi");
		Quotation b = new Quotation("hi1", "hi1", "hi1", "hi1", "hi1", "hi1", "hi1");
		Quotation c = new Quotation("hi2", "hi2", "hi2", "hi2", "hi2", "hi2", "hi2");
		quotationList.add(a);
		quotationList.add(b);
		quotationList.add(c);

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
						// method for visitor account registration
					} else if (option2 == 2) {
						// method for request for quotation
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
								addQuotation(quotationList);
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

	public static void manageQuotation() {
		C206_CaseStudy.setHeader("MANAGE QUOTATION");
		System.out.println("1. View All Quotations");
		System.out.println("2. Add a Quotation");
		System.out.println("3. Delete a Quotation");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}

	// =================================Manage Quotation Methods=================================
	public static void viewAllQuotations(ArrayList<Quotation> quotationList) {
		Helper.line(80, "-");
		String output = String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n", "REQUEST_ID", "QUOTATION_ID",
				"RENOVATION Category", "DESCRIPTION", "DESIGNER NAME", "EARLIST START DATE", "TOTAL QUOTATION AMOUNT");

		for (int i = 0; i < quotationList.size(); i++) {
			output += String.format("%-15s %-15s %-25s %-30s %-15s %-25s %-15s\n", quotationList.get(i).getRequestID(),
					quotationList.get(i).getQuotationID(), quotationList.get(i).getRenoCategory(),
					quotationList.get(i).getDescription(), quotationList.get(i).getDesignerName(),
					quotationList.get(i).getDate(), quotationList.get(i).getAmount());
		}
		System.out.println(output);
	}

	public static void addQuotation(ArrayList<Quotation> quotationList) {
		String requestID = Helper.readString("Enter Request ID: ");
		String quotationID = Helper.readString("Enter Quotation ID: ");
		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationID.equalsIgnoreCase(quotationList.get(i).getQuotationID())) {
				
				System.out.println("Error! Duplicate Quotation ID!");
				break;
			} else {
				String renoCategory = Helper.readString("Enter Renovation Category: ");
				String description = Helper.readString("Enter Description: ");
				String name = Helper.readString("Enter Designer name: ");
				String date = Helper.readString("Enter Earliest Start Date: ");
				String amount = Helper.readString("Enter Total Quotation Amount: ");
				Quotation q = new Quotation(requestID, quotationID, renoCategory, description, name, date, amount);
				quotationList.add(q);
				System.out.println("Quotation added sucessfully!");
			}

		}

	}

	public static void deleteQuotation(ArrayList<Quotation> quotationList) {
		String quotationID = Helper.readString("Enter Quotation ID: ");
		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationID.equalsIgnoreCase(quotationList.get(i).getQuotationID())) {
				quotationList.remove(i).getRequestID();
				quotationList.remove(i).getQuotationID();
				quotationList.remove(i).getRenoCategory();
				quotationList.remove(i).getDescription();
				quotationList.remove(i).getDesignerName();
				quotationList.remove(i).getDate();
				quotationList.remove(i).getAmount();
				System.out.println("Quotation with ID: " + quotationID + " deleted successfully!");
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
