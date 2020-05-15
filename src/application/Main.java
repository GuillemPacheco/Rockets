package application;

import java.util.Scanner;

import domain.Circuit;
import domain.Propeller;
import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	
		private static Rocket rocket;
		static Scanner keyIn = new Scanner(System.in);

		public void createRocket(int rocketId)throws Exception {
			Rocket rocket= RocketFactory.createRocket(rocketId);
			addRocket(rocket);
		}
		
		public void addRocket(Rocket rocket) {
			this.rocket=rocket;
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

			float actualSpeed = 0;
			float distance=0;
			float time=0;
			float totalAcceleration=0;
			float fuelTank=rocket.getRocketCapacityTank();
			
			while(time<=rocket.getCircuitTime()) {
				
				totalAcceleration = controlMovements(rocket);
				actualSpeed = rocket.getPropellers().get(0).getSpeed(actualSpeed, time, totalAcceleration);

				fuelTank -= rocket.getTank().instantaneousConsumption(actualSpeed);
				if(fuelTank<0) {
					fuelTank=0;
					actualSpeed=0;
				}
				distance = getDistance(actualSpeed, time, totalAcceleration);
				if(time % 2 == 0 && time !=0) {
					System.out.println("Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ rocket.getCircuitDistance() +" Fuel: "+ fuelTank+"/"+rocket.getRocketCapacityTank());
				}
				if(distance>=rocket.getCircuitDistance()) {
					System.out.println("Circuit finished with Time : "+ time + " Final Acceleration: "+ totalAcceleration + " Final Speed: "+actualSpeed + " Final Fuel: " + fuelTank + "/" + rocket.getRocketCapacityTank());
					break;
				}
				time++;
			}
			if(distance>=rocket.getCircuitDistance()) {
				System.out.println("And the winner is: "+rocket.getName()+ " with a time of "+time);
			}else {
				System.out.println("There is no winner");
			}
		}
		
		private float getTotalAcceleration (Rocket r, float input) {
			float result = 0;
			for (Propeller p : r.getPropellers()){
				if (p.getMaximumAcceleration()>=input)
					result+=input;
				else
					result+=p.getMaximumAcceleration();
			}
			return result;
		}
		
		private float controlMovements (Rocket r) {
			float maximumNumber = 0;
			for (Propeller p : r.getPropellers()){
				if (p.getMaximumAcceleration()>maximumNumber)
					maximumNumber = p.getMaximumAcceleration();
			}
			//Aqui hauria d anar implementació de ia
			float nextacceleration = 58;
			while (nextacceleration<0 || nextacceleration>maximumNumber) {
				System.out.println("Invalid number. Please write again the acceleration. (Between 0 and " + maximumNumber + ")");
				nextacceleration = keyIn.nextFloat();
			}
			return getTotalAcceleration(r,nextacceleration);
		}
		
		private float getDistance (float actualSpeed, float time, float acceleration) {
			return  (float) ((actualSpeed * time) + (1/2 * acceleration) * Math.pow(time, 2));
		}
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			Main controller = new Main();
			controller.createRocket(ConstantUtilities.ROCKET);
			controller.startCompetition();
		}

		
	
}
