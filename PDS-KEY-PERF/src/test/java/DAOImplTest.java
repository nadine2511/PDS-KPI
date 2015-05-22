import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.esiag.sim.dao.CityDAOImpl;
import fr.esiag.sim.dao.OperatorDAOImpl;
import fr.esiag.sim.dao.SectorDAOImpl;
import fr.esiag.sim.model.City;
import fr.esiag.sim.model.Operator;
import fr.esiag.sim.model.Sector;


public class DAOImplTest {

	static CityDAOImpl cityDAO = null;
	static OperatorDAOImpl OperatorDAO = null;
	static SectorDAOImpl SectorDAO = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cityDAO = new CityDAOImpl();
		OperatorDAO = new OperatorDAOImpl();
		SectorDAO = new SectorDAOImpl();
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
	public void testCityDAO() {
		List <City> cityList = cityDAO.list();
		
		if(cityList.isEmpty())
			fail("Failed to get City table");
	}
	
	@Test
	public void testOperatorDAO() {
		List <Operator> operatorList = OperatorDAO.list();
		
		if(operatorList.isEmpty())
			fail("Failed to get Operator table");
	}
	
	@Test
	public void testSectorDAO() {
		List <Sector> sectorList = SectorDAO.list();
		
		if(sectorList.isEmpty())
			fail("Failed to get Sector table");
	}
}
