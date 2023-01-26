import java.util.Scanner;

public class Solution_SWEA_2005_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int testCase = 1; testCase <= tc; testCase++) {
			int N = sc.nextInt(); // N은 1이상 10이하 정수
			int[][] pascal = new int[N][N];
			
			pascal[0][0] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					pascal[i][0] = 1; // N이 2이상
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
			
			System.out.println("#" + testCase);
			for (int i = 0; i < pascal.length; i++) {
				for (int j = 0; j < pascal[i].length; j++) {
					if (pascal[i][j] != 0) {
						System.out.print(pascal[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
