package application;

public class Strategy {

	public static float getNextMovement (int time) {
		switch (time) {
		case 0:
			return 55;
		case 1:
			return 50;
		case 2:
			return 35;
		case 3:
			return 30;
		case 4:
			return 10;
		default:
			return 0;
		}
	}
}