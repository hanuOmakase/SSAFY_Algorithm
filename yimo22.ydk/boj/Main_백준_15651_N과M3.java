import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15651_N과M3 {
	static int[] numbers;
	private static int N;
	private static int M;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{ // 중복순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		numbers = new int[M];
		perm(0);
		System.out.println(sb.toString());
	}
	static void perm(int cnt) {
		if(cnt == M) {
			for(int w : numbers) sb.append(w).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			numbers[cnt] = i;
			perm(cnt+1);
		}
	}
	
}
