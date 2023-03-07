
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 이동 -> 상하좌우 인접한 육지 -> 1칸에 1시간
// 보물 -> 두 육지 간 최단 거리들 중 가장 먼 곳
// 각 칸에서 인접한 다른 칸까지의 최단거리 구하기 -> dfs
// 방문하지 않은 육지 칸을 발견하면 큐에 넣기

public class Main_2589 { // 2589. 보물섬
	
	static Queue<Integer[]> queue = new ArrayDeque<Integer[]>(); // { r, c, dist }
	static int R;
	static int C;
	static char[][] map; // 지도
	static boolean[][] visited; // main에서의 방문체크
	static boolean[][] visitedFind; // find 함수에서의 방문체크
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int max = 0; // 가장 먼 거리
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L' && !visited[i][j]) {
					visited[i][j] = true;
					int dist = find(i, j);
					if (dist > max) { max = dist; } // max update
				}
			}
		}
		
		System.out.println(max);
		
	} // end of main
	
	public static int find(int i, int j) { // 가장 멀리 떨어진 칸 찾기
		
		int dist = 0; // 가장 멀리 떨어진 칸까지의 최단거리
		visitedFind = new boolean[R][C]; // 방문체크 배열 초기화
		queue.offer(new Integer[] { i, j, 0 }); // 큐에 시작점 넣기
		visitedFind[i][j] = true; // 시작점 방문 체크
		
		while(!queue.isEmpty()) {
			Integer[] current = queue.poll(); // 현재 칸
			dist = current[2];
			
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visitedFind[nr][nc] && map[nr][nc] == 'L') {
					visitedFind[nr][nc] = true;
					queue.offer(new Integer[] { nr, nc, dist + 1 });
				}
			}
		}
		
		return dist;
	}
	
	
}
