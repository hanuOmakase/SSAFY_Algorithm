package swea.D2;

import java.util.Scanner;

public class Solution_2001 { // 2001 파리 퇴치
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt(); // 2 이상
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					
					for (int r = 0; r < M; r++) { // M*M
						for (int c = 0; c < M; c++) {
							sum += arr[i + r][j + c];
						}
					}
					
					if (sum > max) { max = sum; }
	
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
		} // end of for testCase
	}
}
