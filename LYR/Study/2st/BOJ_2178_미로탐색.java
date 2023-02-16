package Study;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
	static int N;
	static int M;
	static String[] maze;
	static int[][] dist; // 메모이제이션에 사용할 2차원 int 배열
	static Queue<Pair> q = new ArrayDeque<Pair>(); // BFS에 사용할 Queue
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 미로 입력
		maze = new String [N];
		dist = new int[N][M];
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine();
		}
		
		// BFS 수행
		bfs(0, 0);
		
		// 정답 출력
		System.out.println(dist[N-1][M-1]);
	}
	
	// BFS
	private static void bfs(int y, int x) {
		q.offer(new Pair(y, x));
		dist[y][x] = 1;
		while(!q.isEmpty()) {
			// Queue pop()
			y = q.peek().getY();
			x = q.peek().getX();
			q.remove();
			
			// Queue 맨 앞에 있던 좌표값의 상하좌우 탐색
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				// 좌표값이 0~N, 0~M 사이이고 dist가 0(아직 방문하지 않은 칸)이며 maze가 1(이동 가능한 칸)일 경우
				// Queue에 해당 좌표값을 넣는다
				// dist 배열에는 기존 이동거리 + 1을 저장한다
				if((0 <= ny && ny < N && 0 <= nx && nx < M) && dist[ny][nx] == 0 && maze[ny].charAt(nx) == '1') {
					q.offer(new Pair(ny, nx));
					dist[ny][nx] = dist[y][x] + 1;
				}
			}
		}
	}
	
	// Queue에 들어갈 <y,x>형태의 자료구조 class
	static class Pair{
		private int x;
		private int y;
		
		public Pair(int y, int x) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}
