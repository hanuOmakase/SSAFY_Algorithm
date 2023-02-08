
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_백준_15650_N과M2_실버3_김영도_232ms {
	static int[] numbers;
	static int used;
	private static int N;
	private static int M;
	public static void main(String[] args) throws Exception{
		// 자연수 N,M
		// 1 <= M <= N <= 8
		// 1~N까지 중 중복없이 고른 M개의 수열
		// 수열은 오름차순
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		used = 0;
		numbers = new int[M];
		comb(0, 1);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			Arrays.stream(numbers).forEach(e -> System.out.print(e+" "));
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
}
