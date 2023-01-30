package SWEA;

import java.util.Scanner;

public class P1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] moneyCnt = new int[8];
			for(int i = 0; i < 8; i++) {
				moneyCnt[i] = N / moneyList[i];
				N %= moneyList[i];
			}
			System.out.println("#" + tc);
			for(int i = 0; i < 8; i++) System.out.print(moneyCnt[i] + " ");
			System.out.println();
		}
		sc.close();
	}
}
