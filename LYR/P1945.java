package SWEA;

import java.util.Scanner;

public class P1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] primes = {2, 3, 5, 7, 11};
			int[] answer = {0, 0, 0, 0, 0};
			for(int i = 0; i < 5; i++) {
				while(N % primes[i] == 0) {
					answer[i]++;
					N /= primes[i];
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 5; i++)
				System.out.print(answer[i] + " ");
			System.out.println();
		}
		sc.close();
	}
}
