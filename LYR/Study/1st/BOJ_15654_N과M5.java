package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_15654_N과M5 {
	static int N;
	static int M;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int [N];
		isSelected = new boolean[N];
		numbers = new int [M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		
		recurse(0);
		System.out.println(sb);
	}
	private static void recurse(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			recurse(cnt + 1);
			isSelected[i] = false;
		}
	}
}
