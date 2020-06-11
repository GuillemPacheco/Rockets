package view;
import application.Controller;


public class Main {
		
	private static int loadingProgress = 0;
	
		public static void main(String[] args) throws Exception {	
			System.out.println("Initializing Rockets... This may take a while... (Generating around 200 Milion possible combinations)");
			updateProgress();
			Controller controller=new Controller();
			controller.createCircuit();
			System.out.println(controller.startCompetition());
		}    
		
		public static void updateProgress () {
			loadingProgress++;
			String ldStr = "";
			switch (loadingProgress) {
			case 1: ldStr = "[----------] 0%"; break;
			case 2: ldStr = "[**--------] 25%"; break;
			case 3: ldStr = "[*****-----] 50%"; break;
			case 4: ldStr = "[*******---] 75%"; break;
			case 5: ldStr = "[**********] 100% \n\nRockets Inicialized. Starting competition...\n"; break;				
			}
			System.out.println(ldStr);
		}

}
