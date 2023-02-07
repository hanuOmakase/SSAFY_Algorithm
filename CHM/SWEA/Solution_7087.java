package swea.D3;

import java.util.Scanner;

public class Solution_7087 { // 7087. 문제 제목 붙이기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
ex:		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt(); // 만든 문제제목 수
			int[] titleFirst = new int[(int) ('Z' - 'A') + 1];
			for (int i = 0; i < N; i++) {
				titleFirst[(int) sc.next().charAt(0) - 'A'] = 1;
			}
//			System.out.println(Arrays.toString(titleFirst));
			for (int i = 0; i < titleFirst.length; i++) {
				if (titleFirst[i] == 0) {
					System.out.printf("#%d %d\n", tc, i);
					continue ex;
				}
			}
			
			System.out.printf("#%d %d\n", tc, titleFirst.length);
			
		} // end of for testCase
	}
}
