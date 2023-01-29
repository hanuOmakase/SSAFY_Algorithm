package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1037 {
	public static void main(String[] args) throws Exception {
		// 패리티 성질을 가지고 있는지 판단
		// 아닐경우, 바꿀 비트를 출력
		// 행렬은 1부터 시작!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		if (check(arr))
			System.out.println("OK");
		else {
			System.out.println(correcting(arr));
		}
	}

	/** correction */
	private static String correcting(int[][] arr) {
		// 행이 홀수 & 열이 홀수 find
		int N = arr.length;
		boolean[] row = new boolean[N];
		boolean[] col = new boolean[N];
		for(int i=0;i<N;i++) {
			int cnt = 0;
			for(int j=0;j<N;j++) if(arr[i][j] == 1) cnt++;
			if( (cnt % 2) != 0) row[i] = true; 
		}
		for(int i=0;i<N;i++) {
			int cnt = 0;
			for(int j=0;j<N;j++) if(arr[j][i] == 1) cnt++;
			if( (cnt % 2) != 0) col[i] = true; 
		}
		
		// correcting
		for(int i=0;i<N;i++) {
			if(row[i]) {
				for(int j=0;j<N;j++) {
					if(col[j]) {
						arr[i][j] = (arr[i][j] == 0) ? 1 : 0;
						if(check(arr)) return String.format("Change bit (%d,%d)", i+1, j+1);
						arr[i][j] = (arr[i][j] == 0) ? 1 : 0;
					}
				}
			}
		}
		
		return "Corrupt";
	}

	/** 패리티 인지 체크하는 함수 */
	private static boolean check(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int colCnt = 0;
			int rowCnt = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1)
					colCnt++;
				if (arr[j][i] == 1)
					rowCnt++;
			}
			if ((colCnt % 2 != 0) || (rowCnt % 2 != 0))
				return false;
		}
		return true;
	}
}
