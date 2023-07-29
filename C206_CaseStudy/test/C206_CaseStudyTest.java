import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Payment p1;
	private Payment p2;

	private ArrayList<Payment> PaymentList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		p1 = new Payment("1234-1234-1234-1234", "Johnny Bob", LocalDateTime.of(2021, 12, 12, 10, 30), 999.20);
		p2 = new Payment("1234-1234-1234-4321", "Bobby Kim", LocalDateTime.of(2021, 11, 12, 10, 30), 123.45);

		PaymentList = new ArrayList<Payment>();
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

	@After
	public void tearDown() throws Exception {

		p1 = null;
		p2 = null;
		PaymentList = null;
	}

}
