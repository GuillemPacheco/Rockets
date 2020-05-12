package Domain;

import java.util.List;

public class Propeller{
	
	protected float maximumAcceleration;
	
	public Propeller (float maximumAcceleration) {
		this.maximumAcceleration = maximumAcceleration;
	}
	
	public float getMaximumAcceleration () {
		return this.maximumAcceleration;
	}
	
	public void setMaximumAcceleration(float newMaximumAcceleration) {
		this.maximumAcceleration = newMaximumAcceleration;
	}	

}
