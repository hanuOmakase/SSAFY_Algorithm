import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1
// 1 + 2
// 1 + 2 + 3
// 1 + 2 + 3 + 3
// 1 + 2 + 3 + 3 + 4
public class Main_11399 { // 11399. ATM
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		int sum = 0;
		int totalSum = 0;
		for (int i = 0; i < time.length; i++) {
			sum += time[i];
			totalSum += sum;
		}
		
		System.out.println(totalSum);
	}
}
