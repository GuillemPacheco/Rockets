package domain;

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
	
	
	public float getTotalAcceleration (float input) {
		float result = 0;
		for (Propeller p : this.getPropellers()){
			if (p.getMaximumAcceleration()>=input)
				result+=input;
			else
				result+=p.getMaximumAcceleration();
		}
		return result;
	}
	
	public Tank getTank() {
		return tank;
	}
	
	public float getDistance (float actualSpeed, float time, float acceleration, float maxDistance) {
		float result = (float) ((actualSpeed * time) + (1/2 * acceleration) * Math.pow(time, 2));
		if (result>maxDistance)
			return maxDistance;
		return result;
	}
}