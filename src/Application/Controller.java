package Application;

import java.util.Scanner;

import Domain.Propeller;
import Domain.Rocket;

public class Controller {
	
		private static Rocket rocket;
		static Scanner keyIn = new Scanner(System.in);

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

			float actualSpeed = 0;
			float distance=0;
			float time=0;
			float totalAcceleration=0;
			float fuelTank=rocket.getRocketCapacityTank();
			
			while(time<=rocket.getCircuitTime()) {
				
				totalAcceleration = controlMovements(rocket);
				actualSpeed = getSpeed(actualSpeed, time, totalAcceleration);
				distance = getDistance(actualSpeed, time, totalAcceleration);
				fuelTank -= instantaneousConsumption(actualSpeed);
				if(time % 2 == 0) {
				System.out.println("Current Time : "+ time + " Acceleration: "+ totalAcceleration + " Speed: "+ actualSpeed+ " Distance: " +distance+ " Circuit: "+ rocket.getCircuitDistance() +" Fuel: "+ fuelTank+"/"+rocket.getRocketCapacityTank());
				}
				time++;
				
				if (fuelTank<0) {
					System.out.println("Runned out of fuel.");
					break;
				}
				if(distance>=rocket.getCircuitDistance()) {
					System.out.println("Circuit finished with Time : "+ time + " Final Acceleration: "+ totalAcceleration + " Final Speed: "+actualSpeed + " Final Fuel: " + fuelTank + "/" + rocket.getRocketCapacityTank());
					break;
				}
			}
			if(distance>=rocket.getCircuitDistance() && fuelTank>0) {
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
			System.out.println("What is your next acceleration? (Between 0 and " + maximumNumber + ")");
			float nextacceleration = keyIn.nextFloat();
			while (nextacceleration<=0 || nextacceleration>maximumNumber) {
				System.out.println("Invalid number. Please write again the acceleration. (Between 0 and " + maximumNumber + ")");
				nextacceleration = keyIn.nextFloat();
			}
			return getTotalAcceleration(r,nextacceleration);
		}
		
		private float getDistance (float actualSpeed, float time, float acceleration) {
			return  (float) ((actualSpeed * time) + (1/2 * acceleration) * Math.pow(time, 2));
		}
		private float getSpeed (float lastSpeed, float time, float acceleration) {
			return  (float) (lastSpeed + (time*acceleration));
		}
		private float instantaneousConsumption (float speed) {
			return (float) (0.02 * Math.pow(speed, 2));
		}
}
