package Graph;

import java.io.*;
import java.util.*;

public class BOJ_2589_보물섬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		int maxDist = 0;
		char[][] map = new char [H][W];
		Queue<Integer[]> q = new ArrayDeque<Integer[]>();
		for(int i = 0; i < H; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < W; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] != 'W') {
					boolean[][] visited = new boolean[H][W];
					visited[i][j] = true;
					q.add(new Integer[] {i, j, 0});
					int max = 0;
					while(!q.isEmpty()) {
						Integer[] current = q.poll();
						for(int k = 0; k < 4; k++) {
							int ny = current[0] + dy[k];
							int nx = current[1] + dx[k];
							if(0 <= ny && ny < H && 0 <= nx && nx < W && map[ny][nx] != 'W' && !visited[ny][nx]) {
								visited[ny][nx] = true;
								q.offer(new Integer[] {ny, nx, current[2] + 1});
							}
						}
						if(current[2] > max)
							max = current[2];
					}
					if(max > maxDist)
						maxDist = max;
				}
			}
		}
		System.out.println(maxDist);
	}
}
