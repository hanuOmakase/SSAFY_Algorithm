
import java.util.Scanner;

public class Solution_1215 { // 1215. 회문1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String line = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			int count = 0; // 회문 개수
			for (int i = 0; i < arr.length; i++) { // row
				for (int j = 0; j <= arr.length - N; j++) {
					
					// 가로
					boolean issiR = true;
					for (int k = 0; k < N / 2; k++) {
						if (arr[i][j + k] != arr[i][j + N - k - 1]) {
							issiR = false;
							break;
						}
					}
					if (issiR) { count++; }
					
					// 세로
					boolean issiC = true;
					for (int k = 0; k < N / 2; k++) {
						if (arr[j + k][i] != arr[j + N - k - 1][i]) {
							issiC = false;
							break;
						}
					}
					if (issiC) { count++; }
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		} // end of for testCase
	} // end of main

	
}
