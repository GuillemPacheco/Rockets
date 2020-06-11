package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Circuit;
import domain.Propeller;
import domain.Rocket;
import domain.Tank;



public class Factory {
	
	public static ArrayList<Rocket> createRockets() throws Exception {
		ArrayList<Rocket> listRockets=new ArrayList<Rocket>();
		Rocket rocket=new Rocket("Viper X",createListPropeller(new int[]{40,50,20,38}),new Tank(2500));
		Rocket rocket2=new Rocket("Star V",createListPropeller(new int[]{30,18,24,38}),new Tank(2800));
		Rocket rocket3=new Rocket("Falcon IX",createListPropeller(new int[]{40,29,60}),new Tank(1900));
		Rocket rocket4=new Rocket("Speedy V",createListPropeller(new int[]{10,3,20,82}),new Tank(2200));
		listRockets.add(rocket);
		listRockets.add(rocket2);
		listRockets.add(rocket3);
		listRockets.add(rocket4);
		return listRockets;
	}
	
	public static Circuit selectRandomCircuit() throws Exception {
		Random random=new Random();
		int randomNumber=random.nextInt(4)+1;
		switch(randomNumber) {
			case(1):
				return new Circuit("MadMax",1300,22);
			case(2):
				return new Circuit("SpeedTrack",800,10);
			case(3):
				return new Circuit("FreeWorld",1200,18);
			case(4):
				return new Circuit("RisingLap",900,15);
			default:
				throw new Exception("Can't select a random circuit");
		}
	}
	
	private static List<Propeller> createListPropeller(int[] maxAccelerations) throws Exception{
		if(maxAccelerations.length==0) {
			throw new Exception("The propellers are null");
		}
		List<Propeller> propellers=new ArrayList<Propeller>();
		for (int acceleration : maxAccelerations)
			propellers.add(new Propeller(acceleration));
		return propellers;
	}
	
	
}