import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {

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
		
		ArrayList<Bid> BidList = new ArrayList<Bid>();
		BidList.add(new Bid(1,2542624.66,LocalDateTime.of(2021, 12, 12, 10, 30)));
		BidList.add(new Bid(2, 2542674.36,LocalDateTime.of(2022, 4, 5, 10, 30)));
		
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

			} else if (option == 8) {
				// View all item

			} else if (option == 9) {
				// Delete existing item

			} else if (option == OPTION_ADD_BID) {
				// Add bid
				Bid b = inputBid();
				C206_CaseStudy.addBid(BidList,b);
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

	// retrieve and view all auction

	// retrieve and view all items

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
		String output = String.format("%-10s%-30s%-10s\n", "BID ID", "BID START DATE TIME","BID AMOUNT");
		 output += retrieveAllBids(BidList);	
		System.out.println(output);
	}
	
	// retrieve and view all payments
	public static String retrieveAllPayments(ArrayList<Payment> PaymentList) {
		String output = "";
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

	// Input and Add auction

	// Input and Add items

	// Input and Add bids
	public static Bid inputBid() {
		int bidId = Helper.readInt("Enter Bid ID > ");
		double bidamount = Helper.readDouble("Enter Bid amount > ");
		LocalDateTime BidStartDateTime = LocalDateTime.now();

		Bid b= new Bid(bidId,bidamount, BidStartDateTime);
		return b;
		
	}
	public static void addBid(ArrayList<Bid> BidList, Bid b) {
		Bid b1;
		for(int i = 0; i < BidList.size(); i++) {
			b1 = BidList.get(i);
			if (b1.getBidId()==(b.getBidId()))
				return;
		}
		LocalDateTime actualBidStartDateTime = b.getBidStartDateTime();
		if ((b.getBidId()==0)||(b.getBidamount()==0.00) || (actualBidStartDateTime == null)) {
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

	// exist and delete auction

	// exist and delete items

	// exist and delete bids
	public static boolean doDeleteBid(ArrayList<Bid> BidList,Bid b) {
		boolean isDeleted = false;
		LocalDateTime actualBidStartDateTime = b.getBidStartDateTime();
		if ((b.getBidId()==0)||(b.getBidamount()==0.00) || (actualBidStartDateTime == null))
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
		for(Bid B:BidList) {
			if(B.getBidId()==bidId) {
				 correctBid=B;
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
