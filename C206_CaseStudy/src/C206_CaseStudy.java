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

		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("starry night", "by van gogh", 5999.99));
		itemList.add(new Item("the poppy field", "by claude monet", 4999.99));

		// view options
		int option = 0;
		C206_CaseStudy.menu();
		while (option != 16) {

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
				Item item = inputItem();
				C206_CaseStudy.addItem(itemList, item);
				System.out.println("Item added");

			} else if (option == 8) {
				// View all items
				C206_CaseStudy.viewAllItems(itemList);

			} else if (option == 9) {
				// Delete existing item
				C206_CaseStudy.deleteItem(itemList);

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
			if (option != 16 && Helper.readChar("\nMenu? (Y/N) >") == 'Y') {
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
		C206_CaseStudy.setHeader("16. Quit");
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
	public static String retrieveAllItems(ArrayList<Item> itemList) {
		String output = "";
		for (int i = 0; i < itemList.size(); i++) {
			output += String.format("%-80s\n", itemList.get(i).toString());
		}
		return output;
	}

	public static void viewAllItems(ArrayList<Item> itemList) {
		C206_CaseStudy.setHeader("ITEM LIST");
		String output = String.format("%-30s %-20s %-20s\n", "ITEM NAME", "DESCRIPTION", "START BID");
		output += retrieveAllItems(itemList);
		System.out.println(output);

	}

	// retrieve and view all bids

	// retrieve and view all payments
	public static String retrieveAllPayments(ArrayList<Payment> PaymentList) {
		String output = "";
		for (int i = 0; i < PaymentList.size(); i++) {
			output += String.format("%-80s\n", PaymentList.get(i).toString());
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

	// ================================= Option 2 Adding (CRUD -
	// Create)=================================

	// Input and Add Users

	// Input and Add auction

	// Input and Add items
	public static Item inputItem() {
		String itemName = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double startBid = Helper.readDouble("Enter start bid > ");

		Item item = new Item(itemName, description, startBid);
		return item;
	}

	public static void addItem(ArrayList<Item> itemList, Item item) {
		Item a;
		String actualItemName = item.getItemName();
		for (int i = 0; i < itemList.size(); i++) {
			a = itemList.get(i);
			String checkItemNumber = a.getItemName();
			if (checkItemNumber.equalsIgnoreCase(actualItemName))
				return;
		}
		String actualDes = item.getDescription();
		double actualStartBid = item.getStartBid();
		if ((actualItemName.isEmpty()) || (actualDes.isEmpty()) || (actualStartBid == 0.00)) {
			return;
		}
		itemList.add(item);
	}

	// Input and Add bids

	// Input and Add payments
	public static Payment inputPayment() {
		String cardNum = Helper.readString("Enter Card Number > ");
		String cardHolder = Helper.readString("Enter Card Holder > ");
		Double amt = Helper.readDouble("Enter amount > ");
		LocalDateTime paymentDateTime = LocalDateTime.now();

		Payment p = new Payment(cardNum, cardHolder, paymentDateTime, amt);
		return p;

	}

	public static void addPayment(ArrayList<Payment> PaymentList, Payment p) {
		Payment p1;
		String actualCardNumber = p.getCardNumber();
		for (int i = 0; i < PaymentList.size(); i++) {
			p1 = PaymentList.get(i);
			String checkCardNumber = p1.getCardNumber();
			if (checkCardNumber.equalsIgnoreCase(actualCardNumber))
				return;
		}
		String actualCardHolder = p.getCardHolder();
		LocalDateTime actualPaymentdate = p.getPaymentdate();
		double actualAmount = p.getAmount();
		if ((actualCardNumber.isEmpty()) || (actualCardHolder.isEmpty()) || (actualPaymentdate == null)
				|| (actualAmount == 0.00)) {
			return;
		}
		PaymentList.add(p);
	}

	// ================================= Option 3 delete(CRUD -
	// delete)=================================

	// exist and delete Users

	// exist and delete auction

	// exist and delete items
	public static boolean doDeleteItem(ArrayList<Item> itemList, Item item) {

		boolean isDeleted = false;
		double startBid = item.getStartBid();
		String itemName = item.getItemName();
		String description = item.getDescription();
		if (startBid == 0 || itemName.isEmpty() || description.isEmpty())
			return false;

		for (int i = 0; i < itemList.size(); i++) {
			String checkItemName = itemList.get(i).getItemName();
			if (checkItemName.equals(itemName)) {
				itemList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	public static void deleteItem(ArrayList<Item> itemList) {
		C206_CaseStudy.viewAllItems(itemList);
		String itemName = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		Double startBid = Helper.readDouble("Enter start bid > ");

		Item i = new Item(itemName, description, startBid);

		Boolean isDeleted = doDeleteItem(itemList, i);
		if (isDeleted == false) {
			System.out.println("Invalid item Details!");
		} else {
			System.out.println("Item Deleted");
		}
	}

	// exist and delete bids

	// exist and delete payments
	public static boolean doDeletePayment(ArrayList<Payment> PaymentList, Payment p) {

		boolean isDeleted = false;
		double amount = p.getAmount();
		String cardHolder = p.getCardHolder();
		String cardNumber = p.getCardNumber();
		LocalDateTime paymentdate = p.getPaymentdate();
		if (amount == 0 || cardHolder.isEmpty() || cardNumber.isEmpty() || paymentdate == null)
			return false;

		for (int i = 0; i < PaymentList.size(); i++) {
			String checkCardHolder = PaymentList.get(i).getCardHolder();
			if (checkCardHolder.equals(cardHolder)) {
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
		Double amt = Helper.readDouble("Enter amount > ");
		String stringDateTime = Helper.readString("Enter Payment Date & Time (dd/MM/yyyy HH:mm) > ");

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
