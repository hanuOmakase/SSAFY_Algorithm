import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4 {
	static int N, M, K;
	static int[][] map;
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r, c, s;
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			rotate(r - 1, c - 1, s);
		}
		
		// 각 행의 최대합 갱신
		int answer = Integer.MIN_VALUE;
		for(int i=0;i<map.length;i++) {
			int sum = 0;
			for(int j=0;j<map[i].length;j++) sum += map[i][j];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}

	/** 왼쪽 끝이 r,c 일때 회전시키는 함수 */
	static void rotate(int r, int c, int depth) {
		if (depth == 0) {
			return;
		}
		int x = r - depth, y = c - depth;
		int prev = map[x + 1][c];
		int d = 0;
		int cnt = 2 * (2 * depth + 1) + 2 * (2 * depth - 1);
		while (cnt > 0) {
			int tmp = map[x][y];
			map[x][y] = prev;
			prev = tmp;

			// move forward
			if(x + dir[d][0] < r-depth || x + dir[d][0] > r + depth || y + dir[d][1] < c - depth || y + dir[d][1] > c + depth) {
				d++;
			}
			
			x += dir[d][0];
			y += dir[d][1];
			cnt--;
		}
		
		rotate(r,c,depth-1);
	}

}
