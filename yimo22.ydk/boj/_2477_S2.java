
import java.util.*;

public class _2477_S2 {
	public static void main(String[] args) {
		// 넓이 구하기 - 수학

		int[] vertic = new int[3];
		int[] horiz = new int[3];

		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		int p1 = 0, p2 = 0;
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < 6; i++) {
			int d, len;
			d = sc.nextInt();
			len = sc.nextInt();
			list.add(new Node(d, len));

		}
		int W = 0, H = 0, w1 = 0, h1 = 0;
		for (int i = 0; i < list.size(); i++) {
			int nnxt = (i + 2) % list.size();
			int nxt = (i + 1) % list.size();
			int nnnxt = (i + 3) % list.size();
			if (list.get(i).dir == list.get(nnxt).dir && list.get(nxt).dir == list.get(nnnxt).dir) {
				int prev = (i + list.size() - 1) % list.size();
				W = list.get(prev).dist;
				w1 = list.get(nxt).dist;
				h1 = list.get(nnxt).dist;
				H = list.get(i).dist + list.get(nnxt).dist;
				break;
			}
		}

		System.out.println(price * (W * H - w1 * h1));
	}

	static class Node {
		int dir;
		int dist;

		public Node(int d, int dist) {
			this.dir = d;
			this.dist = dist;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return dir + " " + dist;
		}
	}
}
