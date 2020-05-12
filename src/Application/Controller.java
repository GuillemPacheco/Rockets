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
			loopCompetition();
		}
		
		private void loopCompetition() {
			float distance=0;
			float time=0;
			float totalAccelaration=0;
			float fuelTank=rocket.getRocketCapacityTank();
			while(time<=rocket.getCircuitTime()) {
				if(time % 2 == 0 && time !=0) {
				System.out.println("Current Time : "+ time + " Acceleration: "+ "" + "Speed: "+"" + "Distance: " +distance+ " Circuit: "+ rocket.getCircuitDistance() +" Fuel: "+ fuelTank+"/"+rocket.getRocketCapacityTank());}
				time++;
				if(distance==rocket.getCircuitDistance()) {
					System.out.println("Current Time : "+ time + " Acceleration: "+ "" + "Speed: "+"" + "Distance: " +distance+ " Circuit: "+ rocket.getCircuitDistance() +" Fuel: "+ "/"+rocket.getRocketCapacityTank());
					break;
				}
			}
			if(distance==rocket.getCircuitDistance()) {
				System.out.println("And the winner is: "+rocket.getName()+ " with a time of "+time);
			}else {
				System.out.println("There is no winner");
			}
		}
}
