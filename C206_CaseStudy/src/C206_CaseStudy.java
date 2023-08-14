import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	private static final int OPTION_ADD_AUCTION = 4;
	private static final int OPTION_VIEW_AUCTION = 5;
	private static final int OPTION_DELETE_AUCTION = 6;
	private static final int OPTION_ADD_BID = 10;
	private static final int OPTION_VIEW_BID = 11;
	private static final int OPTION_DELETE_BID = 12;

	public static void main(String[] args) {

		ArrayList<Payment> PaymentList = new ArrayList<Payment>();

		PaymentList.add(
				new Payment(1, "1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20));
		PaymentList.add(
				new Payment(2, "1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45));

		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("starry night", "by van gogh", 5999.99));
		itemList.add(new Item("poppy field", "by claude monet", 4999.99));

		List<String> items1 = new ArrayList<>();
		items1.add("Lamp");
		items1.add("Carpet");

		List<String> items2 = new ArrayList<>();
		items2.add("Chair");
		items2.add("Table");
		items2.add("Plants");

		ArrayList<Auction> AuctionList = new ArrayList<Auction>();
		AuctionList.add(new Auction("Auction 1", "Home Furniture", LocalTime.of(8, 40), LocalTime.of(12, 10), items1));
		AuctionList.add(new Auction("Auction 2", "Room Furniture", LocalTime.of(10, 00), LocalTime.of(12, 30), items2));

		ArrayList<Bid> BidList = new ArrayList<Bid>();
		BidList.add(new Bid(1, 2542624.66, LocalDateTime.of(2021, 12, 12, 10, 30)));
		BidList.add(new Bid(2, 2542674.36, LocalDateTime.of(2022, 4, 5, 10, 30)));


		ArrayList<User> UserList = new ArrayList<User>();

		UserList.add(new User("Sung Hanbin", "SHB01", "sunghanbin20@gmail.com", "Administrator", "0613SHB"));
		UserList.add(new User("Mark Lee", "MKL02", "marklee127@gmail.com", "User", "0207MKLEE"));


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

			} else if (option == OPTION_ADD_AUCTION) {
				// Add auction
				Auction auction = inputAuction();
				C206_CaseStudy.addAuction(AuctionList, auction);
				System.out.println("Auction added");

			} else if (option == OPTION_VIEW_AUCTION) {
				// View all auction
				C206_CaseStudy.viewAllAuctions(AuctionList);

			} else if (option == OPTION_DELETE_AUCTION) {
				// Delete existing auction
				C206_CaseStudy.deleteAuction(AuctionList);

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
			output += String.format("%-30s %-20s\n", UserList.get(i).getName(), UserList.get(i).getUserID());
		}
		return output;

	}

	public static void viewAllUsers(ArrayList<User> UserList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-30s %-20s\n", "NAME", "USERID");
		output += retrieveAllUsers(UserList);
		System.out.println(output);
	}

	// retrieve and view all auction
	public static String retrieveAllAuctions(ArrayList<Auction> AuctionList) {
		String output = "";
		for (int i = 0; i < AuctionList.size(); i++) {
			output += String.format("%-80s\n", AuctionList.get(i).toString());
		}
		return output;

	}

	public static void viewAllAuctions(ArrayList<Auction> AuctionList) {
		C206_CaseStudy.setHeader("AUCTION LIST");
		String output = String.format("%-15s %-20s %-15s %-10s %-20s\n", "TITLE", "DESCRIPTION", "START TIME",
				"END TIME", "ITEMS AVAILABLE");
		output += retrieveAllAuctions(AuctionList);
		System.out.println(output);
	}

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
			output += String.format("%-85s\n", PaymentList.get(i).toString());
		}

		return output;

	}

	public static void viewAllPayments(ArrayList<Payment> PaymentList) {
		C206_CaseStudy.setHeader("PAYMENT LIST");
		String output = String.format("%-5s %-30s %-20s %-20s %-10s\n", "ID", "CARD NUMBER", "CARD HOLDER",
				"PAYMENT DATETIME", "AMOUNT");
		output += retrieveAllPayments(PaymentList);
		System.out.println(output);
	}

	// ================================= Option 2 Adding (CRUD -
	// Create)=================================

	// Input and Add Users
	public static User inputUser() {
		String name = Helper.readString("Enter Name > ");
		String userID = Helper.readString("Enter UserID > ");
		String email = Helper.readString("Enter email > ");
		String password = Helper.readString("Enter Password > ");
		String role = Helper.readString("Enter User's role > ");

		User u = new User(name, userID, email, role, password);
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

		if ((u.getUserID() == null) || (u.getName() == null) || (u.getEmail() == null) || (u.getRole() == null)
				|| (u.getPassword() == null)) {
			return;
		}
		UserList.add(u);

	}

	// Input and Add auction
	public static Auction inputAuction() {
		String title = Helper.readString("Enter Title of Auction > ");
		String description = Helper.readString("Enter Description of Auction > ");
		LocalTime startTime = LocalTime.parse(Helper.readString("Enter Start Time in the format HH:mm > "));
		LocalTime endTime = LocalTime.parse(Helper.readString("Enter End Time in the format HH:mm > "));

		List<String> itemsAvailable = new ArrayList<>();
		int itemCount = Helper.readInt("Enter the number of items available in the auction > ");
		for (int i = 1; i <= itemCount; i++) {
			String item = Helper.readString("Enter Item " + i + " > ");
			itemsAvailable.add(item);
		}

		return new Auction(title, description, startTime, endTime, itemsAvailable);

	}

	public static void addAuction(ArrayList<Auction> AuctionList, Auction auction) {
		String title = auction.getTitle();
		String description = auction.getDescription();
		LocalTime startTime = auction.getStartTime();
		LocalTime endTime = auction.getEndTime();
		List<String> itemsAvailable = auction.getItemsAvailable();
		if ((title.isEmpty()) || (description.isEmpty()) || (startTime == null) || (endTime == null)
				|| (itemsAvailable.isEmpty())) {
			return;
		}
		AuctionList.add(auction);
	}

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
		int pid = Helper.readInt("Enter Payment id > ");
		String cardNum = Helper.readString("Enter Card Number > ");
		String cardHolder = Helper.readString("Enter Card Holder > ");
		Double amt = Helper.readDouble("Enter amount > ");
		LocalDateTime paymentDateTime = LocalDateTime.now();

		Payment p = new Payment(pid, cardNum, cardHolder, paymentDateTime, amt);
		return p;

	}

	public static void addPayment(ArrayList<Payment> PaymentList, Payment p) {
		Payment p1;

		int actualid = p.getId();
		for (int i = 0; i < PaymentList.size(); i++) {
			p1 = PaymentList.get(i);
			int checkid = p1.getId();
			if (checkid == actualid)
				return;
		}
		String actualCardNumber = p.getCardNumber();
		String actualCardHolder = p.getCardHolder();
		LocalDateTime actualPaymentdate = p.getPaymentdate();
		double actualAmount = p.getAmount();
		if ((actualid == 0) || (actualCardNumber.isEmpty()) || (actualCardHolder.isEmpty())
				|| (actualPaymentdate == null) || (actualAmount == 0.00)) {
			return;
		}
		PaymentList.add(p);
	}

	// ================================= Option 3 delete(CRUD -
	// delete)=================================

	// exist and delete Users
	public static boolean doDeleteUser(ArrayList<User> UserList, User u) {
		boolean isDeleted = false;
		if (u.getUserID() == null)
			return false;

		for (int i = 0; i < UserList.size(); i++) {
			User CheckcurrentUser = UserList.get(i);
			if (CheckcurrentUser.getUserID().equals(u.getUserID())) {
				UserList.remove(i);
				isDeleted = true;

			}
		}

		return isDeleted;
	}

	public static void DeleteUser(ArrayList<User> UserList) {
		C206_CaseStudy.viewAllUsers(UserList);
		String userID = Helper.readString("Enter User ID > ");
		User correctUser = null;
		for (User U : UserList) {
			if (U.getUserID().equals(userID)) {
				correctUser = U;
			}
		}
		if (correctUser == null) {
			System.out.println("User not found!");
		} else {
			Boolean isDeleted = doDeleteUser(UserList, correctUser);

			if (!isDeleted) {
				System.out.println("Invalid User ID");
			} else {
				System.out.println("User deleted");
			}
		}
	}

	// exist and delete auction
	public static boolean doDeleteAuction(ArrayList<Auction> AuctionList, Auction a) {
		boolean isDeleted = false;

		String title = a.getTitle();
		String description = a.getDescription();
		LocalTime starttime = a.getStartTime();
		LocalTime endtime = a.getEndTime();
		List<String> items = a.getItemsAvailable();

		if (title.isBlank() || description.isBlank() || starttime == null || endtime == null || items.isEmpty())
			return false;

		for (int i = 0; i < AuctionList.size(); i++) {
			String checkTitle = AuctionList.get(i).getTitle();
			if (checkTitle.equals(title)) {
				AuctionList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteAuction(ArrayList<Auction> AuctionList) {
		C206_CaseStudy.viewAllAuctions(AuctionList);
		String title = Helper.readString("Enter Title of Auction > ");
		Auction test = null;
		for (Auction a : AuctionList) {
			if (a.getTitle().equalsIgnoreCase(title)) {
				test = new Auction(a.getTitle(), a.getDescription(), a.getStartTime(), a.getEndTime(),
						a.getItemsAvailable());

				Boolean isDeleted = doDeleteAuction(AuctionList, test);
				if (isDeleted == false) {
					System.out.println("Invalid Auction Details!");
				} else {
					System.out.println("Auction Deleted");
				}
				break;
			}
		}

	}

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
		int id = p.getId();
		double amount = p.getAmount();
		String cardHolder = p.getCardHolder();
		String cardNumber = p.getCardNumber();
		LocalDateTime paymentdate = p.getPaymentdate();
		if (id == 0 || amount == 0 || cardHolder.isEmpty() || cardNumber.isEmpty() || paymentdate == null)
			return false;

		for (int i = 0; i < PaymentList.size(); i++) {
			int id2 = PaymentList.get(i).getId();
			int checkid = id2;
			if (checkid == id) {
				PaymentList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;

	}

	public static void deletePayment(ArrayList<Payment> PaymentList) {
		C206_CaseStudy.viewAllPayments(PaymentList);
		int pid = Helper.readInt("Enter Payment id > ");
		for (Payment P : PaymentList) {
			if (P.getId() == pid) {
				String cardNumber = P.getCardNumber();
				String cardHolder = P.getCardHolder();
				LocalDateTime paymentdate = P.getPaymentdate();
				double amount = P.getAmount();
				Payment deletep = new Payment(pid, cardNumber, cardHolder, paymentdate, amount);

				Boolean isDeleted = doDeletePayment(PaymentList, deletep);
				if (isDeleted == false) {
					System.out.println("Invalid Payment Details!");
				} else {
					System.out.println("Payment Deleted");
				}
				break;
			}
		}
	}

}
