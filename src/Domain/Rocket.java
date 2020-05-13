package Domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	protected Tank tank;
	protected String name;
	protected Circuit circuit;
	protected List<Propeller> propellers = new ArrayList<Propeller>();
	
	public Rocket(String name,Circuit circuit,List<Propeller> propellers,Tank tank){
		this.name=name;
		this.circuit=circuit;
		this.propellers.addAll(propellers);
		this.tank=tank;
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
	
	public float getRocketCapacityTank() {
		return tank.getCapacity();
	}
	
	public List<Propeller> getPropellers (){
		return this.propellers;
	}
	
	public float getTotalRocketAcceleration() {
		float totalRocketAcceleration=0;
		for(Propeller propeller: propellers) {
			totalRocketAcceleration+=propeller.getMaximumAcceleration();
		}
		return totalRocketAcceleration;
	}
	
	
}