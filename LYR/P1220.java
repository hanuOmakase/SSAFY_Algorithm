package SWEA;

import java.util.Scanner;

public class P1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			int[][] table = new int [N][N];
			int numOfDeadlock = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					table[i][j] = sc.nextInt();
			for(int j = 0; j < N; j++) {
				boolean isOne = false;
				for(int i = 0; i < N; i++) {
					if(table[i][j] == 1) isOne = true;
					if(table[i][j] == 2 && isOne) {
						numOfDeadlock++;
						isOne = false;
					}
				}
			}
			System.out.println("#" + testCase + " " + numOfDeadlock);
		}
		sc.close();
	}
}
