package Domain;

public class Circuit {
	
	protected String circuitName;
	protected float distance;
	protected double time;
	
	public Circuit(String circuitName, float distance, double time) throws Exception {
		if(circuitName == null || circuitName.isEmpty()) {
			throw new Exception("The name is not correct");
		}
		if(distance<=0) {
			throw new Exception("The distance cannot under or equal 0");
		}
		if(time<=0) {
			throw new Exception("The time cannot under or equal 0");
		}
		this.circuitName=circuitName;
		this.distance=distance;
		this.time=time;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public double getTime() {
		return time;
	}
	
	public String getCircuitName() {
		return circuitName;
	}
}
