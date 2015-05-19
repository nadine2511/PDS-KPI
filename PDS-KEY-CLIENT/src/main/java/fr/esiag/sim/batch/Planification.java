package fr.esiag.sim.batch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Planification {
 
	private int HeurePlanification;
	private int MinutePlanfication;
	private int DayPlanfication;

	public Planification()
	{
		
	}
	public void getPropValues() throws IOException {
 
		String result = "";
		Properties prop = new Properties();
		String propFileName = "planification";
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
 
		// get the property value and print it out
		HeurePlanification = Integer.parseInt(prop.getProperty("Heure"));
		MinutePlanfication = Integer.parseInt(prop.getProperty("Minute"));
		DayPlanfication = Integer.parseInt(prop.getProperty("Day"));
		
		result = "Planification  = " + "" +HeurePlanification + "h" + MinutePlanfication + "jour" + DayPlanfication;
		System.out.println(result );
	}
	
	public int getHeurePlanification()
	{
		return HeurePlanification;
	}
	
	public int getMinutePlanification()
	{
		return MinutePlanfication;
	}
	
	public int getDayPlanification()
	{
		return DayPlanfication;
	}
	
}