import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636_G4 {
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M, total=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++;
			}
		}

		// start
		int time=0;
		while(true) {
			// 공기와 닿는 부분 check
			Queue<Integer[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			q.add(new Integer[] {0,0});
			visited[0][0] = true;
			int cnt = 0;
			while(!q.isEmpty()) {
				Integer[] cur = q.poll(); // {x, y}
				
				for(int[] d : dir) {
					int nx = d[0] + cur[0];
					int ny = d[1] + cur[1];
				
					// boundary check
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					if(map[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Integer[] {nx,ny});
					}
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						cnt++;
						visited[nx][ny] = true;
						map[nx][ny] = 0;
					}
				}
			}
			time++;
			// 남는 갯수 파악
			if(total - cnt <= 0) {
				System.out.println(time);
				System.out.println(cnt);
				break;
			}
			total -= cnt;
		}
	}

	
	
}
