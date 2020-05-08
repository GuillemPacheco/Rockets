package Domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	protected String name;
	protected Circuit circuit;
	protected List<Propeller> propeller = new ArrayList<Propeller>();
	
	public Rocket(String name,Circuit circuit,List<Propeller> propeller){
		this.name=name;
		this.circuit=circuit;
		propeller.addAll(propeller);
	}

	public String getName() {
		return name;
	}
	
	public String getCircuitName() {
		return circuit.circuitName;
	}
	
	public float getCircuitDistance() {
		return circuit.distance;
	}
	
	public double getCircuitTime() {
		return circuit.time;
	}
	
	
}