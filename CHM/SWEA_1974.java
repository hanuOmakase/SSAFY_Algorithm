import java.util.Scanner;

public class Solution_SWEA_1974_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int result = 1;
			int[][] puzzle = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			// 가로, 세로 확인
			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 9; j++) {
					rowSum += puzzle[i][j];
					colSum += puzzle[j][i];
				}
				if (rowSum != 45 || colSum != 45) {
					result = 0;
					break;
				}
			}
			
			// 3*3 확인
			if (result != 0) { // 가로, 세로 모두 겹치지 않으면
ex:				for (int i = 0; i < 9; i += 3) { 
					for (int j = 0; j < 9; j += 3) {
						int sum = 0;
						for (int i2 = 0; i2 < 3; i2++) {
							for (int j2 = 0; j2 < 3; j2++) {
								sum += puzzle[i + i2][j + j2];
							}
						}
						if (sum != 45) {
							result = 0;
							break ex;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
