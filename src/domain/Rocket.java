package domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	private Tank tank;
	private String name;
	private List<Propeller> propellers = new ArrayList<Propeller>();
	private float actualSpeed;
	private float distance;
	private int time;
	private float totalAcceleration;
	
	public Strategy myStrategy;
	
	// Constructors
	public Rocket(String name,List<Propeller> propellers,Tank tank) throws Exception{
		if(name==null)
			throw new InvalidParameterException ("Rocket name is null");
		if(tank==null)
			throw new InvalidParameterException ("Rocket tank is null");
		this.name=name;
		this.propellers.addAll(propellers);
		this.tank=tank;
		this.actualSpeed=0;
		this.distance=0;
		this.time=0;
		this.totalAcceleration=0;
	}
	
	// Getters
	public float getActualSpeed () {
		return actualSpeed;
	}
	public float getSpeed (float lastSpeed, int time, float totalAcceleration) {
		return  (float) (lastSpeed + (time*totalAcceleration));
	}
	public float getDistance () {
		return distance;
	}
	public int getTime () {
		return time;
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
		if(input<0)
			throw new Exception ("The input is lower than 0");
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
	
	// Other methods
	public void setStrategy (Strategy s) {
		myStrategy = s;
	}
	public void resetRocket () throws Exception {
		tank.currentGasoline = tank.getCapacity();
		actualSpeed = 0;
		distance = 0;
		time = 0;
		totalAcceleration = 0;
	}
	
	public String updateValues (float circuitLength) throws Exception {
		totalAcceleration = getTotalAcceleration(myStrategy.bestStrategy.get(time)); // TO GET THE MAXIMUM ACCELERATION OF THE PROPELLERS
		actualSpeed = getSpeed(actualSpeed, time, totalAcceleration);
		tank.updateCurrentGasoline(tank.instantaneousConsumption(tank.currentGasoline, actualSpeed));
		time++;
		if (tank.currentGasoline>0)
			distance = getDistance(actualSpeed, time, totalAcceleration, circuitLength);
		if(time % 2 == 0 || distance == circuitLength || tank.currentGasoline == 0) 
			return "\n"+"Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ circuitLength +" Fuel: "+ tank.currentGasoline+"/" +getRocketCapacityTank();
		return "";
	}
	
	public void updateValues (float circuitLength, List<Integer> strategy) throws Exception {
		totalAcceleration = getTotalAcceleration(strategy.get(time)); // TO GET THE MAXIMUM ACCELERATION OF THE PROPELLERS
		actualSpeed = getSpeed(actualSpeed, time, totalAcceleration);
		tank.updateCurrentGasoline(tank.instantaneousConsumption(tank.currentGasoline, actualSpeed));
		time++;

		if (tank.currentGasoline>0)
			distance = getDistance(actualSpeed, time, totalAcceleration, circuitLength);
}

}