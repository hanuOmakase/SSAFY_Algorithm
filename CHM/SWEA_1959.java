import java.util.Scanner;

public class Solution_SWEA_1959_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < B.length; i++) {
				B[i] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			
			if (N <= M) {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					}
					if (sum > max) { max = sum; }
				}
			} else {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += A[i + j] * B[j];
					}
					if (sum > max) { max = sum; }
				}
			}
			
			System.out.println("#" + tc + " " + max);
		} // end of for testCase
	}
}
