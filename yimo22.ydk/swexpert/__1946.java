import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class __1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 0;
		T = Integer.parseInt(br.readLine());
		int N = 0;
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();
			System.out.println("#" + (tc + 1));
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				int w = Integer.parseInt(st.nextToken());

				for (int j = 0; j < w; j++) {
					if(sb.length() == 10) {
						System.out.println(sb.toString());
						sb = new StringBuilder();
					}
					sb.append(ch);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
