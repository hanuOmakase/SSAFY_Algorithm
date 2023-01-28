import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1983_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt(); // 10의 배수
			int K = sc.nextInt();
			int[] scores = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = 35 * sc.nextInt() + 45 * sc.nextInt() + 20 * sc.nextInt();
			}
			
			int kScore = scores[K - 1];
			int kIndex = -1;
			
			Arrays.sort(scores);
			
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] == kScore) { // k번째 학생의 점수
					kIndex = N - i;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + grades[(kIndex - 1) * 10 / N]);
		} // end of for testCase
	}
}
