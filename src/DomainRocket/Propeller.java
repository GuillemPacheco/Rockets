package DomainRocket;

import java.util.List;

import DomainCircuit.Circuit;

public class Propeller{
	
	protected float maximumSpeed;
	
	public Propeller (float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	
	public float getMaximumSpeed () {
		return this.maximumSpeed;
	}
	
	public void setMaximumSpeed (float newMaximumSpeed) {
		this.maximumSpeed = newMaximumSpeed;
	}	
	

	


}
