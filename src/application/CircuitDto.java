package application;

import java.security.InvalidParameterException;

import domain.Circuit;

public class CircuitDto {
	
	protected String circuitName;
	public static float circuitLength;
	public static int circuitTime;
	
	public CircuitDto(float distance, int time) {
		circuitLength=distance;
		circuitTime=time;
	}
	
	public CircuitDto(Circuit circuit) throws Exception {
		if(circuit==null)
			throw new Exception();
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


	public int getCircuitTime() throws InvalidParameterException{
		if(circuitTime<0)
			throw new InvalidParameterException();
		return circuitTime;
	}
	
	public String toString() {
		return "Circuit name:"+ circuitName+ " length:"+ circuitLength+ " time:"+ circuitTime;
	}
}
