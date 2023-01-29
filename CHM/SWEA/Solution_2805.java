package swea.D3;

import java.util.Scanner;

public class Solution_2805 { // 2805. 농작물 수확하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = input.charAt(j) - '0';
				}
			}
			
			int profit = 0;
			for (int i = 0; i < N; i++) {
				int jIndex = Math.abs((N / 2) - i);
				for (int j = jIndex; j < Math.abs(N - jIndex); j++) {
					profit += farm[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + profit);
		} // end of for testCase
		
	}
}
