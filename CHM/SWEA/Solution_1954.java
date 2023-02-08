package swea;

import java.util.Scanner;

public class Solution_1954 { // 1954. 달팽이 숫자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] row = { 0, 1, 0, -1 };
		int[] col = { 1, 0, -1, 0 };
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int r = 0, c = 0, dir = 0;
			for (int i = 1; i <= N * N; i++) {
				
				snail[r][c] = i;
				
				if (r + row[dir] < 0 || c + col[dir] < 0 || 
					r + row[dir] > N - 1 || c + col[dir] > N - 1 || // 벽에 부딪히거나
					snail[r + row[dir]][c + col[dir]] != 0) { // 이미 값이 있으면
					
					dir = (dir + 1) % 4; // 방향 전환
				}
				
				r += row[dir];
				c += col[dir];
				
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail[i].length; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			
		} // end of for testCase
	}
}

