import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999 { // 2999. 비밀 이메일
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String message = br.readLine();
		int N = message.length();
		
		int R = 0, C = 0;
		// R <= C && R * C == N 을 만족하는 R, C 구하기 -> 여러 경우의 수 중 R이 최대인 경우
		for (int i = N; i >= Math.sqrt(N); i--) {
			if (N % i == 0) {
				C = i;
				R = N / i;
			}
		}
		
		char[][] decode = new char[C][R];
		int idx = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				decode[i][j] = message.charAt(idx++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(decode[j][i]);
			}
		}
		
		System.out.println(sb);
	}
}