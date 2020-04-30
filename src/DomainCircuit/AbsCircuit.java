package DomainCircuit;

public abstract class AbsCircuit {
	
	protected String circuitName;
	protected float distance;
	protected double time;
	
	public AbsCircuit(String circuitName, float distance, double time) throws Exception {
		if(circuitName == null || circuitName.isEmpty()) {
			
		}
	}
}
