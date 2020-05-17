package domain;

public class Tank {
	
	protected float capacity;
	protected float currentGasoline;
	
	public Tank (float capacity) {
		this.capacity = capacity;
		currentGasoline = capacity; // Starts full;
	}
	
	public float getCapacity () {
		return capacity;
	}
	
	public float getCurrentGasoline () {
		return currentGasoline;
	}
	
	public void updateCurrentGasoline (float newGasolineValue) {
		currentGasoline = newGasolineValue;
	}
	
	public float instantaneousConsumption (float currentDeposit, float speed) {
		float instantaneousConsumed = (float) (0.02 * Math.pow(speed, 2));
		float currentTankSpace = currentDeposit-instantaneousConsumed;
		if (currentTankSpace>0) {
			return currentTankSpace;
		}
		return 0;
	}
	
}