import java.util.Scanner;

public class P1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			//배열 생성 & 초기화
			int[][] arr = new int [N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			System.out.println("#" + testCase);
			for(int i = 0; i < N; i++) {
				for(int j = N - 1; j >= 0; j--)
					System.out.print(arr[j][i]);
				System.out.print(" ");
				for(int j = N - 1; j >= 0; j--)
					System.out.print(arr[(N - 1) - i][j]);
				System.out.print(" ");
				for(int j = 0; j < N; j++)
					System.out.print(arr[j][(N - 1) - i]);
				System.out.println();
			}
		}
		sc.close();
	}
}
