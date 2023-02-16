package Study;

import java.io.*;
import java.util.*;

public class BOJ_1012_유기농배추 {
	static int[][] farm;
	static int N;
	static int M;
	static int K;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 밭 상태 입력
			farm = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1;
			}
			
			// 지렁이 개수 구하기
			int worm = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 해당 칸에 배추(1)가 있으면
					if(farm[i][j] == 1) {
						worm++; // 지렁이 개수 증가
						putWorm(i, j); // 해당 칸 및 서로 인접한 모든 배추가 심어진 칸들을 0으로 만들어주기
					}
				}
			}
			sb.append(worm).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 지렁이가 뿌려진 인접한 밭들을 0으로 만들어주기
	private static void putWorm(int y, int x) {
		farm[y][x] = 0; // 0 만들어주기를 먼저 해줘야 재귀할때 중복으로 호출되지 않는다
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if((0 <= ny && ny < N && 0 <= nx && nx < M) && farm[ny][nx] == 1)
				putWorm(ny, nx);
		}
	}
}
