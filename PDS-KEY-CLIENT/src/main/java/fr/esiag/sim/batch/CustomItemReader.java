package fr.esiag.sim.batch;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

public class CustomItemReader implements ItemReader<List<LinkedHashMap>>{
	public static final String SERVER_URI = "http://localhost:8080/pds-webservice-api/personsjson";
    
	@Override
	public List<LinkedHashMap> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		RestTemplate restTemplate = new RestTemplate();
	       
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI, List.class);
        return emps;
	}

}
