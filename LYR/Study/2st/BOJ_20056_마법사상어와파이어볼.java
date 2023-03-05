package Study;

import java.io.*;
import java.util.*;

//방향 배열
// 7 0 1
// 6   2
// 5 4 3
//
// -- 중요 POINT --
//  N번 행 다음에는 다시 1번 행으로 이동
//  N번 열 다음에는 다시 1번 열로 이동
//
// -- 이동 명령 시 --
// 파이어볼은 방향 d로 속력 s칸 이동
// 이동하는 중에 같은 칸에 여러개의 파이어볼 존재 O
//
// -- 이동 후 같은 칸에 여러개의 파이어볼이 있다면 --
// 1.같은 칸에 있는 파이어볼들은 하나로 합쳐짐
// 2.합쳐진 파이어볼은 4개로 나누어짐
// 3.나누어진 파이어볼의 질량, 속력, 방향은 다음과 같음
//		질량은 합쳐진 파이어볼 질량 SUM / 5
//		속력은 합쳐진 파이어볼 속력 SUM / 합쳐진 파이어볼의 개수
//		합쳐진 파이어볼들의 방향이 모두 홀수 or 모두 짝수 => 0, 2, 4, 6
//					            그렇지 않으면 1, 3, 5, 7
// 4.질량이 0인 파이어볼은 소멸
//
// -- K번 이동 후 남은 파이어볼의 질량=? --

public class BOJ_20056_마법사상어와파이어볼 {
	static int N; // 격자의 크기
	static int M; // 파이어볼의 개수
	static int K; // 파이어볼의 이동 턴 수
	static int currFireBallNum = 0; // 현재 파이어볼의 개수, 새로 추가되는 파이어볼의 id = ++currFireBallNum
	static int sumM = 0; // 남은 파이어볼의 질량 합
	static Queue<Integer>[][] board; // 격자
	static Map <Integer, FireBall> fireBalls; // 파이어볼들을 담는 class 연결리스트
	static int[][] dir = { // 파이어볼의 방향 좌표 dictionary
			{-1, 0}, // 0번 방향
			{-1, 1}, // 1번 방향
			 {0, 1}, // 2번 방향
			 {1, 1}, // 3번 방향
			 {1, 0}, // 4번 방향
			{1, -1}, // 5번 방향
			{0, -1}, // 6번 방향
			{-1, -1} // 7번 방향
	};
	static int[] AllOddEven = {0, 2, 4, 6};
	static int[] NotAllOddEven = {1, 3, 5, 7};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 변수 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 격자 생성
		board = new LinkedList[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++)
			for(int j = 1; j < N + 1; j++)
				board[i][j] = new LinkedList<Integer>();
		
		currFireBallNum = M;
		
		// 파이어볼 정보 입력 & Map에 파이어볼 넣기
		fireBalls = new HashMap<Integer, FireBall>();
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls.put(i, new FireBall(i, r, c, m, s, d));
			board[r][c].offer(i); // 격자에 파이어볼 넣기
		}
		
		// K턴 동안 이동시키기
		for(int i = 0; i < K; i++) {
			move(); // 파이어볼 이동
			checkFireBall();
		}
		
		// 남은 파이어볼들의 질량 합 구하기 & 출력
		getSumM();
		System.out.println(sumM);
	}

	private static void move() { // 파이어볼 이동하기
		for(int key : fireBalls.keySet()) {
			FireBall tmp = fireBalls.get(key);
			
			int y = tmp.getR(); // 현재 y 좌표
			int x = tmp.getC(); // 현재 x 좌표
			
			// 이동 후 도착하는 좌표 구하기
			int ny = y + (dir[tmp.getD()][0] * tmp.getS());
			int nx = x + (dir[tmp.getD()][1] * tmp.getS());
			
			if(ny > N)
				ny %= N;
			if(ny < 0) {
				ny = Math.abs(ny);
				ny = N - (ny % N);
			}
			if(nx > N)
				nx %= N;
			if(nx < 0) {
				nx = Math.abs(nx);
				nx = N - (nx % N);
			}
			if(ny == 0) ny = N;
			if(nx == 0) nx = N;
			
			// 새로운 좌표값을 가진 파이어볼 갱신
			tmp.setR(ny);
			tmp.setC(nx);
			board[y][x].poll();
			fireBalls.put(key, tmp);
			board[ny][nx].offer(key);
		}
	}
	
	private static void checkFireBall() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(board[i][j].size() > 1) { // 한 칸에 여러 파이어볼이 있으면
					mergeFireBall(i, j);
				}
			}
		}
	}
	
	private static void mergeFireBall(int y, int x) {
		int fireBallCnt = board[y][x].size();
		int newM = 0;
		int newS = 0;
		int[] dirList = new int [fireBallCnt];

		for(int i = 0; i < fireBallCnt; i++) {
			int index = board[y][x].poll();
			FireBall tmp = fireBalls.get(index);
			newM += tmp.getM();
			newS += tmp.getS();
			dirList[i] = tmp.getD();
			fireBalls.remove(index);
		}
		newM /= 5;
		newS /= fireBallCnt;
		
		if(newM <= 0) return; // 질량이 0 이하면 소멸(새로 생성하지 않고 리턴)
		
		boolean isAllOddEven = true;
		boolean isOdd;
		if(dirList[0] % 2 == 0) isOdd = true;
		else isOdd = false;
		for(int i = 1; i < fireBallCnt; i++) {
			if((dirList[i] % 2 == 0) != isOdd) {
				isAllOddEven = false;
				break;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(isAllOddEven)
				fireBalls.put(++currFireBallNum, new FireBall(currFireBallNum, y, x, newM, newS, AllOddEven[i]));
			else
				fireBalls.put(++currFireBallNum, new FireBall(currFireBallNum, y, x, newM, newS, NotAllOddEven[i]));
			board[y][x].offer(currFireBallNum);
		}
	}
	
	private static void getSumM() { // 남은 파이어볼 질량합 구하기
		for(int key : fireBalls.keySet())
			sumM +=fireBalls.get(key).getM();
	}
	
	static class FireBall{
		int id; // 파이어볼의 번호
		
		int r; // 파이어볼의 현재 위치 r행(Y)
		int c; // 파이어볼의 현재 위치 c열(X)
		
		int m; // 파이어볼의 질량 m
		int s; // 파이어볼의 속력 s
		int d; // 파이어볼의 방향 d
		
		public FireBall(int id, int r, int c, int m, int s, int d) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public int getId() {
			return id;
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public int getM() {
			return m;
		}

		public int getS() {
			return s;
		}

		public int getD() {
			return d;
		}
	}
}

// 의식의 흐름
// 1. 일단 방향 정보를 저장하고 바로 접근 가능하게 할 dir 2차원 배열 선언 dir = Y,X {0번 방향{-1, 0}, 1번 방향{-1, 1} ...}
// 2. 각 파이어볼들은 class로 생성해서  X배열X => 
//    새로 생기는 파이어볼 때문에 X연결리스트X => 
//    연결 리스트로 구현할 경우 index 값이 바뀌기 때문에 Map으로 정보 관리
// 3. 파이어볼에 XisAlive booleanX 변수 추가해서 살아있는지 확인할 수 있게
// 4. X이동할때 파이어볼이 살아있는지부터 확인X
// 5. X합쳐져서 분열하게 된 파이어볼들의 데이터는 필요하지 않음으로 매번 isAlive로 확인하지 않고X
// 6. 바로 삭제하기

// 건영 오빠가 알려준 2차원 Queue 만드는 방법
// static Queue<FireBall>[][] q;
// q = new LinkedList[size][size];

// 격자 자료구조를 Queue로 하면 파이어볼이 꼬일 가능성이 있지 않을까
// but 파이어볼이 id 오름차순으로 뺐다가 넣어지기 때문에 꼬이진 않을 것 같음
