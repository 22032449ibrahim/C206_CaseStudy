import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Payment p1;
	private Payment p2;
	private Item item1;
	private Item item2;

	private ArrayList<Payment> PaymentList;
	private ArrayList<Item> itemList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		p1 = new Payment("1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20);
		p2 = new Payment("1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45);
		item1 = new Item("starry night", "by van gogh", 5999.99);
		item2 = new Item("the poppy field", "by claude monet", 4999.99);

		PaymentList = new ArrayList<Payment>();
		itemList = new ArrayList<Item>();
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
		testOutput = String.format("%-30s %-20s %-20s %-10.2f\n", "1234-1234-1234-1234", "Johnny Bob",
				"12/12/2021 10:30", 999.20);
		testOutput += String.format("%-30s %-20s %-20s %-10.2f\n", "1234-1234-1234-4321", "Bobby Kim",
				"12/11/2021 10:30", 123.45);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allpayment);

	}

	@Test
	public void testDeletePayment() {

		// Given a list with two payment objects, after deleting 1 item, the size of the
		// list is 1 - normal
		// The item that was not deleted is as same as the first item of the list
		C206_CaseStudy.addPayment(PaymentList, p1);
		C206_CaseStudy.addPayment(PaymentList, p2);
		C206_CaseStudy.doDeletePayment(PaymentList, p1);
		assertEquals("Check that Payment arraylist size is 1", 1, PaymentList.size());
		assertSame("Check that the payment that was not delete remains", p2, PaymentList.get(0));

		// Delete an item that has missing detail
		Payment p_missing = new Payment("1234-1234-1234-1234", "Johnny Bob", null, 567.80);
		C206_CaseStudy.doDeletePayment(PaymentList, p_missing);
		assertEquals("Test that the Payment arraylist size is unchange.", 1, PaymentList.size());

		// Delete an item that does not exist in the list
		Payment p_notInList = new Payment("2345-2345-2345-2345", "Ibrahim", LocalDateTime.of(2021, 12, 9, 10, 30),
				567.80);
		C206_CaseStudy.doDeletePayment(PaymentList, p_notInList);
		assertEquals("Test that the Payment arraylist size is unchange.", 1, PaymentList.size());
	}
	
	@Test
	public void testAddItem() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Item arraylist to add to", itemList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addItem(itemList, item1);
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that Item is added", item1, itemList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Check that Item arraylist size is 2", 2, itemList.size());
		assertSame("Check that Item is added", item2, itemList.get(1));
	}
	
	@Test
	public void testRetrieveAllItems() {
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid item arraylist to add to", itemList);
		assertEquals("Test that the item arraylist is empty.", 0, itemList.size());
		// Attempt to retrieve the payment
		String allItem = C206_CaseStudy.retrieveAllItems(itemList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allItem);

		// Test Case 2
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		// Test that the list is not empty
		assertEquals("Test that payment arraylist size is 2.", 2, itemList.size());
		// Attempt to retrieve the payment
		allItem = C206_CaseStudy.retrieveAllItems(itemList);
		testOutput += String.format("%-30s %-20s %-20.2f\n", "starry night", "by van gogh", 5999.99);
		testOutput += String.format("%-30s %-20s %-20.2f\n", "the poppy field", "by claude monet", 4999.99);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allItem);
	}
	
	@Test
	public void testDeleteItem() {

		// Given a list with two item objects, after deleting 1 item, the size of the
		// list is 1 - normal
		// The item that was not deleted is as same as the first item of the list
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		C206_CaseStudy.doDeleteItem(itemList, item1);
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that the Item that was not delete remains", item2, itemList.get(0));

		// Delete an item that has missing detail
		Item item_missing = new Item("%-30s %-20s %-20.2f\n", "starry night", 5999.99);
		C206_CaseStudy.doDeleteItem(itemList, item_missing);
		assertEquals("Test that the Payment arraylist size is unchange.", 1, PaymentList.size());

		// Delete an item that does not exist in the list
		Item item_notInList = new Item("mona lisa", "by leonardo da vinci", 6999.99);
		C206_CaseStudy.doDeleteItem(itemList, item_notInList);
		assertEquals("Test that the Item arraylist size is unchange.", 1, itemList.size());
	}

	@After
	public void tearDown() throws Exception {

		p1 = null;
		p2 = null;
		item1 = null;
		item2 = null;
		PaymentList = null;
		itemList = null;
	}

}
