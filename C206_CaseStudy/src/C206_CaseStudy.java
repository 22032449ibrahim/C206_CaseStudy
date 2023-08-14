import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {

	private static final int OPTION_DELETE_USER = 3;
	private static final int OPTION_ADD_USER = 1;
	private static final int OPTION_VIEW_USER = 2;
	private static final int OPTION_ADD_ITEM = 7;
	private static final int OPTION_VIEW_ITEM = 8;
	private static final int OPTION_DELETE_ITEM = 9;
	private static final int OPTION_ADD_PAYMENT = 13;
	private static final int OPTION_VIEW_PAYMENT = 14;
	private static final int OPTION_DELETE_PAYMENT = 15;
	private static final int OPTION_ADD_BID = 10;
	private static final int OPTION_VIEW_BID = 11;
	private static final int OPTION_DELETE_BID = 12;

	public static void main(String[] args) {

		ArrayList<Payment> PaymentList = new ArrayList<Payment>();
		PaymentList
				.add(new Payment("1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20));
		PaymentList
				.add(new Payment("1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45));

		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("starry night", "by van gogh", 5999.99));
		itemList.add(new Item("poppy field", "by claude monet", 4999.99));

		ArrayList<Bid> BidList = new ArrayList<Bid>();
		BidList.add(new Bid(1, 2542624.66, LocalDateTime.of(2021, 12, 12, 10, 30)));
		BidList.add(new Bid(2, 2542674.36, LocalDateTime.of(2022, 4, 5, 10, 30)));

		ArrayList<User> UserList = new ArrayList<User>();
		UserList.add(new User("Sung Hanbin", "SHB01", "0613SHB"));
		UserList.add(new User("Mark Lee", "MKL02", "0207MKLEE"));

		// view options
		int option = 0;
		C206_CaseStudy.menu();
		while (option != 16) {

			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ADD_USER) {
				// Add user
				User u = inputUser();
				C206_CaseStudy.addUser(UserList, u);
				System.out.println("User added");

			} else if (option == OPTION_VIEW_USER) {
				// View all user
				C206_CaseStudy.viewAllUsers(UserList);

			} else if (option == OPTION_DELETE_USER) {
				// Delete existing user
				C206_CaseStudy.DeleteUser(UserList);

			} else if (option == 4) {
				// Add auction

			} else if (option == 5) {
				// View all auction

			} else if (option == 6) {
				// Delete existing auction

			} else if (option == OPTION_ADD_ITEM) {
				// Add item
				Item item = inputItem();
				C206_CaseStudy.addItem(itemList, item);
				System.out.println("Item added");

			} else if (option == OPTION_VIEW_ITEM) {
				// View all items
				C206_CaseStudy.viewAllItems(itemList);

			} else if (option == OPTION_DELETE_ITEM) {
				// Delete existing item
				C206_CaseStudy.deleteItem(itemList);

			} else if (option == OPTION_ADD_BID) {
				// Add bid
				Bid b = inputBid();
				C206_CaseStudy.addBid(BidList, b);
				System.out.println("Bid added");

			} else if (option == OPTION_VIEW_BID) {
				// View all bids
				C206_CaseStudy.viewAllBids(BidList);
			} else if (option == OPTION_DELETE_BID) {
				// Delete existing bid
				C206_CaseStudy.DeleteBid(BidList);
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
		System.out.println("3. Delete an existing User");
		C206_CaseStudy.setHeader("AUCTION");
		System.out.println("4. Add a new Auction");
		System.out.println("5. View all Auction");
		System.out.println("6. Delete a existing Auction");
		C206_CaseStudy.setHeader("ITEM");
		System.out.println("7. Add a new Item");
		System.out.println("8. View all Items");
		System.out.println("9. Delete an existing Item");
		C206_CaseStudy.setHeader("BID");
		bidoptions();
		C206_CaseStudy.setHeader("PAYMENT");
		System.out.println("13. Add a new Payment");
		System.out.println("14. View all Payments");
		System.out.println("15. Delete an existing Payment");
		C206_CaseStudy.setHeader("16. Quit");
	}

	public static void bidoptions() {
		System.out.println("10. Add a new Bid");
		System.out.println("11. View all Bids");
		System.out.println("12. Delete an existing Bid");
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
	public static String retrieveAllUsers(ArrayList<User> UserList) {
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %15s\n", UserList.get(i).getName(), UserList.get(i).getUserID());
		}
		return output;

	}

	public static void viewAllUsers(ArrayList<User> UserList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %15s\n", "NAME", "USERID");
		output += retrieveAllUsers(UserList);
		System.out.println(output);
	}

	// retrieve and view all auction

	// retrieve and view all items
	public static String retrieveAllItems(ArrayList<Item> itemList) {
		String output = "";
		for (int i = 0; i < itemList.size(); i++) {
			output += String.format("%-70s\n", itemList.get(i).toString());
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
	public static String retrieveAllBids(ArrayList<Bid> BidList) {
		String output = "";

		for (int i = 0; i < BidList.size(); i++) {

			output += String.format("%-50s\n", BidList.get(i).toString());
		}
		return output;
	}

	public static void viewAllBids(ArrayList<Bid> BidList) {
		C206_CaseStudy.setHeader("BID LIST");
		String output = String.format("%-10s%-30s%-10s\n", "BID ID", "BID START DATE TIME", "BID AMOUNT");
		output += retrieveAllBids(BidList);
		System.out.println(output);
	}

	// retrieve and view all payments
	public static String retrieveAllPayments(ArrayList<Payment> PaymentList) {
		String output = "";
		for (int i = 0; i < PaymentList.size(); i++) {
			output += String.format("%-80s\n", PaymentList.get(i).toString());
		}
		for (int i = 0; i < PaymentList.size(); i++) {
			output += String.format("%-50s\n", PaymentList.get(i).toString());
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
	public static User inputUser() {
		String name = Helper.readString("Enter Name > ");
		String userID = Helper.readString("Enter UserID > ");
		String password = Helper.readString("Enter Password > ");

		User u = new User(name, userID, password);
		return u;

	}

	public static void addUser(ArrayList<User> UserList, User u) {
		User u1;
		String actualUserID = u.getUserID();
		for (int i = 0; i < UserList.size(); i++) {
			u1 = UserList.get(i);
			String checkUser = u1.getUserID();
			if (checkUser.equalsIgnoreCase(actualUserID))
				return;
		}
		UserList.add(u);

	}

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
	public static Bid inputBid() {
		int bidId = Helper.readInt("Enter Bid ID > ");
		double bidamount = Helper.readDouble("Enter Bid amount > ");
		LocalDateTime BidStartDateTime = LocalDateTime.now();

		Bid b = new Bid(bidId, bidamount, BidStartDateTime);
		return b;

	}

	public static void addBid(ArrayList<Bid> BidList, Bid b) {
		Bid b1;
		for (int i = 0; i < BidList.size(); i++) {
			b1 = BidList.get(i);
			if (b1.getBidId() == (b.getBidId()))
				return;
		}
		LocalDateTime actualBidStartDateTime = b.getBidStartDateTime();
		if ((b.getBidId() == 0) || (b.getBidamount() == 0.00) || (actualBidStartDateTime == null)) {
			return;
		}
		BidList.add(b);

	}

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
	public static boolean doDeleteUser(ArrayList<User> UserList, User u) {
		boolean isDeleted = false;
		String userID = u.getUserID();
		if (userID.isEmpty())
			return false;

		for (int i = 0; i < UserList.size(); i++) {
			String checkUser = UserList.get(i).getUserID();
			if (checkUser.equals(userID)) {
				UserList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void DeleteUser(ArrayList<User> UserList) {
		C206_CaseStudy.viewAllUsers(UserList);
		String userID = Helper.readString("Enter userID > ");
		User correctUser = null;
		for (User U : UserList) {
			if (U.getUserID() == userID) {
				correctUser = U;
				// break; // Stop looping once the correct user is found
			}
		}
		Boolean isDeleted = doDeleteUser(UserList, correctUser);
		if (isDeleted == false) {
			System.out.println("Invalid user ID");
		} else {
			System.out.println("User deleted");
		}
	}

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
	public static boolean doDeleteBid(ArrayList<Bid> BidList, Bid b) {
		boolean isDeleted = false;
		LocalDateTime actualBidStartDateTime = b.getBidStartDateTime();
		if ((b.getBidId() == 0) || (b.getBidamount() == 0.00) || (actualBidStartDateTime == null))
			return false;

		for (int i = 0; i < BidList.size(); i++) {
			Bid currentBid = BidList.get(i);
			boolean getBidAmount = currentBid.getBidamount() == b.getBidamount();
			boolean getBidStartDatetime = currentBid.getBidStartDateTime().equals(b.getBidStartDateTime());
			if (getBidAmount && getBidStartDatetime) {
				BidList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void DeleteBid(ArrayList<Bid> BidList) {
		C206_CaseStudy.viewAllBids(BidList);
		int bidId = Helper.readInt("Enter Bid ID > ");
		Bid correctBid = null;
		for (Bid B : BidList) {
			if (B.getBidId() == bidId) {
				correctBid = B;
			}
		}
		Boolean isDeleted = doDeleteBid(BidList, correctBid);

		if (isDeleted == false) {
			System.out.println("Invalid bid ID");
		} else {
			System.out.println("Bid deleted");
		}
	}

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
