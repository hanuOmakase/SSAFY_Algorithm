import java.util.Scanner;

public class Solution_SWEA_1204_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int tc = 0; tc < testCase; tc++) {
			int tcNum = sc.nextInt();
			
			int max = 0;
			int maxIdx = 0;
			int[] scores = new int[101];
			for (int i = 0; i < 1000; i++) {
				int num = sc.nextInt();
				scores[num]++;
				
				if (scores[num] >= max) {
					max = scores[num];
					maxIdx = num;
				}
			}

			System.out.printf("#%d %d\n", tcNum, maxIdx);
		} // end of for testCase
	}
}
