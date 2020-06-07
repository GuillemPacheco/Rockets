package domain;

public class Propeller{
	
	protected float maximumAcceleration;
	
	public Propeller (float maximumAcceleration) throws Exception {
		if(maximumAcceleration<0)
			throw new Exception ("The acceleration can be negative");
		this.maximumAcceleration = maximumAcceleration;
	}
	
	public float getMaximumAcceleration () {
		return this.maximumAcceleration;
	}
	
	public void setMaximumAcceleration(float newMaximumAcceleration) throws Exception {
		if(newMaximumAcceleration<0)
			throw new Exception ("The acceleration can be negative");
		this.maximumAcceleration = newMaximumAcceleration;
	}	
}
