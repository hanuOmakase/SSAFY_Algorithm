package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16927_배열돌리기2_G5 {
	static int N, M, R;
	static int[][] map;
	static int pivot = 0;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// rotate
		pivot = Math.min(N, M) / 2;

		rotate(0);
		printArr();
	}

	static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotate(int depth) {
		if (depth == pivot) {
			return;
		}
		// 현재 depth는 rotateCnt % cnt 만큼 회전한다.
		int cnt = 2 * ((N - 2 * depth) + (M - 2 * depth)) - 4;

		for (int rep = R % cnt; rep > 0; rep--) {
			// 위
			int prev = map[depth][depth];
			for(int i=depth; i+1 <M-depth;i++) {
				map[depth][i] = map[depth][i+1];
			}
			
			// 아래
			int tmp2 = map[N - 1 - depth][M - 1 - depth];
			for (int i = M-1-depth; i-1 >= depth; i--)
				map[N-1-depth][i] = map[N-1-depth][i-1];

			// 왼쪽
			for(int i= N-1-depth; i-1>=depth; i--) {
				map[i][depth] = map[i-1][depth]; 
			}
			map[depth+1][depth] = prev;
			
			// 오른쪽
			for(int i=depth; i < N-depth-1;i++) {
				map[i][M-1-depth] = map[i+1][M-1-depth];
			}
			map[N-1-depth-1][M-1-depth] = tmp2;
		}

		
		rotate(depth + 1);

	}
}
