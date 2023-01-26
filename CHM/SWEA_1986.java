import java.util.Scanner;

public class Solution_SWEA_1986_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			
			if (N % 2 == 0) {
				System.out.println("#" + tc + " " + -(N / 2));
			} else {
				System.out.println("#" + tc + " " + (1 + N / 2));
			}
		}
	}
}
