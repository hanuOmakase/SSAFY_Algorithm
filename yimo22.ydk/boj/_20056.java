import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _20056 {
	static int N, M, K;
	static final int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	static List<Node> nodeList;
	static ArrayList<Node>[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nodeList = new ArrayList<>();
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int r, c, m, s, d;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(r - 1, c - 1, m, s, d));
		}

		System.out.println(Solve());
	} // end main
	

	private static int Solve() {
		// TODO Auto-generated method stub
		while (K > 0) {
			move();
			divideNode();
			K--;
		}

		// 남아있는 파이어볼 질량의 합
		int answer = 0;
		for (Node cur : nodeList)
			answer += cur.m;

		return answer;
	} 

	private static void divideNode() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].isEmpty())
					continue;

				// start
				if (map[i][j].size() == 1) {
					nodeList.add(map[i][j].get(0));
				} else {
					// Node 가 2개 이상 있을 경우
					int sm = 0; // mass sum
					int ss = 0; // velo sum
					for (Node cur : map[i][j]) {
						sm += cur.m;
						ss += cur.s;
					}

					int newMass = sm / 5;
					int newSpeed = (int) Math.floor((double) ss / map[i][j].size());
					// ! 질량이 0이면 소멸
					if (newMass == 0){
						map[i][j].clear(); // <- 0 이면 소멸되지 않고 넘어가게 됨
						continue;
					}

					// 모두 짝수 or 홀수 : 0
					// 이외 : 1
					int offset = checkDirection(map[i][j]);

					// 4개의 Node로 나누어짐
					for (int cnt = 0; cnt < 4; cnt++) {
						nodeList.add(new Node(i, j, newMass, newSpeed, cnt * 2 + offset));
					}
				}

				map[i][j].clear();
			}
		}
	}

	private static int checkDirection(ArrayList<Node> arrayList) {
		// TODO Auto-generated method stub
		// 모두 홀수 or 모두 짝수 이면 방향은 짝수

		int odd = 0, even = 0;
		for (Node cur : arrayList) {
			if (cur.d % 2 != 0)
				odd++;
			else
				even++;
		}
		if ((odd == arrayList.size()) || (even == arrayList.size()))
			return 0;
		return 1;
	}

	private static void move() {
		// TODO Auto-generated method stub
		// nodeList 에 있는 모든 노드를 이동
		int tmp = (int) Math.ceil(1000.0 / N);
		for (Node cur : nodeList) {
			int nx = (cur.x + (tmp + 1) * N + dir[cur.d][0] * cur.s) % N;
			int ny = (cur.y + (tmp + 1) * N + dir[cur.d][1] * cur.s) % N;
			map[nx][ny].add(new Node(nx, ny, cur.m, cur.s, cur.d));
		}
		nodeList.clear();
	}

	private static class Node {
		int x, y;
		int m, s, d; // mass, speed, direction

		public Node(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
} // end class
