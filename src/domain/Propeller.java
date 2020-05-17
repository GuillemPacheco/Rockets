package domain;

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
	
	public float getSpeed (float lastSpeed, float time, float acceleration) {
		return  (float) (lastSpeed + (time*acceleration));
	}
}
