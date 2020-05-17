package application;

public class Strategy {

	public Strategy() {
		
	}
	public static void hello () {
		System.out.println("HELLOO");
	}
	public static float getNextMovement (int time) {
		switch (time) {
		case 0:
			return 45;
		case 1:
			return 40;
		case 2:
			return 30;
		case 3:
			return 30;
		case 4:
			return 20;
		case 5:
			return 10;
		}
	return 0;
	}
}