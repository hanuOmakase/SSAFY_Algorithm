import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열
public class Main_15654 { // 15654. N과 M (5)
	
	private static int N;
	private static int M;
	private static int[] inputs;
	private static int[] nums;
	private static boolean[] isSelected;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		isSelected = new boolean[N];
		nums = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputs);
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
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			nums[cnt] = inputs[i];
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
