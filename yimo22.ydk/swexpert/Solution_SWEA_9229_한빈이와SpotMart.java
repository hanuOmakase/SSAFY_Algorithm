import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart {
	private static int[] arr;
	private static int[] numbers;
	private static int answer = 0;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			numbers = new int[2];
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			// 조합
			answer = -1;
			comb(0, 0);
			
			sb.append("#").append(tc+1).append(' ').append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}

	static void comb(int depth, int start) {
		if (depth == 2) {
			int sum = numbers[0] + numbers[1];
			if (sum > M)
				return;
			
			answer = Math.max(sum, answer);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			numbers[depth] = arr[i];
			comb(depth + 1, i + 1);
		}
	}
}
