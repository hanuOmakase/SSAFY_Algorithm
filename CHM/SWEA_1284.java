import java.util.Scanner;

public class Solution_SWEA_1284_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int aPrice = P * W;
			int bPrice = (R >= W) ? Q : Q + S * (W - R);
			
			System.out.println("#" + tc + " " + ((aPrice > bPrice) ? bPrice : aPrice));
		}
	}
}
