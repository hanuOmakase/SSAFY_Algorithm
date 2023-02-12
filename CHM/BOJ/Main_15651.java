import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1~N의 자연수 중 M개를 고르기 (중복 허용) -> 중복 순열
public class Main_15651 { // 15651. N과 M (3)
	
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
		
		perm(0);
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		
		if (cnt == M) {
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			nums[cnt] = i;
			perm(cnt + 1);
		}
	}
}
