import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {

	private static final int OPTION_ADD_PAYMENT = 13;
	private static final int OPTION_VIEW_PAYMENT = 14;
	private static final int OPTION_DELETE_PAYMENT = 15;

	public static void main(String[] args) {

		ArrayList<Payment> PaymentList = new ArrayList<Payment>();
		PaymentList
				.add(new Payment("1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20));
		PaymentList
				.add(new Payment("1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45));

		// view options
		int option = 0;
		C206_CaseStudy.menu();
		while (option != 5) {

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
				Payment p = inputPayment();
				C206_CaseStudy.addPayment(PaymentList, p);
				System.out.println("Payment added");

			} else if (option == OPTION_VIEW_PAYMENT) {
				// View all payment
				C206_CaseStudy.viewAllPayments(PaymentList);

			} else if (option == OPTION_DELETE_PAYMENT) {
				// Delete payment
				C206_CaseStudy.deletePayment(PaymentList);

			} else if (option == 16) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");

			}
			if (Helper.readChar("\nMenu? (Y/N) >") == 'Y') {
				C206_CaseStudy.menu();
			}

		}
	}

	// menu
	public static void menu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		C206_CaseStudy.setHeader("USER");
		System.out.println("1. Add a new User");
		System.out.println("2. View all Users");
		System.out.println("3. Delete an existing Item");
		C206_CaseStudy.setHeader("AUCTION");
		System.out.println("4. Add a new Auction");
		System.out.println("5. View all Auction");
		System.out.println("6. Delete a existing Auction");
		C206_CaseStudy.setHeader("ITEM");
		System.out.println("7. Add a new Item");
		System.out.println("8. View all Items");
		System.out.println("9. Delete an existing Item");
		C206_CaseStudy.setHeader("BID");
		System.out.println("10. Add a new Bid");
		System.out.println("11. View all Bids");
		System.out.println("12. Delete an existing Bid");
		C206_CaseStudy.setHeader("PAYMENT");
		System.out.println("13. Add a new Payment");
		System.out.println("14. View all Payments");
		System.out.println("15. Delete an existing Payment");
		Helper.line(80, "-");
		System.out.println("16. Quit");
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

	// ================================= Option 1 Viewing
	// (CRUD-Read)=================================

	// retrieve and view all Users

	// retrieve and view all auction

	// retrieve and view all items

	// retrieve and view all bids

	// retrieve and view all payments
	public static String retrieveAllPayments(ArrayList<Payment> PaymentList) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		String output = "";
		for (int i = 0; i < PaymentList.size(); i++) {
			output += String.format("%-30s %-20s %-20s %-10.2f\n", PaymentList.get(i).getCardNumber(),
					PaymentList.get(i).getCardHolder(), PaymentList.get(i).getPaymentdate().format(f),
					PaymentList.get(i).getAmount());
		}
		return output;
	}

	public static void viewAllPayments(ArrayList<Payment> PaymentList) {
		C206_CaseStudy.setHeader("PAYMENT LIST");
		String output = String.format("%-30s %-20s %-20s %-10s\n", "CARD NUMBER", "CARD HOLDER", "PAYMENT DATETIME",
				"AMOUNT");
		output += retrieveAllPayments(PaymentList);
		System.out.println(output);
	}

	// ================================= Option 2 Add an item (CRUD -
	// Create)=================================

	// Input and Add Users

	// Input and Add auction

	// Input and Add items

	// Input and Add bids

	// Input and Add payments
	public static Payment inputPayment() {
		String cardNum = Helper.readString("Enter Card Number > ");
		String cardHolder = Helper.readString("Enter Card Holder > ");
		LocalDateTime paymentDateTime = LocalDateTime.now();
		Double amt = Helper.readDouble("Enter amount > ");

		Payment p = new Payment(cardNum, cardHolder, paymentDateTime, amt);
		return p;

	}

	public static void addPayment(ArrayList<Payment> PaymentList, Payment p) {
		Payment p1;
		for (int i = 0; i < PaymentList.size(); i++) {
			p1 = PaymentList.get(i);
			if (p1.getCardNumber().equalsIgnoreCase(p.getCardNumber()))
				return;
		}
		if ((p.getCardNumber().isEmpty()) || (p.getCardHolder().isEmpty()) || (p.getPaymentdate() == null)
				|| (p.getAmount() == 0.00)) {
			return;
		}
		PaymentList.add(p);
	}

	// ================================= Option 3 delete(CRUD -
	// delete)=================================

	// exist and delete Users

	// exist and delete auction

	// exist and delete items

	// exist and delete bids

	// exist and delete payments
	public static boolean doDeletePayment(ArrayList<Payment> PaymentList, Payment p) {

		boolean isDeleted = false;
		if (p.getAmount() == 0 || p.getCardHolder().isEmpty() || p.getCardNumber().isEmpty()
				|| p.getPaymentdate() == null)
			return false;

		for (int i = 0; i < PaymentList.size(); i++) {
			if (PaymentList.get(i).getCardHolder().equals(p.getCardHolder())) {
				PaymentList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;

	}

	public static void deletePayment(ArrayList<Payment> PaymentList) {
	    C206_CaseStudy.viewAllPayments(PaymentList);
	    String cardNum = Helper.readString("Enter Card Number > ");
	    String cardHolder = Helper.readString("Enter Card Holder > ");
	    String stringDateTime = Helper.readString("Enter Payment Date & Time (dd/MM/yyyy HH:mm) > ");
	    Double amt = Helper.readDouble("Enter amount > ");

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    LocalDateTime PaymentDateTime = LocalDateTime.parse(stringDateTime, formatter);
	    Payment p = new Payment(cardNum, cardHolder, PaymentDateTime, amt);

	    Boolean isDeleted = doDeletePayment(PaymentList, p);
	    if (isDeleted == false) {
	        System.out.println("Invalid Payment Details!");
	    } else {
	        System.out.println("Payment Deleted");
	    }
	}

}
