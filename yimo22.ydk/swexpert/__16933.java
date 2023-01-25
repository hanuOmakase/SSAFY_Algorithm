package swexpert;

import java.util.*;
import java.io.*;

public class __16933 {
	static int N, M, K;
	static int[][] map;
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(Solve());
	}

	private static int Solve() {
		// TODO Auto-generated method stub

		// 시작 index 는 1부터 시작
		// 상하좌우 이동 가능
		// 벽을 K개 부술 수 있음 (낮에만 부술 수 있다)
		// 시작하는 칸과 끝나는 칸을 포함해서 센다
		// 이동하지 않고 같은 칸에 머무는 경우도 가능
		// 처음 시작시 낮, 가장 처음에 이동할 떄는 낮 & 한번 이동 시마다 낮/밤이 바뀜
		// (1,1) -> (N, M) 까지의 최단거리
		// 불가능할 떄는 -1을 출력

		// init
		// bfs 탐색 이용
//		System.out.println("start");
		Queue<Node> q = new LinkedList<Node>();
		int[][] visited = new int[N][M];

		// start
		q.add(new Node(0, 0, 1, 0, 0));
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
//			System.out.println(cur);
			int curState = cur.time % 2; // curState 가 0이면 낮, 1이면 밤
			// check
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.count;
			}

			// backtracking
			// -> 만약 방문한 노드보다, 더 짧은 경로에서 방문한 경우
			if (visited[cur.x][cur.y] < cur.count)
				continue;
			visited[cur.x][cur.y] = cur.count;
			// forwarding
			for (int[] d : dir) {
				int nx = cur.x + d[0];
				int ny = cur.y + d[1];

				// boundary check
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (map[nx][ny] == 0  ) {
					// wall 이 아니고, 방문한적 없음 or 방문해도 더 작은 count 임 일 경우 방문
					visited[nx][ny] = cur.count +1;
					q.add(new Node(nx, ny, cur.count + 1, cur.breakWallCnt, cur.time + 1));
				}

				// 벽을 부수면서 이동하는 경우
				if (map[nx][ny] == 1 && cur.breakWallCnt < K && curState == 0) {
					visited[nx][ny] = cur.count + 1;
					q.add(new Node(nx, ny, cur.count + 1, cur.breakWallCnt + 1, cur.time + 1));
				}
			}
			// 제자리에서 진행하는 경우
			q.add(new Node(cur.x, cur.y, cur.count + 1, cur.breakWallCnt, cur.time + 1));
		}

		return -1;
	}

	static class Node {
		int x, y;
		int breakWallCnt;
		int time; // time 짝수면 day, 홀수면 night
		int count; // 이동 거리

		public Node(int x, int y, int cnt, int wcnt, int t) {
			this.x = x;
			this.y = y;
			this.breakWallCnt = wcnt;
			this.time = t;
			this.count = cnt;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y + " " + count + " " + breakWallCnt + " " + time;
		}
	}
}
