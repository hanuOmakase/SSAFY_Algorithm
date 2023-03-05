package Study;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	static int N;
	static int C;
	static int cnt = 0;
	static boolean[] isVisited;
	static boolean[][] coms;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		isVisited = new boolean [N + 1]; // 방문한 컴퓨터를 표시할 boolean
		coms = new boolean[N + 1][N + 1];
		
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			coms[com1][com2] = coms[com2][com1] = true;
		}

		dfs(1);

		System.out.println(cnt);
	}
	private static void dfs(int currCom) {
		isVisited[currCom] = true;
		for(int i = 1; i < N + 1; i++) {
			if(coms[currCom][i] && !isVisited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
}
