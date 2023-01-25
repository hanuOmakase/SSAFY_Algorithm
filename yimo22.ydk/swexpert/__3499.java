package swexpert;
import java.util.*;
import java.io.*;

public class __3499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc + 1).append(" ");
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			// shuffling
			// swapping
			// 0 1 |2| 3 4
			for (int i = 0; i < N / 2; i++) {
				int post_pos = (N % 2 == 0) ? N / 2 + i : N / 2 + 1 + i;
				sb.append(arr[i]).append(" ");
				sb.append(arr[post_pos]).append(" ");
			}
			if (N % 2 != 0)
				sb.append(arr[N / 2]);

			System.out.println(sb.toString());
		}
	}
}
