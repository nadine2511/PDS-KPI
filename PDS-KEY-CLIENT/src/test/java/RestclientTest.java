import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.esiag.sim.restclient.RestClient;


public class RestclientTest {

	static RestClient rest = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rest = new RestClient();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCity() {
		List<LinkedHashMap> emps = rest.getCity();
		if(emps.isEmpty())
			fail("Failed to get City table");
	}
	
	@Test
	public void testGetSector() {
		List<LinkedHashMap> emps = rest.getSector();
		if(emps.isEmpty())
			fail("Failed to get Sector table");
	}
	
	@Test
	public void testGetOperator() {
		List<LinkedHashMap> emps = rest.getOperator();
		if(emps.isEmpty())
			fail("Failed to get Operator table");
	}

}
