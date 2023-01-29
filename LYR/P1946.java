package SWEA;

import java.util.Scanner;

public class P1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[] alpha = new char[N];
			int[] num = new int[N];
			for(int i = 0; i < N; i++) {
				alpha[i] = sc.next().charAt(0) ;
				num[i] = sc.nextInt();
			}
			int index = 0;
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < num[i]; j++) {
					if(index >= 10 &&index % 10 == 0) System.out.println();
					System.out.print(alpha[i]);
					index++;
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
