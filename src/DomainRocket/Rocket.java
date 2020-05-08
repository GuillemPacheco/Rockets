package DomainRocket;

import DomainCircuit.AbsCircuit;

public class Rocket {
	
	protected String name;
	protected AbsCircuit circuit;
	protected Propeller propeller;
	
	Rocket(String name,AbsCircuit circuit,Propeller propeller){
		this.name=name;
		this.circuit=circuit;
		this.propeller=propeller;	
	}
	
	public String getName() {
		return name;
	}
	
}
