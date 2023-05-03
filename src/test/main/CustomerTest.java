package test.main;

import org.junit.*;
import org.mockito.*;

import main.java.dao.CustomerDAO;
import main.java.entity.Customer;

public class CustomerTest {
//	private ResultSet mockResultSet;
//	private static Connection mockConnection;
//	private static IDbConnector mockDbConnector;
//	private static PreparedStatement mockPreparedStatement;
	
	
	@Before
	public void setUp() {
//		mockConnection = Mockito.mock(Connection.class);
//		mockDbConnector = Mockito.mock(IDbConnector.class);
//		mockPreparedStatement = Mockito.mock(PreparedStatement.class);
//		mockResultSet = Mockito.mock(ResultSet.class);
	}
	
	@After
	public void finished() {
//		mockConnection = null;
//		mockDbConnector = null;
//		mockPreparedStatement = null;
//		mockResultSet = null;
	}
	
	@Test
	public void testCustomerId1() {
		try {		
			CustomerDAO cache = CustomerDAO.getDAO();
			Customer c = cache.selectId(1);
			Assert.assertEquals("John", c.getFirstname());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCustomerLogIn() {
		try {
			CustomerDAO cache = CustomerDAO.getDAO();
			Customer c1 = cache.selectLogIn("johnsmith@mail.com", "12345");
			Assert.assertEquals("John", c1.getFirstname());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occured");
		}
	}
}
