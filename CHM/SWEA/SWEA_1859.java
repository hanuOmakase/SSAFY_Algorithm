import java.util.Scanner;

public class Solution_SWEA_1859_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int[] prices = new int[N];
			long profit = 0; // long
			
			for (int i = 0; i < N; i++) {
				prices[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i = prices.length - 1; i >= 0 ; i--) {
				if (prices[i] > max) { 
					max = prices[i]; 
				} else {
					profit += max - prices[i];
				}
			}
			
			System.out.println("#" + tc + " " + profit);
		} // end of for testCase
	}
}
