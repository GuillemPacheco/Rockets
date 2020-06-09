package application;

import java.security.InvalidParameterException;

import domain.Circuit;

public class CircuitDto {
	
	protected String circuitName;
	public static float circuitLength;
	public static double circuitTime;
	
	public CircuitDto(Circuit circuit) throws Exception {
		
		if(circuitName == null || circuitName.isEmpty())
			throw new InvalidParameterException("The name is not correct");
		if(circuit.getCircuitLength()<=0)
			throw new InvalidParameterException("The distance cannot under or equal 0");
		if(circuit.getCircuitTime()<=0)
			throw new InvalidParameterException("The time cannot under or equal 0");
		this.circuitName=circuit.getCircuitName();
		circuitLength=circuit.getCircuitLength();
		circuitTime=circuit.getCircuitTime();
	}
	
	public String getCircuitName() throws InvalidParameterException{
		if(circuitName.equals(""))
			throw new InvalidParameterException();
		return circuitName;
	}


	public float getCircuitLength() throws InvalidParameterException{
		if(circuitLength<=0)
			throw new InvalidParameterException();
		return circuitLength;
	}


	public double getCircuitTime() throws InvalidParameterException{
		if(circuitTime<0)
			throw new InvalidParameterException();
		return circuitTime;
	}
	
	public String toString() {
		return "Circuit name:"+ circuitName+ " length:"+ circuitLength+ " time:"+ circuitTime;
	}
}
