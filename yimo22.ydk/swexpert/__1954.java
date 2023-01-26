import java.util.Scanner;

public class __1954 {
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			// create map
			int _idx = 0;
			int x= 0, y=0, d=0;
			while(true) {
				if(_idx >= Math.pow(N, 2)) break;
				
				map[x][y] = ++_idx;
				
				if(forwarding(x, y, d, N, map)) d = (d+1) % dir.length;
				x += dir[d][0];
				y += dir[d][1];
			}
			
			// map print
			System.out.println("#"+(tc+1));
			for(int[] arr : map){
				for(int w : arr) {
					System.out.print(w + " ");
				}
				System.out.println();
			}
		}
	}
	/**
	 * 진행하면서 방향 전환 여부를 알려주는 함수
	 * @param x
	 * @param y
	 * @param d
	 * @param n
	 * @return
	 */
	private static boolean forwarding(int x, int y, int d, int n, int[][] map) {
		// TODO Auto-generated method stub
		int nx = x + dir[d][0];
		int ny = y + dir[d][1];
		
		if(nx < 0 || nx >= n || ny < 0 || ny >= n) return true;
		if(map[nx][ny] > 0) return true;
		return false;
	}

}
