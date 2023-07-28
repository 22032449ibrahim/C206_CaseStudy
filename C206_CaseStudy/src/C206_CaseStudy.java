import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_ADD_PAYMENT = 14;
	private static final int OPTION_VIEW_PAYMENT = 15;
	private static final int OPTION_DELETE_PAYMENT = 16;
	public static void main(String[] args) {

		// view options
		int option = 0;
		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add user

			} else if (option == 2) {
				// View all user

			} else if (option == 3) {
				// Delete existing user

			} else if (option == 4) {
				// Add auction

			} else if (option == 5) {
				// View all auction

			} else if (option == 6) {
				// Delete existing auction

			} else if (option == 7) {
				// Add item

			} else if (option == 8) {
				// View all item

			} else if (option == 9) {
				// Delete existing item

			} else if (option == 10) {
				// Add bid

			} else if (option == 11) {
				// View all bids

			} else if (option == 12) {
				// Delete existing bid

			} else if (option == OPTION_ADD_PAYMENT) {
				// Add payment

			} else if (option == OPTION_VIEW_PAYMENT) {
				// View all payment

			} else if (option == OPTION_DELETE_PAYMENT) {
				// Delete payment

			} else if (option == 16) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}

		}
	}

	// menu
	public static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add a new User");
		System.out.println("3. View all Users");
		System.out.println("4. Delete an existing Item");
		System.out.println("5. Add a new Auction");
		System.out.println("6. View all Auction");
		System.out.println("7. Delete a existing Auction");
		System.out.println("8. Add a new Item");
		System.out.println("9. View all Items");
		System.out.println("10. Delete an existing Item");
		System.out.println("11. Add a new Bid");
		System.out.println("12. View all Bids");
		System.out.println("13. Delete an existing Bid");
		System.out.println("14. Add a new Payment");
		System.out.println("15. View all Payments");
		System.out.println("16. Delete an existing Payment");
		System.out.println("17. Quit");
		Helper.line(80, "-");

	}

	// set header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// exist
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================= Option 1 Viewing (CRUD- Read)=================================

	// retrieve and view all Users

	// retrieve and view all auction

	// retrieve and view all items

	// retrieve and view all bids

	// retrieve and view all payments
	public static String retrieveAllPayments(ArrayList<Payment> camcorderList) {
		String output = "";
		return output;
	}
	
	public static void viewAllPayments(ArrayList<Payment> camcorderList) {

	}
	// ================================= Option 2 Add an item (CRUD - Create)=================================

	// Input and Add Users

	// Input and Add auction

	// Input and Add items

	// Input and Add bids

	// Input and Add payments
	public static Payment inputPayment() {
		return null;
		
	}
	public static void addPayment(ArrayList<Payment> camcorderList, Payment cc) {

	}
	// ================================= Option 3 delete(CRUD - delete)=================================

	// exist and delete Users

	// exist and delete auction

	// exist and delete items

	// exist and delete bids

	// exist and delete payments
	public static boolean doReturnCamcorder(ArrayList<Payment> camcorderList,String tag) {
		boolean isReturned = false;
		return isReturned;
		
	}

	public static void returnCamcorder(ArrayList<Payment> camcorderList) {
		
	}
}
