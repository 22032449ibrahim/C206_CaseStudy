import static org.junit.Assert.*;

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
		p1 = new Payment("1234-1234-1234-1234", "Johnny Bob", "12/12/2022", 999.20);
		p2 = new Payment("1234-1234-1234-4321", "Bobby Kim", "11/12/2022", 123.45);

		PaymentList = new ArrayList<Payment>();
	}

	@Test
	public void testAddPayment() {
		// fail("Not yet implemented");
		
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Camcorder arraylist to add to", PaymentList);
		
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
	}

	@After
	public void tearDown() throws Exception {

		p1 = null;
		p2 = null;
		PaymentList = null;
	}

}
