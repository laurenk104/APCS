package Github;

public class Intro {

	public static void main(String[] args) {
		System.out.println(coins(16));

	}
	
	public static int ret() {
		return 17;
	}
	
	public static boolean logic(boolean a, boolean b, boolean c) {
		return a && b && c;
	}
	
	public static String stars(int n) {
		String triangle = "";
		for (int column = 0; column < n; column++) {
			for (int row = 0; row <= column; row++) {
				triangle += "*";
			} triangle += "\n";
		} return triangle;

	}
	
	public static String coins(int n) {
		int five = Math.floorDiv(n, 5);
		int remainder = n - five*5;
		if (remainder % 2 == 0) {
			int two = remainder/2;
			return five + " 5c and " + two + " 2c";
		} else if (n % 2 == 0) {
			if (n < 10) {
				return "0 5c and " + n/2 + " 2c";
			} else {
				int Five = (n-(n % 10)) / 5;
				int two = (n % 10) / 2;
				return Five + " 5c and " + two + " 2c";
			}
		}
		else {
			return "-1";
		}
	}




}
