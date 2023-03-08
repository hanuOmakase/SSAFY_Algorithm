
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922 { // 1922. 네트워크 연결
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int N; // 컴퓨터의 수
	static int M; // 선의 수
	static Edge[] edgeList; // 선 리스트
	static int[] parents; // 루트노드	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N];
		edgeList = new Edge[M];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edgeList); // 비용 오름차순으로 정렬
		
		int min = 0; // 모든 컴퓨터 연결에 필요한 최소 비용
		int cnt = 0; // 연결된 선 개수
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) { // 두 컴퓨터 간 연결이 되면 (사이클 발생 x)
				min += edge.weight;
				if(++cnt == N - 1) break; // 모든 컴퓨터가 연결된 상태
			}
		}
		
		System.out.println(min);
	}
	
	public static int findSet(int x) {
		if (x == parents[x]) return x;
		return parents[x] = findSet(parents[x]);
	}
	
	public static boolean union(int x, int y) { // 같은 집합이면 연결했을 때 사이클 발생 -> union 하지 않음 (false)
		int rootX = findSet(x);
		int rootY = findSet(y);
		
		if (rootX == rootY) return false;
		parents[rootY] = rootX;
		return true;
	}
}
