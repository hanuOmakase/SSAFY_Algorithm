package swea.D3;

import java.util.Scanner;

public class Solution_7236 { // 7236. 저수지의 물의 총 깊이 구하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] row = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			String[][] dam = new String[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dam[i][j] = sc.next();
				}
			}
			
			int deepest = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int water = 0;
					if (dam[i][j].equals("W")) {
						for (int k = 0; k < row.length; k++) {
							int r = i + row[k];
							int c = j + col[k];
							if (r >= 0 && r < N && c >= 0 && c < N) {
								if (dam[r][c].equals("W")) {
									water++;
								}
							}
						}
						if (water == 0) { water = 1;} // 모두 땅이면 깊이 = 1
					}
					
					if (water > deepest) { deepest = water; }
				}
			}
			
			System.out.println("#" + tc + " " + deepest);
		} // end of for testCase
	}
}
