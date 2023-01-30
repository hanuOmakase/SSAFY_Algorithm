package SWEA;

import java.util.Scanner;

public class P1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			long N = sc.nextInt();
			boolean[] numbers = new boolean [10];
			int existingNum = 0;
			int i = 1;
			while(existingNum != 10) {
				long currNum = N * i;
				String tmp = "" + currNum;
				for(int j = 0; j < tmp.length(); j++) {
					if(!numbers[(int)tmp.charAt(j) - '0']) {
						numbers[(int)tmp.charAt(j) - '0'] = true;
						existingNum++;
					}
					if(existingNum == 10) break;
				}
				i++;
			}
			System.out.println("#" + tc + " " + (i - 1) * N);
		}
		sc.close();
	}
}
