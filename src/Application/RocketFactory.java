package Application;

import DomainCircuit.Circuit;
import DomainRocket.Rocket;
import Utilities.ConstantUtilities;

public class RocketFactory {
	
	public static Rocket createRocket(int rocketId) throws Exception {
		if(rocketId==ConstantUtilities.ROCKET) {
			return new Rocket("Gamma Ray",new Circuit("RisingLap",900,15),);
		}
		
		throw new Exception ("Invalid rocketID");
		
	}
}
