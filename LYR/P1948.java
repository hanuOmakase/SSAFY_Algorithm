package SWEA;

import java.util.Scanner;

public class P1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int tc = 1; tc <= T; tc++) {
			int[] day1 = new int [2];
			int[] day2 = new int [2];
			for(int i = 0; i < 2; i++) day1[i] = sc.nextInt();
			for(int i = 0; i < 2; i++) day2[i] = sc.nextInt();
			int answer = 0;
			for(int i = day1[0]; i < day2[0]; i++) answer += month[i-1];
			answer -= day1[1];
			answer += day2[1];
			answer++;
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
}
