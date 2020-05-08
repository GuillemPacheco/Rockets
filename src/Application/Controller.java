package Application;

import java.util.ArrayList;
import java.util.List;

import Domain.Rocket;

public class Controller {
	
		private static Rocket rocket;
		
		public void createRocket(int rocketId)throws Exception {
			Rocket rocket= RocketFactory.createRocket(rocketId);
			addRocket(rocket);
		}
		
		private void addRocket(Rocket rocket) {
			this.rocket=rocket;
		}
		
		Rocket getRockets(){
			return rocket;
		}
		
		public String printRocket() {
			return rocket.getName();
		}

		public void startCompetition() throws Exception {
			// TODO Auto-generated method stub
			if(rocket==null) {
				throw new Exception("The rocket is not initialize");
			}
			
			System.out.println("Starting competition. Circuit length: "+rocket.getCircuitDistance()+ " Max time: "+rocket.getCircuitTime());
			
		}
}
