package view;


import application.Controller;
import domain.Circuit;


public class Main {
			
		public static void main(String[] args) throws Exception {	
			Controller controller=new Controller();
			controller.createCircuit();
			startCompetition(controller.getCircuit());
		}

		public static void startCompetition(Circuit circuit) throws Exception {
			if(circuit.rockets.size()==0) {
				throw new Exception("There are 0 created rockets");
			}
			System.out.println("Starting competition. Circuit length: "+Circuit.circuitLength+ " Max time: "+circuit.circuitTime);
			System.out.println(circuit.loopCompetition());
		}
		
		

}
