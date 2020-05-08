package View;

import Application.Controller;
import Utilities.ConstantUtilities;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		controller.createRocket(ConstantUtilities.ROCKET);
		controller.startCompetition();
	}

}
