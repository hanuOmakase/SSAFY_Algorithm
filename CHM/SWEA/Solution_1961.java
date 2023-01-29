package swea.D2;

import java.util.Scanner;

public class Solution_1961 { // 1961 숫자 배열 회전
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] rotated90 = rotate(arr);
			int[][] rotated180 = rotate(rotated90);
			int[][] rotated270 = rotate(rotated180);
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(rotated90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rotated180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rotated270[i][j]);
				}
				System.out.println();
			}
			
		} // end of for testCase
	} // end of main
	
	
	private static int[][] rotate(int[][] arr) {
		int n = arr.length;
		int[][] rotatedArr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotatedArr[i][j] = arr[n - j - 1][i];
			}
		}
		
		return rotatedArr;
	}
}
