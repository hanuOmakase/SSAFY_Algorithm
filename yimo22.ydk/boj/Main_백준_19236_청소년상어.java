import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_19236_청소년상어 {
	static final int[][] dir = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
	static Fish[][] mp;
	static List<Fish> fishs;
	static int answer;
	public static void main(String[] args) throws Exception {
		init();

		// start
		Solve(new Shark(0, 0, -1, 0), fishs);
		System.out.println(answer);
	}

	static void Solve(Shark shark, List<Fish> list) {
		// copy
		List<Fish> curFish = new ArrayList<Fish>();
		Fish[][] map = new Fish[4][4];
		for (int i = 0; i < list.size(); i++) {
			Fish c = list.get(i);
			Fish e = new Fish(c.number, c.x, c.y, c.d, c.isAlive);
			curFish.add(e);
			map[e.x][e.y] = e;
		}
		
		// shark 가 현재 위치에서 먹음
		// state update
		Fish eaten = map[shark.x][shark.y];
		shark.cnt += eaten.number;
		shark.d = eaten.d;
		eaten.isAlive = false;
		answer = Math.max(answer, shark.cnt);
		
		// fish Move
		for (Fish cur : curFish) {
			if (!cur.isAlive)
				continue;

			// 주위 8방향을 보고 이동가능한지 확인
			int nd = cur.d;
			int rep;
			for (rep = 0; rep < 8; rep++, nd = (nd + 1) % 8) {
				int nx = cur.x + dir[nd][0];
				int ny = cur.y + dir[nd][1];

				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (shark.x == nx && shark.y == ny))
					continue;
				
				break;
			}
			
			// 물고기가 이동불가능한 경우 -> 이동안함
			if(rep > 0 && nd == cur.d) continue;
			
			// 물고기 이동
			swap(cur.x, cur.y, nd, map, curFish);
		}
		// next progress
		// 상어 move
		// 먼저 이동할 수 있는지 check
		ArrayList<Integer[]> promising = new ArrayList<>();
		int nx = shark.x, ny = shark.y;
		int nd = shark.d;
		for(int i=0;i<4;i++) {
			nx += dir[nd][0];
			ny += dir[nd][1];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			if(!map[nx][ny].isAlive) continue;
			
			promising.add(new Integer[] {nx,ny});
		}
		
		// 실제로 상어 move
		for(Integer[] nxt : promising) {
			Solve(new Shark(nxt[0], nxt[1], nd, shark.cnt), curFish);
		}
	}
	static void swap(int x, int y, int d, Fish[][] map, List<Fish> list) {
		int nx = x + dir[d][0];
		int ny = y + dir[d][1];
		
		Fish cur = list.get(map[x][y].number-1);
		Fish nxt = list.get(map[nx][ny].number - 1);
		
		cur.x = nx;
		cur.y = ny;
		cur.d = d;
		nxt.x = x;
		nxt.y = y;
		
		map[x][y] = nxt;
		map[nx][ny] = cur;
	}
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		mp = new Fish[4][4];
		fishs = new ArrayList<Fish>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Fish e = new Fish(num, i, j, d - 1, true);
				fishs.add(e);
				mp[i][j] = e;
			}
		}
		// 물고기의 번호대로 정렬
		Collections.sort(fishs, (a, b) -> {
			return a.number - b.number;
		});
	}

	static class Shark {
		int x, y, d;
		int cnt;

		public Shark(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

	static class Fish {
		int x, y, d;
		int number;
		boolean isAlive;

		public Fish(int num, int x, int y, int d, boolean isAlive) {
			this.number = num;
			this.x = x;
			this.y = y;
			this.d = d;
			this.isAlive = isAlive;
		}
	}
}
