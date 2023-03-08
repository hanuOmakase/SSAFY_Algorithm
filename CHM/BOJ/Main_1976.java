
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 여행 계획에 속한 도시들이 한 그래프에 있는지 확인

public class Main_1976 { // 1976. 여행 가자
	
	static int N; // 도시의 수
	static int M; // 여행 계획에 속한 도시의 수
	static int[] parents; // 각 도시들의 부모 인덱스 저장
	static int[] plan; // 여행 계획
	static String ans = "YES"; // 출력값
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i; // 처음에는 자기 자신이 부모가 됨
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int connect = Integer.parseInt(st.nextToken()); // 연결 유무 (1이면 연결, 0이면 연결x)
				if (connect == 1) {
					union(i, j);
				}
			}
		}
		
		// 여행 계획
		plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		// 연결된 두 여행지가 한 집합에 있는지 찾기
		for (int i = 1; i < M; i++) {
			if (findSet(plan[i - 1]) != findSet(plan[i])) {
				ans = "NO";
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int findSet(int x) { // x를 포함하는 집합 찾기
		if (x == parents[x]) { return x; }
		return findSet(parents[x]);
	}
	
	public static void union(int x, int y) { // x와 y를 포함하는 두 집합 합치기
		if (findSet(y) == findSet(x)) { return; }
		parents[findSet(y)] = findSet(x);
		return;
	}
}
