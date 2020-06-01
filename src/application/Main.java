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
			
			// aqui podem afegir tants rockets com volguem
			startCompetition(circuit);
		}

		public static void startCompetition(Circuit circuit) throws Exception {
			if(circuit.rockets.size()==0) {
				throw new Exception("There are 0 created rockets");
			}
			System.out.println("Starting competition. Circuit length: "+Circuit.circuitLength+ " Max time: "+circuit.circuitTime);
			circuit.loopCompetition();
		}
		
		private static List<Propeller> createListPropeller() throws Exception{
			List<Propeller> propellers=new ArrayList<Propeller>();
			propellers.add(new Propeller(50));
			propellers.add(new Propeller(20));
			propellers.add(new Propeller(58));
			return propellers;
		}
		
		private static List<Propeller> createListPropeller2() throws Exception{
			List<Propeller> propellers=new ArrayList<Propeller>();
			propellers.add(new Propeller(30));
			propellers.add(new Propeller(30));
			propellers.add(new Propeller(70));
			return propellers;
		}
		
		public static Rocket createRocket(String nameRocket) throws Exception {
			if(nameRocket.equalsIgnoreCase("Gamma Ray")) {		
				return new Rocket("Gamma Ray",createListPropeller(),new Tank(2500));
			}
			else if(nameRocket.equalsIgnoreCase("Beast")) {
				return new Rocket("Beast",createListPropeller2(),new Tank(3000));
			}
			throw new Exception ("Invalid nameRocket");
			
		}		

}
