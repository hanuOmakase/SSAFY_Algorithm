package boj.Bronze;

import java.util.Scanner;

public class Main_8320 { // 8320. 직사각형을 만드는 방법
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int squares = 0;
		
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (i * j <= n) {
				squares++;
				j++;
			}
		}
		
		System.out.println(squares);
	}
}
