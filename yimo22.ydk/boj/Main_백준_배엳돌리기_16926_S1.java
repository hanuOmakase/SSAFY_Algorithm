package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_배엳돌리기_16926_S1 {
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
		for(int i=0;i<R;i++)
			rotate(0, 0, 0, new boolean[N][M]);
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

	static void rotate(int r, int c, int depth, boolean[][] visited) {
		if (depth == pivot) {
			return;
		}
		int x = r;
		int y = c;

		int prev = map[x][y + 1];
		int cnt = 2 * ((N - 2 * depth) + (M - 2 * depth)) - 4;
		int d = 0;
		while (cnt > 0) {
			int tmp = map[x][y];
			map[x][y] = prev;
			prev = tmp;
			visited[x][y] = true;
			if (x + dir[d][0] < 0 || x + dir[d][0] >= N || y + dir[d][1] < 0 || y + dir[d][1] >= M
					|| visited[x + dir[d][0]][y + dir[d][1]])
				d = (d + 1) % dir.length;

			x += dir[d][0];
			y += dir[d][1];
			cnt--;
		}
		rotate(r + 1, c + 1, depth + 1, visited);

	}
}
