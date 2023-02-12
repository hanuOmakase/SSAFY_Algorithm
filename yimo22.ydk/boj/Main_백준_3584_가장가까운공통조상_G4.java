import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_3584_가장가까운공통조상_G4 {
	static final char endl = '\n';
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int V = Integer.parseInt(br.readLine());

			int[] parent = new int[V + 1];
			List<Integer>[] children = new List[V + 1];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				children[i] = new ArrayList<>();
			}
			/* 간선 정보 */
			for (int i = 0; i < V - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int p, c;
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				parent[c] = p;
				children[p].add(c);
			}

			int n1, n2;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());

			// n1과 n2가 같은 경우
			if (n1 == n2) {
				sb.append(n1).append("\n");
				continue;
			}
			// n1과 n2의 공통조상 찾기
			// find root
			int root = -1;
			for(int i=1;i<parent.length;i++) {
				if(parent[i] == i) {
					root = i;
					break;
				}
			}
			
			// n1 -> 1까지 올라가면서 정보들 저장
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			int cur = n1;
			while (cur != root) {
				l1.add(cur);
				cur = parent[cur];
			}
			l1.add(root);

			// n2 -> 1 까지 올라가면서 해당 노드 정보들 저장
			ArrayList<Integer> l2 = new ArrayList<Integer>();
			cur = n2;
			while (cur != root) {
				l2.add(cur);
				cur = parent[cur];
			}
			l2.add(root);

			Collections.reverse(l1);
			Collections.reverse(l2);
			boolean found = false;
			for (int i = 1; i < Math.min(l1.size(), l2.size()); i++) {
				if(l1.get(i) != l2.get(i)) {
					found = true;
					sb.append(l1.get(i-1)).append(endl);
					break;
				}
			}
			if(!found) sb.append(l1.get(l1.size()-1)).append(endl);
		} // test for문 end
		System.out.println(sb.toString());
	}
}
