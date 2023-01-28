package SWEA;

import java.util.Scanner;

public class P1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int test = sc.nextInt();
			int[] scores = new int [101];
			int modeCnt = 0;
			int maxMode = 0;
			for(int i = 0; i < 1000; i++) {
				int num = sc.nextInt();
				scores[num]++;
				if(scores[num] > modeCnt) {
					modeCnt = scores[num];
					maxMode = num;
				}
				else if(scores[num] == modeCnt) {
					if(num > maxMode)
						maxMode = num;
				}
			}
			System.out.println("#" + test + " " + maxMode);
		}
		sc.close();
	}
}
