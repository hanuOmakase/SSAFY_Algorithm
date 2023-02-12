import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_공통조상 {
	static int V, E;
	static Node[] nodes;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int s, e;
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			nodes = new Node[V+1];
			for(int i=1;i<V+1;i++) nodes[i] = new Node(i);
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int p, c;
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				if(nodes[p].lchild > 0)
					nodes[p].rchild = c;
				else
					nodes[p].lchild = c;
				
				nodes[c].parent = p;
			}
			calDepth(1, new boolean[V+1]);
			int cIdx = lcs(s, e);
			int cnt = calCount(cIdx, new boolean[V+1]);
			
			
			sb.append("#").append(tc+1).append(" ").append(cIdx).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int calCount(int idx, boolean[] visited) {
		int cnt = 1;
		visited[idx] = true;
		Node cur = nodes[idx];
		if(cur.lchild > 0 && !visited[cur.lchild]) {
			visited[cur.lchild] = true;
			cnt += calCount(cur.lchild, visited);
		}
		
		if(cur.rchild > 0 && !visited[cur.rchild]) {
			visited[cur.rchild] = true;
			cnt += calCount(cur.rchild, visited);
		}
		
		return cnt;
		
	}
	static int lcs(int s, int e) {
		Node deep = nodes[s];
		Node shallow = nodes[e];
		if(deep.depth < shallow.depth) {
			deep = nodes[e];
			shallow = nodes[s];
		}
		
		while(deep.depth != shallow.depth) {
			deep = nodes[deep.parent];
		}
		
		while(deep.idx != shallow.idx) {
			deep = nodes[deep.parent];
			shallow = nodes[shallow.parent];
		}
		
		return deep.idx;
	}
	static void calDepth(int idx, boolean[] visited) {
		Node cur = nodes[idx];
		visited[idx] = true;
		
		if(cur.lchild > 0 && !visited[cur.lchild]) {
			visited[cur.lchild] = true;
			nodes[cur.lchild].depth = cur.depth + 1;
			calDepth(cur.lchild, visited);
		}
		
		if(cur.rchild > 0 && !visited[cur.rchild]) {
			visited[cur.rchild] = true;
			nodes[cur.rchild].depth = cur.depth + 1;
			calDepth(cur.rchild, visited);
		}
	}
	static class Node{
		int idx, depth;
		int parent;
		int lchild, rchild;
		public Node(int i) {
			this.idx = i;
			depth = 0;
			parent = idx;
			lchild = -1;
			rchild = -1;
		}
	}
}
