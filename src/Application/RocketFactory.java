package Application;

import java.util.ArrayList;
import java.util.List;

import Domain.Circuit;
import Domain.Propeller;
import Domain.Rocket;
import Domain.Tank;
import Utilities.ConstantUtilities;

public class RocketFactory {
	
	public static Rocket createRocket(int rocketId) throws Exception {
		if(rocketId==ConstantUtilities.ROCKET) {		
			return new Rocket("Gamma Ray",new Circuit("RisingLap",900,15),createListPropeller(),new Tank(2500));
		}
		
		throw new Exception ("Invalid rocketID");
		
	}
	
	private static List<Propeller> createListPropeller(){
		List<Propeller> propellers=new ArrayList<Propeller>();
		propellers.add(new Propeller(50));
		propellers.add(new Propeller(20));
		propellers.add(new Propeller(58));
		return propellers;
	}
}
