import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Payment p1;
	private Payment p2;
	
	private Auction a1;
	private Auction a2;

	private ArrayList<Payment> PaymentList;
	private ArrayList<Auction> AuctionList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		List<String> items1 = new ArrayList<>();
		items1.add("Lamp");
		items1.add("Carpet");
		
		List<String> items2 = new ArrayList<>();
		items2.add("Chair");
		items2.add("Table");
		items2.add("Plants");
		
		p1 = new Payment("1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20);
		p2 = new Payment("1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45);
		a1 = new Auction("Auction 1", "Home Furniture", LocalTime.of(8, 40), LocalTime.of(12, 10), items1);
		a2 = new Auction("Auction 2", "Room Furniture", LocalTime.of(10, 00), LocalTime.of(12, 30), items2);

		PaymentList = new ArrayList<Payment>();
		AuctionList = new ArrayList<Auction>();
		
	}

	@Test
	public void testAddPayment() {
		// fail("Not yet implemented");

		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", PaymentList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addPayment(PaymentList, p1);
		assertEquals("Check that Payment arraylist size is 1", 1, PaymentList.size());
		assertSame("Check that Camcorder is added", p1, PaymentList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addPayment(PaymentList, p2);
		assertEquals("Check that Payment arraylist size is 2", 2, PaymentList.size());
		assertSame("Check that Payment is added", p2, PaymentList.get(1));

		// Add an item that has missing detail
		Payment p_missing = new Payment("4321-4321-4321-4321", "Jill Pi", null, 60.00);
		C206_CaseStudy.addPayment(PaymentList, p_missing);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, PaymentList.size());
	}

	@Test
	public void testRetrieveAllPayments() {
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid payment arraylist to add to", PaymentList);
		assertEquals("Test that the payment arraylist is empty.", 0, PaymentList.size());
		// Attempt to retrieve the payment
		String allpayment = C206_CaseStudy.retrieveAllPayments(PaymentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allpayment);

		// Test Case 2
		C206_CaseStudy.addPayment(PaymentList, p1);
		C206_CaseStudy.addPayment(PaymentList, p2);
		// Test that the list is not empty
		assertEquals("Test that payment arraylist size is 2.", 2, PaymentList.size());
		// Attempt to retrieve the payment
		allpayment = C206_CaseStudy.retrieveAllPayments(PaymentList);
		testOutput = String.format("%-30s %-20s %-20s %-10.2f\n", "1234-1234-1234-1234", "Johnny Bob", "12/12/2021 10:30", 999.20);
		testOutput += String.format("%-30s %-20s %-20s %-10.2f\n", "1234-1234-1234-4321", "Bobby Kim", "12/11/2021 10:30", 123.45);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allpayment);

	}
	@Test
	public void testDeletePayment() {

		// Given a list with two payment objects, after deleting 1 item, the size of the list is 1 - normal
		// The item that was not deleted is as same as the first item of the list
		C206_CaseStudy.addPayment(PaymentList, p1);
		C206_CaseStudy.addPayment(PaymentList, p2);
		C206_CaseStudy.doDeletePayment(PaymentList, p1);
		assertEquals("Check that Payment arraylist size is 1", 1, PaymentList.size());
		assertSame("Check that the payment that was not delete remains", p2, PaymentList.get(0));
		
		// Delete an item that has missing detail
		Payment p_missing = new Payment("1234-1234-1234-1234", "Johnny Bob",null,567.80 );
		C206_CaseStudy.doDeletePayment(PaymentList, p_missing);
		assertEquals("Test that the Payment arraylist size is unchange.", 1, PaymentList.size());

		// Delete an item that does not exist in the list
		Payment p_notInList = new Payment("2345-2345-2345-2345", "Ibrahim", LocalDateTime.of(2021, 12, 9, 10, 30), 567.80);
		C206_CaseStudy.doDeletePayment(PaymentList, p_notInList);
		assertEquals("Test that the Payment arraylist size is unchange.", 1, PaymentList.size());
	}


	@Test
	public void testAddAuction() {
		// fail("Not yet implemented");

		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Auction arraylist to add to", AuctionList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addAuction(AuctionList, a1);
		assertEquals("Check that Auction arraylist size is 1", 1, AuctionList.size());
		assertSame("Check that Camcorder is added", a1, AuctionList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addAuction(AuctionList, a2);
		assertEquals("Check that Auction arraylist size is 2", 2,AuctionList.size());
		assertSame("Check that Auction is added", a2, AuctionList.get(1));

		// Add an item that has missing detail
		List<String> items2 = new ArrayList<>();
		items2.add("Chair");
		items2.add("Table");
		items2.add("Plants");
		
		Auction a_missing = new Auction("Auction 2", "Room Furniture", null, LocalTime.of(12, 30), items2);
		C206_CaseStudy.addAuction(AuctionList, a_missing);
		assertEquals("Test that the Auction arraylist size is unchange.", 2, AuctionList.size());
	}
	
	@Test
	public void testRetrieveAllAuctions() {
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid auction arraylist to add to", AuctionList);
		assertEquals("Test that the auction arraylist is empty.", 0, AuctionList.size());
		// Attempt to retrieve the auction
		String allauction = C206_CaseStudy.retrieveAllAuctions(AuctionList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allauction);

		// Test Case 2
		C206_CaseStudy.addAuction(AuctionList, a1);
		C206_CaseStudy.addAuction(AuctionList, a2);
		// Test that the list is not empty
		assertEquals("Test that auction arraylist size is 2.", 2, AuctionList.size());
		// Attempt to retrieve the payment
		allauction = C206_CaseStudy.retrieveAllAuctions(AuctionList);
		List<String> items1 = new ArrayList<>();
		items1.add("Lamp");
		items1.add("Carpet");
		
		List<String> items2 = new ArrayList<>();
		items2.add("Chair");
		items2.add("Table");
		items2.add("Plants");
		
		testOutput = String.format("%-15s %-20s %-15s %-10s %-20s\n", "Auction 1", "Home Furniture","08:40", "12:10", items1);
		testOutput += String.format("%-15s %-20s %-15s %-10s %-20s\n", "Auction 2", "Room Furniture","10:00", "12:30", items2);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allauction);

	}
	
	@Test
	public void testDeleteAuction() {

		// Given a list with two auction objects, after deleting 1 item, the size of the list is 1 - normal
		// The item that was not deleted is as same as the first item of the list
		C206_CaseStudy.addAuction(AuctionList, a1);
		C206_CaseStudy.addAuction(AuctionList, a2);
		C206_CaseStudy.doDeleteAuction(AuctionList, a1);
		assertEquals("Check that Auction arraylist size is 1", 1, AuctionList.size());
		assertSame("Check that the auction that was not delete remains", a2, AuctionList.get(0));
		
		// Delete an item that has missing detail
		List<String> items2 = new ArrayList<>();
		items2.add("Chair");
		items2.add("Table");
		items2.add("Plants");
		
		Auction a_missing = new Auction("Auction 2", "Room Furniture", null, LocalTime.of(12, 30), items2);
		C206_CaseStudy.doDeleteAuction(AuctionList, a_missing);
		assertEquals("Test that the Auction arraylist size is unchange.", 1, AuctionList.size());

		// Delete an item that does not exist in the list
		List<String> items3 = new ArrayList<>();
		items3.add("Laptop");
		Auction a_notInList = new Auction("Auction 6", "Electronics", LocalTime.of(10, 10), LocalTime.of(04, 30), items3);
		C206_CaseStudy.doDeleteAuction(AuctionList, a_notInList);
		assertEquals("Test that the Auction arraylist size is unchange.", 1, AuctionList.size());
	}
	

	@After
	public void tearDown() throws Exception {

		p1 = null;
		p2 = null;
		PaymentList = null;
		
		a1=null;
		a2=null;
		AuctionList = null;
	}
	
	

}
