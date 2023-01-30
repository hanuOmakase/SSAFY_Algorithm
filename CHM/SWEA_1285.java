import java.util.Scanner;

public class Solution_SWEA_1285_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			
			int min = 100000;
			int count = 0;
			for (int i = 0; i < N; i++) {
				int dist = Math.abs(sc.nextInt());
				if (dist < min) {
					min = dist;
					count = 1;
				} else if (dist == min) {
					count++;
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, min, count);
		}
	}
}
