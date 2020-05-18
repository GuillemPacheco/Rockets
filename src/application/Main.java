package application;

import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	
		private Rocket rocket;
		
		public void print (String string) {
			System.out.println(string);
		}
		
		public void createRocket(int rocketId) throws Exception {
			Rocket rocket= RocketFactory.createRocket(rocketId);
			this.rocket=rocket;
		}

		public void startCompetition() throws Exception {
			if(rocket==null) {
				throw new Exception("The rocket is not initialized");
			}
			print("Starting competition. Circuit length: "+rocket.getCircuitDistance()+ " Max time: "+rocket.getCircuitTime());
			loopCompetition();
		}
		
		private void loopCompetition() {

			float actualSpeed = 0;
			float distance = 0;
			int time = -1;
			float totalAcceleration = 0;
			float fuelTank = rocket.getRocketCapacityTank();

			while(time<rocket.getCircuitTime() && fuelTank>0 && distance<rocket.getCircuitDistance()) {
				time++;

				totalAcceleration = Strategy.getNextMovement(time);
				actualSpeed = rocket.getPropellers().get(0).getSpeed(actualSpeed, time, totalAcceleration);
				fuelTank = rocket.getTank().instantaneousConsumption(fuelTank, actualSpeed);

				if (fuelTank>0)
				distance = rocket.getDistance(actualSpeed, time, totalAcceleration, rocket.getCircuitDistance());

				
				if(time % 2 == 0 || distance==rocket.getCircuitDistance() || time==rocket.getCircuitTime()) 
				print("Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ rocket.getCircuitDistance() +" Fuel: "+ fuelTank+"/"+rocket.getRocketCapacityTank());
			}
			
			if (fuelTank==0 || time>=rocket.getCircuitTime()) 
				print("There is no winner");
			else
				print("And the winner is: "+rocket.getName()+ " with a time of "+time);
		}
		
		public static void main(String[] args) throws Exception {
			Main controller = new Main();			
			controller.createRocket(ConstantUtilities.ROCKET);
			controller.startCompetition();
		}
}
