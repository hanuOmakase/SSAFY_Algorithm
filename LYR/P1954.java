import java.util.Arrays;
import java.util.Scanner;

public class P1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			//배열 초기화
			int[][] snail = new int [N][N];
			for(int i = 0; i < N; i++) Arrays.fill(snail[i], 0);
			
			int num = 1;
			int total = N * N;
			int x = 0, y = 0;
			
			//달팽이 채우기
			while(num <= total) {
				while(x < N && snail[y][x] == 0) {
					snail[y][x] = num;
					num++;
					x++;
				}
				x--;
				y++;
				while(y < N && snail[y][x] == 0) {
					snail[y][x] = num;
					num++;
					y++;
				}
				y--;
				x--;
				while(x >= 0 && snail[y][x] == 0) {
					snail[y][x] = num;
					num++;
					x--;
				}
				x++;
				y--;
				while(y >= 0 && snail[y][x] == 0) {
					snail[y][x] = num;
					num++;
					y--;
				}
				y++;
				x++;
			}
			
			//출력하기
			System.out.println("#" + testCase);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
