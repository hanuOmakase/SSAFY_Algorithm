import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_프로세서연결하기 {
	private static int[][] map;
	static List<Integer[]> list;
	private static int N;
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (j == 0 || j == N - 1 || i == 0 || i == N - 1)
						continue;
					else if (map[i][j] == 1)
						list.add(new Integer[] { i, j });
				}
			}

			// 탐색
			answer = new int[2];
			answer[1] = Integer.MAX_VALUE;
			search(0, 0, 0);
			// 아무것도 연결하지 못하는 경우
			if(answer[1] == Integer.MAX_VALUE) answer[1] = 0;
			sb.append("#").append(tc+1).append(' ').append(answer[1]).append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void search(int depth, int core, int len) {
		if(depth >= list.size()) {
			if(answer[0] < core) {
				answer[0] = core;
				answer[1] = len;
			}
			else if(answer[0] == core) answer[1] = Math.min(answer[1], len);
			return;
		}
		
		Integer[] cur = list.get(depth);
		// 사용 하는 경우
		for (int d = 0; d < dir.length; d++) {

			if (isPossible(cur[0], cur[1], d)) {
				int cnt = filling(cur[0], cur[1], d, 1);
				search(depth + 1, core + 1, len + cnt);
				filling(cur[0], cur[1], d, 0);
			}
		}
		// 사용하지 않는 경우
		search(depth+1, core, len);
	}

	static int filling(int x, int y, int d, int val) {
		int nx = x + dir[d][0];
		int ny = y + dir[d][1];
		int cnt = 0;
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			map[nx][ny] = val;
			cnt++;
			nx += dir[d][0];
			ny += dir[d][1];
		}
		return cnt;
	}

	static boolean isPossible(int x, int y, int d) {
		int nx = x + dir[d][0];
		int ny = y + dir[d][1];

		while (0 <= nx && nx < N && ny >= 0 && ny < N) {
			if (map[nx][ny] == 1)
				return false;
			nx += dir[d][0];
			ny += dir[d][1];
		}

		return true;
	}
}
