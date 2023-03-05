import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dfs로 접근
// 배열 한 칸씩 접근하면서 방문하지 않은 칸이면서 섬이면 dfs 함수 호출
// 함수 종료되면 섬 카운트++, 배열 다음 칸 탐색

public class Main_4963 { // 4963. 섬의 개수
	
	static int w; // 지도 너비 = c
	static int h; // 지도 높이 = r
	static int[][] map; // 지도
	static boolean[][] visited; // 방문체크
	static int island; // 섬 개수
	
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 왼쪽 위부터 시계방향
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) { // 테스트 케이스 반복
			st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0) { break; } // 0이면 종료
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			// 지도 입력(초기화)
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방문 배열 초기화
			for (int i = 0; i < h; i++) {
				Arrays.fill(visited[i], false);
			}
			
			// 섬 개수 초기화
			island = 0;
			
			// 방문하지 않은 칸이면서 섬이면 dfs 시작
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						island++;
					}
				}
			}
			sb.append(island).append("\n");
			
		}
		System.out.println(sb.toString());
		
	} // end of main

	private static void dfs(int i, int j) {
		
		visited[i][j] = true;
		
		for (int d = 0; d < dr.length; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			// 다음 칸이 배열 범위 내이고, 방문한 적 없는 섬
			if (nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
		
	}
}
