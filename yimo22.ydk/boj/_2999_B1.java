import java.util.Scanner;

public class _2999_B1 {
	public static void main(String[] args) {
		// R <= C && R * C = N 인 R과 C를 선택
		int N;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		N = str.length();

		// R과 C 선택
		int R = -1;
		int C = -1;
		for (int i = 1; i <= 100; i++) {
			if (N % i == 0) {
				int tmpC = Math.max(N/i, i);
				int tmpR = Math.min(N/i, i);
				if( tmpR > R) {
					R = tmpR;
					C = tmpC;
				}
			}
		}

		// 행렬을 만들고 decoding
		char[][] arr = new char[R][C];

		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				arr[j][i] = str.charAt(i * R + j);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb.toString());
		
	}
}
