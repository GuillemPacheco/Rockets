package domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import application.Strategy;

public class Rocket {
	
	protected Tank tank;
	protected String name;
	protected List<Propeller> propellers = new ArrayList<Propeller>();
	
	public float actualSpeed;
	public float distance;
	public int time;
	public float totalAcceleration;
	public float fuelTank;
	
	// Constructors
	public Rocket(String name,List<Propeller> propellers,Tank tank) throws Exception{
		if(name==null)
			throw new InvalidParameterException ("Rocket name is null");
		if(tank==null)
			throw new InvalidParameterException ("Rocket tank is null");
		this.name=name;
		this.propellers.addAll(propellers);
		this.tank=tank;
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
	public float getFuelTank () {
		return fuelTank;
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
	public void resetRocket () {
		actualSpeed = 0;
		distance = 0;
		time = -1;
		totalAcceleration = 0;
		fuelTank = getRocketCapacityTank();
	}
	
	public String updateValues (float circuitLength) throws Exception {
		totalAcceleration = getTotalAcceleration(Strategy.getNextMovement(time)); // TO GET THE MAXIMUM ACCELERATION OF THE PROPELLERS
		actualSpeed = getSpeed(actualSpeed, time, totalAcceleration);
		fuelTank = getTank().instantaneousConsumption(fuelTank, actualSpeed);
		time++;
		if (fuelTank>0)
			distance = getDistance(actualSpeed, time, totalAcceleration, circuitLength);
		if(time % 2 == 0) 
			return "\n"+"Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ circuitLength +" Fuel: "+ fuelTank+"/" +getRocketCapacityTank();
		return "";
	}


}