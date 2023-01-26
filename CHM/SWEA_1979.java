import java.util.Scanner;

public class Solution_SWEA_1979_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int result = 0;
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				int rowCheck = 0;
				int colCheck = 0;
				for (int j = 0; j < arr.length; j++) {
					
					// 가로
					if (arr[i][j] == 1) {
						rowCheck++; 
					} else { // arr[i][j] == 0
						if (rowCheck == K) { result++; }
						rowCheck = 0;
					}
					
					// 세로
					if (arr[j][i] == 1) { 
						colCheck++; 
					} else { // arr[j][i] == 0
						if (colCheck == K) { result++; }
						colCheck = 0;
					}
					
				}
				if (rowCheck == K) { result++; }
				if (colCheck == K) { result++; }
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
