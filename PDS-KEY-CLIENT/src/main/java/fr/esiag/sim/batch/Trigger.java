package fr.esiag.sim.batch;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import fr.esiag.sim.restclient.RestClient;

public class Trigger extends Timer {
	boolean save = false;

	public Trigger(final int hourSave,final int minSave,final int daySave)
	{
		final RestClient test = new RestClient();
		
		TimerTask tt = new TimerTask(){
		
			public void run(){
				System.out.println("Verfication de sauvegarde de base de données");
				Calendar cal = Calendar.getInstance(); 
 
				int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
				int min = cal.get(Calendar.MINUTE);
				
				int day = cal.get(Calendar.DAY_OF_WEEK);
				
				System.out.println("Hour : "+ hour );
				System.out.println("minute : "+ min );
				System.out.println("day : "+ day );
				
				if(hour == hourSave && min==minSave && day == daySave && save == false){
					System.out.println("Sauvegarde des base de données...");
					try{
						test.GetAllTables();;
					}catch(Exception ex)
					{
						System.out.println(ex);
					}
				
					save = true;
				}
				else if (hour == hourSave + 1)
					save = false;
			}
		};
		this.schedule(tt, 1000, 1000*5);//	delay the task 1 second, and then run task every five seconds
	
	}
}

