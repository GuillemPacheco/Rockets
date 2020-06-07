package application;


import java.util.ArrayList;
import java.util.List;

import domain.Circuit;
import domain.Propeller;
import domain.Rocket;
import domain.Tank;

public class Main {
			
		public static void main(String[] args) throws Exception {	
			Circuit circuit = new Circuit("RisingLap",900,15);
			circuit.addRocket(createRocket("Gamma Ray"));
			circuit.addRocket(createRocket("Beast"));
			
			// We can add as many rockets as we want
			startCompetition(circuit);
		}

		public static void startCompetition(Circuit circuit) throws Exception {
			if(circuit.rockets.size()==0) {
				throw new Exception("There are 0 created rockets");
			}
			System.out.println("Starting competition. Circuit length: "+Circuit.circuitLength+ " Max time: "+circuit.circuitTime);
			System.out.println(circuit.loopCompetition());
		}
		
		private static List<Propeller> createListPropeller(int[] maxAccelerations) throws Exception{
			List<Propeller> propellers=new ArrayList<Propeller>();
			for (int acceleration : maxAccelerations)
				propellers.add(new Propeller(acceleration));
			return propellers;
		}
		
		public static Rocket createRocket(String nameRocket) throws Exception {
			if(nameRocket.equalsIgnoreCase("Gamma Ray")) {		
				int[] maxAccelerations = {50,20,58};
				return new Rocket("Gamma Ray",createListPropeller(maxAccelerations),new Tank(2500));
			}
			else if(nameRocket.equalsIgnoreCase("Beast")) {
				int[] maxAccelerations = {3,3,7};
				return new Rocket("Beast",createListPropeller(maxAccelerations),new Tank(3000));
			}
			throw new Exception ("Invalid nameRocket");
			
		}		

}
