package boj.Bronze;

import java.util.Scanner;

public class Main_2851 { // 2851. 슈퍼 마리오
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int score = 0;
		for (int i = 0; i < 10; i++) {
			score = sc.nextInt();
			sum += score;
			if (sum > 100) {
				break;
			}
		}
		
		System.out.println(sum - 100 > 100 - (sum - score) ? sum - score : sum);
		
	}
}
