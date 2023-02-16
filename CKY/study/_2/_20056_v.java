package CKY.study._2;
import java.util.*;
import java.io.*;

public class _20056_v {
	static int size;
	static List<FireBall> globalFBList = new ArrayList<>();
	static FireBallNode[][] q;

	static int[] xDir = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] yDir = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		int fbs = Integer.parseInt(st.nextToken());
		int move = Integer.parseInt(st.nextToken());

		q = new FireBallNode[size][size];
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++)
				q[i][j] = new FireBallNode();
		}

		while (fbs-- > 0) {
			st = new StringTokenizer(br.readLine());
			globalFBList.add(new FireBall(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		while (move-- > 0) {
			moveFireBall();
			findSameLocFireBall();
		}

		int sumM = 0;
		for (int i = 0; i < globalFBList.size(); i++)
			sumM += globalFBList.get(i).m;
		System.out.println(sumM);
	}

	public static void moveFireBall() {
		for (FireBall fb : globalFBList) {
			fb.x = (size + fb.x + (fb.s % size) * xDir[fb.d]) % size;
			fb.y = (size + fb.y + (fb.s % size) * yDir[fb.d]) % size;
			q[fb.x][fb.y].innerQ.add(fb);
		}
		globalFBList.clear();
	}

	// 여러 위치에서 충돌나는 경우도 고려
	public static void findSameLocFireBall() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				// 현재 위치에 2개 이상의 파이어볼이 없다.
				if (q[i][j].innerQ.size() <= 1) {
					while (!q[i][j].innerQ.isEmpty())
						globalFBList.add(q[i][j].innerQ.poll());
					continue;
				}

				List<FireBall> sameLocFireBall = new ArrayList<>();
				while (!q[i][j].innerQ.isEmpty())
					sameLocFireBall.add(q[i][j].innerQ.poll());

				mergeFireBall(sameLocFireBall, i, j); // 합쳐주는 작업
			}
		}
	}

	public static void mergeFireBall(List<FireBall> sameLocFB, int x, int y) {
		int m = 0;
		int s = 0;

		int evenCount = 0;
		int oddCount = 0;

		for (int i = 0; i < sameLocFB.size(); i++) {
			m += sameLocFB.get(i).m;
			s += sameLocFB.get(i).s;

			if (sameLocFB.get(i).d % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		m /= 5;
		if (m == 0)
			return;

		s /= sameLocFB.size();

		if (evenCount == sameLocFB.size() || oddCount == sameLocFB.size()) {
			for (int i = 0; i < 8; i += 2)
				globalFBList.add(new FireBall(x, y, m, s, i));
		} else {
			for (int i = 1; i < 8; i += 2)
				globalFBList.add(new FireBall(x, y, m, s, i));
		}
	}
	
	static class FireBall {
		int x, y, m, s, d;
		public FireBall(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return String.format("%d %d %d %d %d %s", x, y, m, s, d);
		}
	}
	
	static class FireBallNode{
		Queue<FireBall> innerQ = new LinkedList<>();
	}
}

