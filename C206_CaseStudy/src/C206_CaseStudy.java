import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3; // Refactor Extract constants

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();

		int option = 0;

		while (option != OPTION_QUIT) {
			homePageMenu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				customerMenu();
				// relevant code for customer menu

			} else if (option == 2) {
				adminMenu();
				// relevant code for admin/designer menu

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option!");
			}
		}
	}

	public static void homePageMenu() {
		C206_CaseStudy.setHeader("SELECT HOME PAGE");
		System.out.println("1. Home Page for Customers");
		System.out.println("2. Home Page for Admin/Designers");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void customerMenu() {
		int option = 0;
		while (option != 4) {
			C206_CaseStudy.setHeader("CUSTOMER HOME PAGE");
			System.out.println("1. Visitor account Registration");
			System.out.println("2. Request for Quotation");
			System.out.println("3. Manage Appointment");
			System.out.println("4. Back");
			Helper.line(80, "-");
			option = Helper.readInt("Enter option > ");
			if (option == 1) {
				// method for visitor account registration
			} else if (option == 2) {
				// method for request for quotation
			} else if (option == 3) {
				// method for manage appointment
			} else {
				System.out.println("Invalid option!");
			}
		}

	}

	public static void adminMenu() {
		int option = 0;
		while (option != 6) {
			C206_CaseStudy.setHeader("ADMIN/DESIGNER HOME PAGE");
			System.out.println("1. Manage Customer");
			System.out.println("2. Manage Package");
			System.out.println("3. Manage Request for Quotation");
			System.out.println("4. Manage Quotation");
			System.out.println("5. Manage Appointment");
			System.out.println("6. Back");
			Helper.line(80, "-");
			option = Helper.readInt("Enter option > ");
			if (option == 1) {
				// method for manage customer
			} else if (option == 2) {
				// method for manage package
			} else if (option == 3) {
				// method for manage request for quotation
			} else if (option == 4) {
				manageQuotation();
				// method for manage quotation
			} else if (option == 5) {
				// method for manage appointment
			} else if (option == 6) {
				
			}
			else {
				System.out.println("Invalid option!");
			}
		}

	}

	public static void manageQuotation() {
		int option = 0;
		while (option != 4) {
			C206_CaseStudy.setHeader("MANAGE QUOTATION");
			System.out.println("1. View All Quotations");
			System.out.println("2. Add a Quotation");
			System.out.println("3. Delete a Quotation");
			System.out.println("4. Back");
			Helper.line(80, "-");
			option = Helper.readInt("Enter option > ");
			if (option == 1) {
				// method for view all quotations
				viewAllQuotations();
			} else if (option == 2) {
				// method for add a quotation
				addQuotation();
			} else if (option == 3) {
				// method for delete a quotation
				deleteQuotation();
			} else if (option == 4) {
				
			}
			else {
				System.out.println("Invalid option!");
			}
		}
	}

	public static void viewAllQuotations() {
       
	}

	public static void addQuotation() {

	}

	public static void deleteQuotation() {

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}
