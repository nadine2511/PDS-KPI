package fr.esiag.sim.restclient;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import fr.esiag.sim.dao.CityDAOImpl;
import fr.esiag.sim.model.City;
import fr.esiag.sim.dao.SectorDAOImpl;
import fr.esiag.sim.model.Sector;
import fr.esiag.sim.dao.OperatorDAOImpl;
import fr.esiag.sim.model.Operator;

public class RestClient {
	 public static final String SERVER_URI_CITY = "http://localhost:8080/pds-kpi/cityjson";
	 public static final String SERVER_URI_SECTOR = "http://localhost:8080/pds-kpi/sectorjson";
	 public static final String SERVER_URI_OPERATOR = "http://localhost:8080/pds-kpi/operatorjson";

	    public static void main(String args[]){
	         
	       
	        System.out.println("*****");
	        //getCity();
	        getSector();
	        //getOperator();
	    }
	 
	    private static void getCity() {
	        RestTemplate restTemplate = new RestTemplate();
	  
	        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_CITY, List.class);
	        CityDAOImpl cityDAO = new CityDAOImpl();
	        for(LinkedHashMap map : emps){
	        	City city = new City();
	        	
	        	city.setNameCity(map.get("nameCity").toString());
	        	city.setLatitude(map.get("latitude").toString());
	        	city.setLongitude(map.get("longitude").toString());
	        	cityDAO.add(city);
	        	city.toString();
	       
	        }
	    }
	        
	        private static void getSector() {
		        RestTemplate restTemplate = new RestTemplate();
		  
		        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_SECTOR, List.class);
		        SectorDAOImpl sectorDAO = new SectorDAOImpl();
		        for(LinkedHashMap map : emps){
		        	Sector sector = new Sector();
		        	
		        	sector.setNameSector(map.get("nameSector").toString());
		        	sector.setWording(map.get("wording").toString());
		        	sector.setLatitude(map.get("latitude").toString());
		        	sector.setLongitude(map.get("longitude").toString());
		        	sectorDAO.add(sector);
		        	sector.toString();
		       
		        }
	    }
	 
	        private static void getOperator() {
		        RestTemplate restTemplate = new RestTemplate();
		  
		        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_OPERATOR, List.class);
		        OperatorDAOImpl operatorDAO = new OperatorDAOImpl();
		        for(LinkedHashMap map : emps){
		        	Operator operator = new Operator();
		        	
		        	operator.setFirstNameOP(map.get("firstNameOP").toString());
		        	operator.setLastNameOP(map.get("lastNameOP").toString());
		        	operator.setLoginOperator(map.get("loginOperator").toString());
		        	operator.setPasswordOp(map.get("passwordOp").toString());
		        	operatorDAO.add(operator);
		        	operator.toString();
		       
		        }
	    }
}
