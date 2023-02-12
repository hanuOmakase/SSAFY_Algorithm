import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15654_N과M5 {
	static int N, M;
	static int[] numbers;
	static int[] input;
	static int used;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		used = 0;
		sb = new StringBuilder();
		
		// sorting
		Arrays.sort(input);
		perm(0);
		System.out.println(sb.toString());
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for(int w : numbers) sb.append(w).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < input.length; i++) {
			if((used & (1 << i)) != 0) continue;
			
			used |= (1 << i);
			numbers[cnt] = input[i];
			perm(cnt+1);
			
			used &= ~(1 << i); 
		}
	}
}
