package Domain;

import java.util.List;

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
