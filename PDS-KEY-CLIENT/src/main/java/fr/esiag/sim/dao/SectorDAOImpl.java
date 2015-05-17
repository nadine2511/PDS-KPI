package fr.esiag.sim.dao;

	import java.util.ArrayList;
import java.util.List;

	import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	import fr.esiag.sim.jdbc.JDBCConnection;
import fr.esiag.sim.jdbc.JDBCException;
import fr.esiag.sim.jdbc.JDBCQuery;
import fr.esiag.sim.model.Sector;

	public class SectorDAOImpl implements AbstractDAO<Sector> {
		
		private static final Logger logger = LoggerFactory.getLogger(SectorDAOImpl.class);

		@Override
		public List<Sector> list() {
			
			    JDBCConnection bddrq = new JDBCConnection();
			
			    List<List<String>> sectorList;
				String request = "SELECT * from sector;";
				
				try {
					sectorList = bddrq.resultSelectQuery(request);
					List<Sector> sectorListe = new ArrayList<Sector>();
					
					for (List<String> element : sectorList) {
						
						int i = 0 ;
						
						Sector sector = new Sector();
						
						for (String value : element) {
							
							switch(i)
							{
							case 0:
								sector.setIdSector(Integer.valueOf(value));
								break;
							case 1:
								sector.setNameSector(value);
								break;
							case 2:
								sector.setWording(value);
								break;
							case 3:
								sector.setLatitude(value);
								
								break;
							case 4:
								sector.setLongitude(value);
								break;
							}
							
							i++;
						}sectorListe.add(sector);
					}
					return sectorListe;
				} catch (JDBCException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;	
			
		}

		@Override
		public void add(Sector sector) {
			String request = "INSERT INTO sector(nameSector, wording, latitude, longitude) "
					+ "VALUES ('" + sector.getNameSector() + "', '" + sector.getWording() +
					 "', '" + sector.getLatitude() + "', '" + sector.getLongitude()  + "');"; 
			
			logger.info("SQL : " + request);
			JDBCQuery.executeThisUpdateQuery(request);
		}
		
		@Override
		public void createTable() {
			String request = "CREATE TABLE sector ( idSector INT PRIMARY KEY NOT NULL AUTO_INCREMENT, nameSector VARCHAR(100), wording VARCHAR(200), latitude VARCHAR(50), longitude VARCHAR(50), dateExtract VARCHAR(45))";
			
			logger.info("SQL : " + request);
			JDBCQuery.executeThisUpdateQuery(request);
		}
	}	
	
	
