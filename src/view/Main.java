package view;


import application.Controller;
import application.ResultController;
import application.ResultDto;
import domain.Circuit;
import domain.Result;


public class Main {
	
		private static ResultController controller = new ResultController();
			
		public static void main(String[] args) throws Exception {	
			Controller controller=new Controller();
			controller.createCircuit();
			System.out.println(controller.getCircuit().getCircuitName());
			startCompetition(controller.getCircuit());
		}

		public static void startCompetition(Circuit circuit) throws Exception {
			if(circuit.rockets.size()==0) {
				throw new Exception("There are 0 created rockets");
			}
			System.out.println("Starting competition.Circuit name:"+circuit.getCircuitName()+" Circuit length: "+circuit.getCircuitLength()+ " Max time: "+circuit.getCircuitTime());
			System.out.println(circuit.loopCompetition());
		}
		
		public static void updateResult(String id,double time, String rocket) throws Exception{
			ResultDto result = new ResultDto(time,rocket);
			result = controller.updateResult(id,result);
			System.out.println(result);
		}
		
		public static void getResult(String id) throws Exception{
			ResultDto resultdto= controller.getResult(id);
			System.out.println(resultdto);
		}
		
		public static ResultDto createResult(Result result) throws Exception {
			ResultDto resultdto = new ResultDto(result);
			resultdto = controller.createResult(resultdto);
			System.out.println(resultdto);
			return resultdto;
		}
		
		

}
