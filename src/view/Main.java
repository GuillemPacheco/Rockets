package view;


import application.Controller;


public class Main {
		
		public static void main(String[] args) throws Exception {	
			System.out.println("Initializing Rockets... This may take a while");
			Controller controller=new Controller();
			controller.createCircuit();
			System.out.println(controller.startCompetition());
		}

}
