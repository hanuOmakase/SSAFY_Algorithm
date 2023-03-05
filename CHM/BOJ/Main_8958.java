package boj.Bronze;

import java.util.Scanner;

public class Main_8958 { // 8958. OX퀴즈
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			
			int score = 0;
			int sum = 0;
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == 'O') {
					sum++;
					score += sum;
				} else {
					sum = 0;
				}
			}
			
			System.out.println(score);
		}
	}
}
