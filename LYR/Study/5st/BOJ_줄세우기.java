package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_줄세우기 {
	static int N;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList [N + 1];
		for(int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();
		
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			graph[left].add(right);
			degree[right]++;
		}
		
		topologicalSort(degree);
	}
	
	public static void topologicalSort(int[] degree) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v + " ");
			for(int i : graph[v]) {
				degree[i]--;
				if(degree[i] == 0)
					q.offer(i);
			}
				
		}
		System.out.println(sb.toString());
	}
}
