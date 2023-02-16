package CKY.study._2;
import java.util.*;
import java.io.*;

public class _20056 {
	static int size;
	static List<FireBall> globalFBList = new ArrayList<>();
	static Queue<FireBall>[][] q;

	static int[] xDir = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] yDir = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		int fbs = Integer.parseInt(st.nextToken());
		int move = Integer.parseInt(st.nextToken());

		q = new LinkedList[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				q[i][j] = new LinkedList<>();
		}

		while (fbs-- > 0) {
			st = new StringTokenizer(br.readLine());
			globalFBList.add(new FireBall(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		while (move-- > 0) {
			moveFireBall();
			// System.out.println(globalFBList + " - after move");
			findSameLocFireBall();
			// System.out.println(globalFBList + " - after same loc fireball merge");
		}

		int sumM = 0;
		for (int i = 0; i < globalFBList.size(); i++)
			sumM += globalFBList.get(i).m;
		System.out.println(sumM);
	}

	// 파이어볼이 움직인다. (s * dir)
	// arr의 양끝은 연결되어있다.
	// ->
	// 움직인 이후에 같은위치는 합쳐진다. (규칙)
	public static void moveFireBall() {
		for (FireBall fb : globalFBList) {
			// s 를 size보다 작게 만들고, size를 더해서 양수로 만들어 준 후, 모듈러
			fb.x = (size + fb.x + (fb.s % size) * xDir[fb.d]) % size;
			fb.y = (size + fb.y + (fb.s % size) * yDir[fb.d]) % size;
			q[fb.x][fb.y].add(fb);
		}
		globalFBList.clear();
	}

	// 여러 위치에서 충돌나는 경우도 고려
	public static void findSameLocFireBall() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				// 현재 위치에 2개 이상의 파이어볼이 없다.
				if (q[i][j].size() <= 1) {
					while (!q[i][j].isEmpty())
						globalFBList.add(q[i][j].poll());
					continue;
				}

				List<FireBall> sameLocFireBall = new ArrayList<>();
				while (!q[i][j].isEmpty())
					sameLocFireBall.add(q[i][j].poll());

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
}

class FireBall {
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