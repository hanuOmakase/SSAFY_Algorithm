package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1733 {
	static final int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 } };
	static int[][] map = new int[20][20];
	static int answerDirection = -1;
	public static void main(String[] args) throws Exception {
		// 오목 승자 판단
		// 0: 빈곳, 1 : 검정알, 2:흰바둑
		// 0 : 무승부, 1:검, 2:흰
		// 가장 왼쪽의 위치를 출력
		// 세로일 경우, 위에 있는 위치를 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// init
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		boolean found = false;
		for (int i = 1; i <= 19; i++) {
			if (found)
				break;
			for (int j = 1; j <= 19; j++) {
				if (map[i][j] != 0) {
					int res = check(i, j);
					if (res == -1)
						continue;
					found = true;
					
					int ax = i;
					int ay = j;
					if(answerDirection == 0) {
						ax += 4;
						ay -= 4;
					}
					System.out.println(res);
					System.out.println(String.format("%d %d", ax, ay));
					break;
				}
			}
		}
		if (!found)
			System.out.println(0);
	}

	/**
	 * 승자를 판단하는 함수
	 * 
	 * @return 1(검정), 2(흰) -1(없음)
	 */
	private static int check(int x, int y) {
		// TODO Auto-generated method stub
		for (int rep = 0; rep < 4; rep++) {
			// rep 방향과 그 반대 방향으로 갯수 count
			int nx = x;
			int ny = y;

			int cnt = 0;
			while (boundaryCheck(nx, ny) && map[nx][ny] == map[x][y]) {
				cnt++;
				nx += dir[rep][0];
				ny += dir[rep][1];
			}
			nx = x; ny = y;
			while(boundaryCheck(nx, ny) && map[nx][ny] == map[x][y]) {
				cnt++;
				int nd = (rep + 4) % 8;
				nx += dir[nd][0];
				ny += dir[nd][1];
			}
			cnt--; // (x, y) 가 2번세짐
			if(cnt == 5) {
				answerDirection = rep;
				return map[x][y];
			}
		}
		return -1;
	}

	private static boolean boundaryCheck(int x, int y) {
		if (1 <= x && x <= 19 && 1 <= y && y <= 19)
			return true;
		else
			return false;
	}
}
