import java.util.Scanner;

public class P1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int[][] sudoku = new int [9][9];
			boolean flag = true;
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
					sudoku[i][j] = sc.nextInt();
			
			for(int i = 0; i < 9; i++) { // 가로
				int[] hash = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				for(int j = 0; j < 9; j++) {
					hash[sudoku[i][j]]++;
					if(hash[sudoku[i][j]] > 1) {
						flag = false;
						break;
					}
					if(!flag) break;
				}
			}
			if(flag) {
				for(int j = 0; j < 9; j++) { // 세로
					int[] hash = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
					for(int i = 0; i < 9; i++) {
						hash[sudoku[i][j]]++;
						if(hash[sudoku[i][j]] > 1) {
							flag = false;
							break;
						}
						if(!flag) break;
					}
				}
			}
			if(flag) {
				for(int i = 0; i < 9 ;i += 3) {
					for(int j = 0; j < 9; j += 3) {
						int[] hash = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
						for(int m = i; m < i + 3; m++) {
							for(int n = j; n < j + 3; n++) {
								hash[sudoku[m][n]]++;
								if(hash[sudoku[m][n]] > 1) {
									flag = false;
									break;
								}
							}
							if(!flag) break;
						}
						if(!flag) break;
					}
					if(!flag) break;
				}
			}
			System.out.println("#" + testCase + " " + (flag ? 1 : 0));
		}
		sc.close();
	}
}
