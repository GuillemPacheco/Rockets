package application;
import utilities.ConstantUtilities;
import domain.Circuit;

public class Main {
			
		public static void main(String[] args) throws Exception {
			Main controller = new Main();		
			Circuit circuit = new Circuit("RisingLap",900,15);
			circuit.addRocket(RocketFactory.createRocket(ConstantUtilities.ROCKET));
			
			// aqui podem afegir tants rockets com volguem
			controller.startCompetition(circuit);
		}

		public void startCompetition(Circuit circuit) throws Exception {
			if(circuit.rockets.size()==0) {
				throw new Exception("There are 0 created rockets");
			}
			System.out.println("Starting competition. Circuit length: "+circuit.circuitLength+ " Max time: "+circuit.circuitTime);
			Circuit.loopCompetition();
		}
		
		

}
