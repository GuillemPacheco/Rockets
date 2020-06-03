package application;

public class Strategy {

	public static float getNextMovement (int time) {
		switch (time) {
		case 0:
			return 18;
		case 1:
			return 15;
		case 2:
			return 12;
		case 3:
			return 10;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		default:
			return 0;
		}
	}
}