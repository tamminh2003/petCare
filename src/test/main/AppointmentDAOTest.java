package test.main;

import org.junit.*;
import main.java.entity.Customer;

public class AppointmentDAOTest {
	@BeforeClass
	public static void setUp() {
		
	}
	
	@AfterClass
	public static void finished() {
		
	}
	
	@Test
	public void testCustomerId1() {
		try {
			Customer c = new Customer(1);
			Assert.assertEquals("John", c.getFirstname());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCustomerId2() {
		try {
			Customer c = new Customer(2);
			Assert.assertEquals("Jane", c.getFirstname());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
