package fr.esiag.sim.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.esiag.sim.jdbc.JDBCConnection;
import fr.esiag.sim.jdbc.JDBCException;
import fr.esiag.sim.jdbc.JDBCQuery;
import fr.esiag.sim.model.City;

public class CityDAOImpl implements AbstractDAO<City> {
	
	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	@Override
	public List<City> list() {
		
		    JDBCConnection bddrq = new JDBCConnection();
		
		    List<List<String>> cityList;
			String request = "SELECT * from city;";
			
			try {
				cityList = bddrq.resultSelectQuery(request);
				List<City> cityListe = new ArrayList<City>();
				
				for (List<String> element : cityList) {
					
					int i = 0 ;
					
					City city = new City();
					
					for (String value : element) {
						
						switch(i)
						{
							case 0:
								city.setIdCity(Integer.valueOf(value));
								break;
							case 1:
								city.setNameCity(value);
								break;
							case 2:
								city.setIdCity(Integer.valueOf(value));
								break;
							case 3:
								city.setLatitude(value);
								
								break;
							case 4:
								city.setLongitude(value);
								break;
						}
						
						i++;
					}cityListe.add(city);
				}
				return cityListe;
			} catch (JDBCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;	
		
	}


	@Override
	public City getById(int id) {
		JDBCConnection bddrq = new JDBCConnection();
		List<List<String>> actList;
		
		String request = "SELECT * FROM city WHERE "
					+ "id = '" + String.valueOf(id) + "';";

			logger.info("SQL : " + request);
			City city = new City();
			try {
				actList = bddrq.resultSelectQuery(request);
				for (List<String> element : actList) {
					int i = 0 ;
					for (String value : element) {
						
						switch(i)
						{
							case 0:
								city.setIdCity(Integer.valueOf(value));
								break;
							case 1:
								city.setNameCity(value);
								break;
							case 2:
								city.setIdCity(Integer.valueOf(value));
								break;
							case 3:
								city.setLatitude(value);
								
								break;
							case 4:
								city.setLongitude(value);
								break;
						}
						i++;
					}
				}
			} catch (JDBCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return city;
	}


	@Override
	public void add(City city) {
		String request = "INSERT INTO city(nameCity, latitude, longitude) "
				+ "VALUES ('" + city.getNameCity() + 
				 "', '" + city.getLatitude() + "', '" + city.getLongitude()  + "');"; 
		
		logger.info("SQL : " + request);
		JDBCQuery.executeThisUpdateQuery(request);
	}

}



