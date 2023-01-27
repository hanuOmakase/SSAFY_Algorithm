
import java.util.*;
import java.io.*;

public class _2567_S4 {
	static int answer = 0;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		int[][] map = new int[101][101];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					map[j-1][k-1] = 1;
				}
			}
		}

		// dfs 탐색 하면서 경계면 탐색
		// init
		boolean[][] visited = new boolean[100][100];

		// start
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					dfs(i, j, map, visited);
				}
			}
		}

		System.out.println(answer);
	}

	static void dfs(int x, int y, int[][] map, boolean[][] visited) {

		for (int[] d : dir) {
			int nx = x + d[0];
			int ny = y + d[1];

			// boundary check
			if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
				answer++;
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny, map, visited);
			}
			if (map[nx][ny] == 0) {
				answer++;
			}
		}
	}
}
