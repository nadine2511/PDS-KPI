package fr.esiag.sim.restclient;

import java.io.IOException;

import fr.esiag.sim.batch.Planification;
import fr.esiag.sim.batch.Trigger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Planification task = new Planification();
		try {
			task.getPropValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int Heure = task.getHeurePlanification();
		int Minute = task.getMinutePlanification();
		int day = task.getDayPlanification();
		
		
		Trigger tt = new Trigger(Heure, Minute,day);
		

	}

}
