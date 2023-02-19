
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main_17406 { // 17406. 배열 돌리기 4 
	
	private static int[][] origin; // 처음 배열
	private static int[][] arr; // 바뀐 배열
	
	private static int[][] oper; // 연산 저장
	private static int[] order; // 연산 순서 순열
	private static boolean[] isSelected; // 포함 여부 체크
	private static int N;
	private static int M;
	private static int K;
	private static int totalMin = Integer.MAX_VALUE; // 배열 값의 최소 저장
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		oper = new int [K][3];
		order = new int[K];
		isSelected = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			oper[i][0] = Integer.parseInt(st.nextToken()); // r
			oper[i][1] = Integer.parseInt(st.nextToken()); // c
			oper[i][2] = Integer.parseInt(st.nextToken()); // s
		}
		
		perm(0);
		System.out.println(totalMin);
		
	} // end of main
	
	
	/** K개의 연산 중 K개를 뽑아 순서대로 정렬 */
	private static void perm(int cnt) {
		
		if (cnt == K) {
			
			// 원래값 복사해오기
			arr = new int[origin.length][];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = origin[i].clone();
			}
			
			// 회전 연산
			for (int i = 0; i < order.length; i++) {
				rotate(oper[order[i]][0], oper[order[i]][1], oper[order[i]][2]);
			}
			
			// 연산 수행 후 배열 값 구하기
			int curMin = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				int sum = 0;
				for (int j = 0; j < arr[i].length; j++) {
					sum += arr[i][j];
				}
				if (sum < curMin) { curMin = sum; }
			}
			
			// 배열 값의 최소와 비교
			if (curMin < totalMin) { totalMin = curMin; }
			return;
		}
		
		// 연산의 순서를 결정하는 순열을 재귀로 구하기
		for (int i = 0; i < K; i++) {
			if (isSelected[i]) { continue; }
			order[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
		
	}

	
	/** 회전 연산 수행 */
	private static void rotate(int r, int c, int s) {
		
		// (r-s, c-s)    (r-s, c+s)
		// (r+s, c-s)    (r+s, c+s)
		// 회전하는 배열의 크기 [2s+1][2s+1]
		
		for (int i = 0; i < s; i++) { // s겹만큼 회전 수행 반복
		
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			
			int startRow = r - s - 1 + i; // 시작 row
			int startCol = c - s - 1 + i; // 시작 col
			int endRow = r + s - 1 - i; // 끝 row
			int endCol = c + s - 1 - i; // 끝 col
			
			// 위쪽
			for (int col = startCol; col < endCol; col++) {
				q.offer(arr[startRow][col]);
			}

			// 오른쪽
			for (int row = startRow; row < endRow; row++) {
				q.offer(arr[row][endCol]);
			}
			
			// 아래쪽
			for (int col = endCol; col > startCol; col--) {
				q.offer(arr[endRow][col]);
			}
			
			// 왼쪽
			for (int row = endRow; row > startRow; row--) {
				q.offer(arr[row][startCol]);
			}
					
			q.offerFirst(q.pollLast()); // 마지막 원소를 빼서 맨 앞으로 넣음 (= 오른쪽으로 한 칸 밀기, = 시계방향으로 돌리기)
			
			// 값 다시 넣기
			// 위쪽
			for (int col = startCol; col < endCol; col++) {
				arr[startRow][col] = q.poll();
			}
			
			// 오른쪽
			for (int row = startRow; row < endRow; row++) {
				arr[row][endCol] = q.poll();
			}
			
			// 아래쪽
			for (int col = endCol; col > startCol; col--) {
				arr[endRow][col] = q.poll();
			}
			
			// 왼쪽
			for (int row = endRow; row > startRow; row--) {
				arr[row][startCol] = q.poll();
			}
		}
		
	}
	
}