package domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	protected Tank tank;
	protected String name;
	protected List<Propeller> propellers = new ArrayList<Propeller>();
	
	public Rocket(String name,List<Propeller> propellers,Tank tank) throws Exception{
		if(name==null) {
			throw new Exception ("Rocket name is null");
		}
		if(tank==null) {
			throw new Exception ("Rocket tank is null");
		}
		this.name=name;
		this.propellers.addAll(propellers);
		this.tank=tank;
	}

	public String getName() {
		return name;
	}

	public float getRocketCapacityTank() {
		return tank.getCapacity();
	}
	
	public List<Propeller> getPropellers (){
		return this.propellers;
	}
	
	
	public float getTotalAcceleration (float input) throws Exception {
		if(input<0) {
			throw new Exception ("The input is lower than 0");
		}
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