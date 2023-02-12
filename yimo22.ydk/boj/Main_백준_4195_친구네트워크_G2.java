import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_4195_친구네트워크_G2 {
	static final int MAX_NODE = 200_000;
	static int[] root; // i번째 원소의 부모노드 index저장
	static int[] rank; // 해당 노드를 루트로 하는 sub set의 크기
	static Node[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<T; tc++) {
			int F = Integer.parseInt(br.readLine());
			int _IDX = 0;
			StringTokenizer st;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			list = new Node[MAX_NODE];
			root = new int[MAX_NODE];
			rank = new int[MAX_NODE];
			for(int i=0;i<root.length;i++) root[i] = i;
			Arrays.fill(rank, 1);
			// start
			while(F>0) {
				st = new StringTokenizer(br.readLine());
				String n1 = st.nextToken();
				String n2 = st.nextToken();
				
				// checking
				if(!map.containsKey(n1)) {
					list[_IDX] = new Node(n1);
					root[_IDX] = _IDX;
					rank[_IDX] = 1;
					map.put(n1, _IDX++);
				}
				if(!map.containsKey(n2)) {
					list[_IDX] = new Node(n2);
					root[_IDX] = _IDX;
					rank[_IDX] = 1;
					map.put(n2, _IDX++);
				}
				
				int idx1, idx2;
				idx1 = map.get(n1);
				idx2 = map.get(n2);
				
				union(idx1, idx2);
				sb.append(rank[getParent(idx1)]).append("\n");
				F--;
			}
		}
		System.out.println(sb.toString());
	} // main end
	static int getParent(int a) {
		if(root[a] == a) return a;
		else return root[a] = getParent(root[a]);
	}
	static boolean union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		// cycle check
		if(pa == pb) return false;
		
		// 더 작은 rank를 큰 집합 밑으로 Union
		if(rank[pa] < rank[pb]) {
			root[pa] = pb;
			rank[pb] += rank[pa];
		}
		else {
			root[pb] = pa;
			rank[pa] += rank[pb];
		}
		
		return true;
	}
	
	
	
	static class Node{
		String name;
		public Node(String s) {
			this.name = s;
		}
	}
}
