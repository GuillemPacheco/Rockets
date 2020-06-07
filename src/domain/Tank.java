package domain;

public class Tank {
	
	protected float capacity;
	protected float currentGasoline;
	
	public Tank (float capacity) throws Exception {
		if(capacity<0)
			throw new Exception ("The capacity is lower than 0");
		this.capacity = capacity;
		currentGasoline = capacity; // Starts full;
	}
	
	public float getCapacity () {
		return capacity;
	}
	
	public float getCurrentGasoline () {
		return currentGasoline;
	}
	
	public void updateCurrentGasoline (float newGasolineValue) throws Exception {
		if(newGasolineValue<0)
			throw new Exception ("New Gasoline Value is lower than 0");
		currentGasoline = newGasolineValue;
	}
	
	public float instantaneousConsumption (float currentDeposit, float speed) throws Exception {
		if(currentDeposit<0)
			throw new Exception ("The current deposit is lower than 0");
		if(speed<0)
			throw new Exception ("Speed is lower than 0");
		float instantaneousConsumed = (float) (0.02 * Math.pow(speed, 2));
		float currentTankSpace = currentDeposit-instantaneousConsumed;
		if (currentTankSpace>0)
			return currentTankSpace;
		return 0;
	}
	
}