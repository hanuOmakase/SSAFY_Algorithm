import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_새로운불면증치료법 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int saved = 0;
			int k = 1;
			while ((saved & ((1 << 10) - 1)) != ((1 << 10) - 1)) {
				int cur = N * k;
				while (cur > 0) {
					saved |= (1 << (cur % 10));
					cur /= 10;
				}

				k++;
			}
			
			sb.append("#").append(tc+1).append(" ").append((k-1) * N).append('\n');
		}
		System.out.println(sb.toString());
	}
}
