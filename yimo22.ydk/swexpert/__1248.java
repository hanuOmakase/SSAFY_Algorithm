package swexpert;

import java.util.*;
import java.io.*;

public class __1248 {
	static int V, E, v1, v2;
	static List<Integer> list;
	static List<Node> nodelist;
	static int number, size;
	static Map<Integer, Node> mp;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("C:\\Users\\rladu\\Downloads\\input(4).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int s, e;
			for (int i = 0; i < E; i++) {
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				list.add(s);
				list.add(e);
			}
			Solve();
			// answer out
			sb.append("#").append(test_case).append(" ").append(number).append(" ").append(size);
			System.out.println(sb.toString());
		}
	}

	private static void Solve() {
		// TODO Auto-generated method stub
		// making tree
		makingTree();

		// start
		search();
		getTreeSize();
	}

	private static void makingTree() {
		// TODO Auto-generated method stub
		// init
		mp = new HashMap<>();
		nodelist = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			Node ptr = new Node(i + 1);
			nodelist.add(ptr);
			mp.put(i + 1, ptr);
		}

		for (int i = 0; i < E; i++) {
			int parent = list.get(i * 2);
			int child = list.get(i * 2 + 1);

			// connect
			Node pn = mp.get(parent);
			Node cn = mp.get(child);

			if (pn.lchild == null) {
				pn.lchild = cn;
			} else {
				pn.rchild = cn;
			}

			cn.parent = pn;
		}

		// update depth
		Queue<Node> q = new LinkedList<>();
		if (mp.get(1).lchild != null)
			q.add(mp.get(1).lchild);
		if (mp.get(1).rchild != null)
			q.add(mp.get(1).rchild);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			cur.depth = cur.parent.depth + 1;

			if (cur.lchild != null)
				q.add(cur.lchild);
			if (cur.rchild != null)
				q.add(cur.rchild);
		}

	}

	private static void getTreeSize() {
		// TODO Auto-generated method stub
		// init
		Queue<Node> q = new LinkedList<>();
		size = 0;
		// start
		q.add(mp.get(number));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			size++;

			if (cur.lchild != null)
				q.add(cur.lchild);
			if (cur.rchild != null)
				q.add(cur.rchild);
		}
	}

	private static void search() {
		// TODO Auto-generated method stub
		// 임의의 두 정점에 대하여, 두 정점의 높이가 같을 때까지 작은 것을 위로 올림
		// n1 : depth 가 큰 노드(올려야 할 노드), n2 : depth 가 작은 노드

		Node n1 = mp.get(v1), n2 = mp.get(v2);
		if (n1.depth < n2.depth) {
			n1 = mp.get(v2);
			n2 = mp.get(v1);
		}

		while (n1.depth != n2.depth) {
			if (n1.idx == n2.idx) {
				number = n1.idx;
				return;
			}
			n1 = n1.parent;
		}

		// 두 노드를 한칸씩 올리며 탐색
		while (n1.idx != 1) {
			if (n1.idx == n2.idx) {
				number = n1.idx;
				return;
			}
			n1 = n1.parent;
			n2 = n2.parent;
		}
		// 공통노드가 루트인 경우
		number = 1;
		return;
	}

	static private class Node {
		int idx;
		int depth;
		Node parent;
		Node lchild;
		Node rchild;

		public Node(int idx) {
			this.idx = idx;
			this.depth = 0;
			this.parent = null;
			this.lchild = null;
			this.rchild = null;
		}

	}
}
