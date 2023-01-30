package SWEA;

import java.util.Scanner;

public class P1284 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int A = P * W;
			int B;
			if(W <= R) B = Q;
			else B = Q + (W - R) * S;
			System.out.print("#" + tc + " ");
			if(A < B) System.out.println(A);
			else System.out.println(B);
		}
		sc.close();
	}
}
