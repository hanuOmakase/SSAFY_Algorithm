package swexpert;

import java.util.*;

public class __2805 {
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			System.out.printf("#%d %d\n", tc + 1, Solve(map));
		}
	}

	private static int Solve(int[][] map) {
		// TODO Auto-generated method stub
		int N = map.length;
		
		int r = N/2, c = N/2;
		int cnt = N /2;
		
		int sum  = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N/2, N/2, 0));
		visited[N/2][N/2] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.depth > cnt) break;
			sum += map[cur.x][cur.y];
			
			for(int[] d : dir) {
				int nx = cur.x + d[0];
				int ny = cur.y + d[1];
				
				// boundary
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny, cur.depth + 1));
				}
			}
		}
		
		return sum;
	}

	static class Node {
		int x, y, depth;

		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

	}
}
