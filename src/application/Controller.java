package application;

import domain.Circuit;

public class Controller {
	
	private Circuit circuit;
	
	public void createCircuit() throws Exception {
		this.setCircuit(Factory.selectRandomCircuit());
		this.circuit.addRocket(Factory.createRockets());
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	
	
	
	
}
