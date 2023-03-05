import java.util.Arrays;
import java.util.Scanner;

// 공백이면 0, 별이면 1을 저장

public class Main_2447 { // 2447. 별 찍기 - 10
	
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		arr = new char[N][N];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		star(N, 0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void star(int n, int i, int j) {
		if (n == 3) {
			arr[i][j] = arr[i][j+1] = arr[i][j+2] = arr[i+1][j] = arr[i+1][j+2] = arr[i+2][j] = arr[i+2][j+1] = arr[i+2][j+2] = '*';
			return;
		}
		
		int three = n / 3; // 3등분
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 1 && c == 1) { continue; } // 가운데 공백
				star(three, i + three * r, j + three * c);
			}
		}
	}
	
}
