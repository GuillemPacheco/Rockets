package application;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import domain.Propeller;
import domain.Rocket;
import domain.Tank;

public class RocketDto {

	protected String name;
	private List<Propeller> propellers = new ArrayList<Propeller>();
	private Tank tank;
	private float actualSpeed;
	private float distance;
	private int time;
	private float totalAcceleration;
	
	public RocketDto(Rocket rocket) throws Exception{
		if(rocket==null)
			throw new InvalidParameterException("The name is not correct");
		this.name=rocket.getName();
		this.propellers.addAll(rocket.getPropellers());
		this.tank=rocket.getTank();
		this.actualSpeed=0;
		this.distance=0;
		this.time=0;
		this.totalAcceleration=0;
	}
	
	public List<Propeller> getPropellers() {
		return propellers;
	}

	public Tank getTank() {
		return tank;
	}

	public float getActualSpeed() {
		return actualSpeed;
	}

	public float getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}

	public float getTotalAcceleration() {
		return totalAcceleration;
	}

	public String getName() {
		return this.name;
	}
	
}
