import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15652_N과M4 {
	private static int N;
	private static int M;
	private static StringBuilder sb;
	private static int[] numbers;
	public static void main(String[] args) throws Exception { // 중복 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		sb = new StringBuilder();
		comb(0,1);
		System.out.println(sb.toString());
	}
	static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int w : numbers) sb.append(w).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i);
		}
	}
}
