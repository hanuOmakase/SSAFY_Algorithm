package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_네트워크연결 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] parent = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		ArrayList<Integer[]> values = new ArrayList<Integer[]>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			values.add(new Integer[] {a, b, c});
		}
		Collections.sort(values, (a, b) -> a[2] - b[2]);
		int totalValue = 0;
		int index = 0;
		int connected = 0;
		while(connected < N && index < M) {
			int a = values.get(index)[0];
			int b = values.get(index)[1];
			if(find(a, parent) != find(b, parent)) {
				union(a, b, parent);
				connected++;
				totalValue += values.get(index)[2];
			}
			index++;
		}
		System.out.println(totalValue);
	}
	public static int find(int x, int parent[]) {
		if(parent[x] == x)
			return x;
		return find(parent[x], parent);
	}
	public static void union(int a, int b, int parent[]) {
		int aParent = find(a, parent);
		int bParent = find(b, parent);
		if(aParent < bParent)
			parent[bParent] = aParent;
		else
			parent[aParent] = bParent;
	}
}
