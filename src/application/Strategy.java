package application;

public class Strategy {

	public static float getNextMovement (int time) {
		switch (time) {
		case 0:
			return 5;
		case 1:
			return 10;
		case 2:
			return 5;
		case 3:
			return 10;
		case 4:
			return 5;
		case 5:
			return 5;
		case 6:
			return 5;
		default:
			return 0;
		}
	}
}