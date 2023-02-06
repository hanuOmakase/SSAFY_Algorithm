import java.util.Scanner;

public class Solution_SWEA_1940_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int moved = 0;
			int speed = 0;
			
			for (int i = 0; i < N; i++) {
				int stat = sc.nextInt();
				switch (stat) {
				case 1: // 가속
					speed += sc.nextInt();
					break;
				case 2: // 감속
					speed -= sc.nextInt();
					if (speed < 0) { speed = 0; }
					break;
				}
				moved += speed;
			}
			
			System.out.println("#" + tc + " " + moved);
		} // end of for testCase
	}
}
