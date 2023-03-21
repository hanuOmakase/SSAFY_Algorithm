package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_숨바꼭질3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] graph = new int [100001];
		Arrays.fill(graph, Integer.MAX_VALUE);
		graph[N] = 0;
		int curr = N;
		int time = 0;
		Deque<Integer[]> q = new ArrayDeque<Integer[]>();
		q.offer(new Integer[] {curr, time});
		while(q.getFirst()[0] != K) {
			curr = q.peek()[0];
			time = q.poll()[1];
			graph[curr] = time;
			int nCurr = curr * 2;
			int nTime = time;
			if(nCurr >= 0 && nCurr < 100001 && nTime < graph[nCurr])
				q.addFirst(new Integer[] {nCurr, nTime});
			nCurr = curr + 1;
			nTime = time + 1;
			if(nCurr >= 0 && nCurr < 100001 && nTime < graph[nCurr])
				q.addLast(new Integer[] {nCurr, nTime});
			nCurr = curr - 1;
			if(nCurr >= 0 && nCurr < 100001 && nTime < graph[nCurr])
				q.addLast(new Integer[] {nCurr, nTime});
		}
		System.out.println(q.poll()[1]);
	}
}
