package Study;

import java.util.Scanner;

public class BOJ_15652_N과M4 {
	static int N;
	static int M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		numbers = new int [M];
		recurse(0);
		System.out.println(sb);
	}
	public static void recurse(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(cnt != 0 && numbers[cnt - 1] > i) continue;
			numbers[cnt] = i;
			recurse(cnt + 1);
		}
	}
}
