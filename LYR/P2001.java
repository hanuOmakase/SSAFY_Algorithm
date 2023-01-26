import java.util.Scanner;

public class P2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] fly = new int [N][N];
			int maxKill = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					fly[i][j] = sc.nextInt();
			for(int i = 0; i < N - (M - 1); i++)
				for(int j = 0; j < N - (M - 1); j++) {
					int kill = 0;
					for(int a = i; a < M + i; a++)
						for(int b = j; b < M + j; b++)
							kill += fly[a][b];
					if(kill > maxKill) maxKill = kill;
				}
			System.out.println("#" + testCase + " " + maxKill);
		}
		sc.close();
	}
}
