package swexpert;
import java.util.*;

public class __1493 {
	static Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		init();
		for (int tc = 0; tc < T; tc++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();

			int[] p = { map.get(a)[0], map.get(a)[1] };
			int[] q = { map.get(b)[0], map.get(b)[1] };
			int x = p[0] + q[0];
			int y = p[1] + q[1];
			int res = counting(x, y);
			System.out.printf("#%d %d\n", tc+1, res);
		}
	}

	private static int counting(int i, int j) {
		// TODO Auto-generated method stub
		int idx = 0, K = 2, x= 1;
		while(idx <= Integer.MAX_VALUE) {
			if( (x == i) && ((K-x) == j)) {
				return ++idx;
			}
			
			if(K-x > 0) {
				x++;
				++idx;
			} else {
				K++;
				x=1;
			}
		}
		return -1;
	}

	/** 해당 하는 숫자를 넣음 */
	private static void init() {
		// TODO Auto-generated method stub
		int K = 2, x = 1;
		int idx = 0;
		while (idx <= 10000) {
			if (K - x > 0) {
				map.put(++idx, new Integer[] { x, K - x });
				x++;
			} else {
				K++;
				x = 1;
			}
		}
	}
}
