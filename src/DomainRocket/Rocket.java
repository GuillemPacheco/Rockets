package DomainRocket;

import java.util.List;

import DomainCircuit.Circuit;

public class Rocket {
	
	protected String name;
	protected Circuit circuit;
	protected List<Propeller> propeller;
	
	Rocket(String name,Circuit circuit,List<Propeller> propeller){
		this.name=name;
		this.circuit=circuit;
		propeller = new List<Propeller>();
		propeller.addAll(propeller);
	}
	
	public String getName() {
		return name;
	}
	
}
