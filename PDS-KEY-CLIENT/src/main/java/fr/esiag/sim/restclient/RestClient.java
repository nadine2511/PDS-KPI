package fr.esiag.sim.restclient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import fr.esiag.sim.dao.CityDAOImpl;
import fr.esiag.sim.model.City;
import fr.esiag.sim.dao.SectorDAOImpl;
import fr.esiag.sim.model.Sector;
import fr.esiag.sim.dao.OperatorDAOImpl;
import fr.esiag.sim.model.Operator;

public class RestClient {
	 public static final String SERVER_URI_CITY = "http://localhost:8080/PDS-KEY-PERF/cityjson";
	 public static final String SERVER_URI_SECTOR = "http://localhost:8080/PDS-KEY-PERF//sectorjson";
	 public static final String SERVER_URI_OPERATOR = "http://localhost:8080/PDS-KEY-PERF//operatorjson";
 
	    public void GetAllTables(){
	         
 	       System.out.println("*****");
	       getCity();
	       getSector();
	       getOperator();
	      
     
	    }
	 

	    private static void getCity() {
	    	
	    
	    	//getCurrentDate();
	    	
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date = new Date();
	    	String sDate = sdf.format(date);
	     	
	    	RestTemplate restTemplate = new RestTemplate();
	  
	        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_CITY, List.class);
	        
	        CityDAOImpl cityDAO = new CityDAOImpl();
	        
	        cityDAO.createTable();
	        
	        List<City> cityList = new LinkedList<City>();
		    
	        cityList = cityDAO.list();
	        
		    for(LinkedHashMap map : emps){
	        	
	        	boolean found = false;
	        	
	        	for(City city:cityList)
	        	{
	        		if(map.get("nameCity").toString().equals(city.getNameCity()) && Integer.parseInt(map.get("idSector").toString()) == city.getIdSector())
	        		{
	        				found = true;
	        				break;
	        		}
             	}
	        	
	        	if(found == false)
	        	{
	        		City city = new City();
		        	System.out.println("New city Added : " + map.get("nameCity"));
		        	city.setNameCity(map.get("nameCity").toString());
		        	city.setIdSector(Integer.parseInt(map.get("idSector").toString()));
		        	city.setLatitude(map.get("latitude").toString());
		        	city.setLongitude(map.get("longitude").toString());
		        	city.setDateExtract(sDate);
		        	cityDAO.add(city);
		        }
	        
	         }
	    }
	        
	        private static void getSector() {
	        	
	        	//getCurrentDate();
	         	
	        
	           	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	Date date = new Date();
		    	String sDate = sdf.format(date);
		    
		    	RestTemplate restTemplate = new RestTemplate();
		  
		        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_SECTOR, List.class);
		        
		        SectorDAOImpl sectorDAO = new SectorDAOImpl();
		        
		        sectorDAO.createTable();
		        
		        List<Sector> sectorList = new LinkedList<Sector>();
			    
		        sectorList = sectorDAO.list();
		    
		        for(LinkedHashMap map : emps){
		        	boolean found = false;
		        	
		        	for(Sector sector:sectorList)
		        	{
		        		if((map.get("nameSector").toString().equals(sector.getNameSector())) && (map.get("wording").toString().equals(sector.getWording())))
		        		{
		        				found = true;
		        				break;
		        		}
	             	}
		        	
		        	if(found == false)
		        	{
		        	  	Sector sector = new Sector();
			        	
			        	sector.setNameSector(map.get("nameSector").toString());
			        	sector.setWording(map.get("wording").toString());
			        	sector.setLatitude(map.get("latitude").toString());
			        	sector.setLongitude(map.get("longitude").toString());
			        	sector.setDateExtract(sDate);
			        	sectorDAO. add(sector);

		        	}
		      
		       
		        }
	    }
	 
	        private static void getOperator() {
	        	
	        	//getCurrentDate();
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	Date date = new Date();
		    	String sDate = sdf.format(date);
		  	
		        RestTemplate restTemplate = new RestTemplate();
		  
		        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI_OPERATOR, List.class);
		        OperatorDAOImpl operatorDAO = new OperatorDAOImpl();
		        operatorDAO.createTable();
		        
		        List<Operator> operatorList = new LinkedList<Operator>();
			    
		        operatorList = operatorDAO.list();
		    
		        
		        for(LinkedHashMap map : emps){
		        	
		        	boolean found = false;
		        	
		        	for(Operator operator:operatorList)
		        	{
		        		if((map.get("firstNameOP").toString().equals(operator.getFirstNameOP())) &&
		        			(map.get("lastNameOP").toString().equals(operator.getLastNameOP())) &&
		        			(Integer.parseInt(map.get("idSector").toString()) == operator.getIdSector()) &&
		        			(map.get("loginOperator").toString().equals(operator.getLoginOperator())) &&
		        			(map.get("passwordOp").toString().equals(operator.getPasswordOp())))
		        		{
		        				found = true;
		        				break;
		        		}
	             	}
		        	
		        	if(found == false)
		        	{
		            	Operator operator = new Operator();
			        	
			        	operator.setFirstNameOP(map.get("firstNameOP").toString());
			        	operator.setLastNameOP(map.get("lastNameOP").toString());
			        	operator.setIdSector(Integer.parseInt(map.get("idSector").toString()));
			        	operator.setLoginOperator(map.get("loginOperator").toString());
			        	operator.setPasswordOp(map.get("passwordOp").toString());
			        	operator.setDateExtract(sDate);
			        	operatorDAO.add(operator);
		
		        	}
		
		       
		        }
	    }

			
}
