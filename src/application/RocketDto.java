package application;

import java.security.InvalidParameterException;

import domain.Rocket;

public class RocketDto {

	protected String name;
	
	public RocketDto(String name) {
		this.name=name;
	}
	
	public RocketDto(Rocket rocket) throws Exception{
		if(rocket.getName() == null || rocket.getName().equals(""))
			throw new InvalidParameterException("The name is not correct");
		this.name=rocket.getName();
	}
	
	public String getName() {
		return this.name;
	}
	
}
