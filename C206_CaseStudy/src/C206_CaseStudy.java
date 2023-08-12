import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
				Auction auction = inputAuction();
				C206_CaseStudy.addAuction(AuctionList, auction);
				System.out.println("Auction Successfully Added");

			} else if (option == 5) {
				// View all auction
				C206_CaseStudy.viewAllAuctions(AuctionList);

			} else if (option == 6) {
				// Delete existing auction
				C206_CaseStudy.toDeleteAuction(AuctionList);

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
			if (option!=16&&Helper.readChar("\nMenu? (Y/N) >") == 'Y') {
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
	public static String retrieveAllAuctions(ArrayList<Auction> AuctionList) {
		String output = "";
		for (int i = 0; i < AuctionList.size(); i++) {			
			output += String.format("%-80s\n", AuctionList.get(i).toString());
	}
		return output;
		
	}

	public static void viewAllAuctions(ArrayList<Auction> AuctionList) {
        C206_CaseStudy.setHeader("AUCTION LIST");
        String output = String.format("%-15s %-20s %-15s %-10s %-20s\n", "TITLE", "DESCRIPTION", "START TIME", "END TIME", "ITEMS AVAILABLE");
        output += retrieveAllAuctions(AuctionList);
        System.out.println(output);
    }

	// retrieve and view all items

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
	public static boolean deleteAuction(ArrayList<Auction> AuctionList, Auction auction) {

		boolean isDeleted = false;
		String title = auction.getTitle();
		String description = auction.getDescription();
		LocalTime startTime = auction.getStartTime();
		LocalTime endTime = auction.getEndTime();
		List<String> itemsAvailable = auction.getItemsAvailable();
		if ((title.isEmpty()) || (description.isEmpty()) || (startTime == null) || (endTime == null)
		        || (itemsAvailable.isEmpty())) 
		    return false;

		for (int i = 0; i < AuctionList.size(); i++) {
			String checkTitle = AuctionList.get(i).getTitle();
			if(checkTitle.equals(title)) {
				AuctionList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;

	}
	
	public static void toDeleteAuction(ArrayList<Auction> AuctionList) {
		C206_CaseStudy.viewAllAuctions(AuctionList);
		String title = Helper.readString("Enter Title of Auction > ");
		String description = Helper.readString("Enter Description of Auction > ");
		LocalTime startTime = LocalTime.parse(Helper.readString("Enter Start Time in the format HH:mm > "));
        LocalTime endTime = LocalTime.parse(Helper.readString("Enter End Time in the format HH:mm > "));
        
        List<String> itemsAvailable = new ArrayList<>();
        int itemCount = Helper.readInt("Enter the number of items available in the auction > ");
        for (int i = 1; i <= itemCount; i++) {
            String item = Helper.readString("Enter Item " + i + " > ");
            itemsAvailable.add(item);
		Auction auction = new Auction(title, description, startTime, endTime, itemsAvailable);

		Boolean isDeleted = deleteAuction(AuctionList, auction);
		if (isDeleted == false) {
			System.out.println("Invalid Auction Details!");
		} else {
			System.out.println("Auction Deleted");
			}
        }
	}


	// exist and delete items

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
