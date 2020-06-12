package application;


import application.dto.ResultDto;
import domain.Circuit;
import domain.Result;
import domain.Rocket;
import domain.Strategy;
import utilities.IObserver;

public class RaceController{
	
	private  Circuit circuit;
	private static ResultController controller = new ResultController();
	

	 
	public void createCircuit(IObserver observer) throws Exception {
		this.circuit = (Factory.selectRandomCircuit());
		this.circuit.addRocket(Factory.createRockets());
		for (Rocket r : this.circuit.getRockets())
			r.setStrategy(new Strategy(r, this.circuit,observer));
	}
	
	public  String startCompetition() throws Exception {
		String startCompetition="";
		if(circuit.getRockets().size()==0)
			throw new Exception("There are 0 created rockets");
		
		startCompetition+="Circuit name: "+circuit.getCircuitName()+", Circuit length: "+circuit.getCircuitLength()+ ", Max time: "+circuit.getCircuitTime();
		startCompetition+=circuit.loopCompetition();
		return startCompetition;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public static void updateResult(String id,int time, String rocket) throws Exception{
		ResultDto result = new ResultDto(time,rocket);
		result = controller.updateResult(id,result);
	}
	
	public static void getResult(String id) throws Exception{
		ResultDto resultdto= controller.getResult(id);
	}
	
	public static ResultDto createResult(Result result) throws Exception {
		ResultDto resultdto = new ResultDto(result);
		resultdto = controller.createResult(resultdto);
		return resultdto;
	}
}
