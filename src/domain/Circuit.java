package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import application.Strategy;
import domain.result;
public class Circuit {

	protected String circuitName;
	public static float circuitLength;
	public static double circuitTime;
	
	public static List<Rocket> rockets = new ArrayList<Rocket>();;

	public static void print (String string) {
		System.out.println(string);
	}
	
	public Circuit(String circuitName, float distance, double time) throws Exception {
		if(circuitName == null || circuitName.isEmpty()) {
			throw new Exception("The name is not correct");
		}
		if(distance<=0) {
			throw new Exception("The distance cannot under or equal 0");
		}
		if(time<=0) {
			throw new Exception("The time cannot under or equal 0");
		}
		circuitName=circuitName;
		circuitLength=distance;
		circuitTime=time;
	}
	
	public void addRocket(Rocket rocket) throws Exception {
		rockets.add(rocket);
	}

	public static void loopCompetition() {
		
		//List<String> resultNames = new ArrayList<String>();;
		//List<Integer> resultTimes = new ArrayList<Integer>(rockets.size());
		List<result> results = new ArrayList<result>();		
		for (Rocket rocket : rockets) {
			
			float actualSpeed = 0;
			float distance = 0;
			int time = -1;
			float totalAcceleration = 0;
			float fuelTank = rocket.getRocketCapacityTank();
	
			while(time<circuitTime && fuelTank>0 && distance<circuitLength) {
				time++;
	
				totalAcceleration = Strategy.getNextMovement(time);
				actualSpeed = rocket.getPropellers().get(0).getSpeed(actualSpeed, time, totalAcceleration);
				fuelTank = rocket.getTank().instantaneousConsumption(fuelTank, actualSpeed);
	
				if (fuelTank>0)
				distance = rocket.getDistance(actualSpeed, time, totalAcceleration, circuitLength);
	
				
				if(time % 2 == 0 || distance==circuitLength || time==circuitTime) 
				print("Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ circuitLength +" Fuel: "+ fuelTank+"/"+rocket.getRocketCapacityTank());
			}
			if (fuelTank==0 || time>=circuitTime)
				results.add(new result(rocket.getName(), 0));
			else
				results.add(new result(rocket.getName(), time));
		}
		
		results = result.sortList(results);
		print(result.isThereWinner(results) + "Results of the race:");
		for (int i = 0; i< results.size(); i++)
			print((i+1) + ". " + results.get(i).getName() + " with a time of: " +  results.get(0).getTimeString());
	}
	
}