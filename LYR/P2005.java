import java.util.Scanner;

public class P2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] pascal = new int [10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 ||i == j) pascal[i][j] = 1;
				else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			System.out.println("#" + testCase);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++)
					System.out.print(pascal[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
