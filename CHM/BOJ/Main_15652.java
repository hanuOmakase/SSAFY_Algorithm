import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1~N 자연수 중 M개 선택, 중복 허용, 비내림차순 -> 중복 조합
public class Main_15652 { // 15652. N과 M (4)

	private static int N;
	private static int M;
	private static int[] nums; // 수열 저장
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		comb(0, 1);
		System.out.println(sb);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			nums[cnt] = i;
			comb(cnt + 1, i);
		}
	}
	
}
