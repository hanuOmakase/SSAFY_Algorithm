package CKY.study._4;

import java.io.*;
import java.util.*;

/*
 * 
 * 
 */
public class 네트워크연결 {
	
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int nodes = Integer.parseInt(br.readLine());
		int lines = Integer.parseInt(br.readLine());
		
		p = new int[nodes + 1];
		
		for(int i = 0; i<p.length; i++)
			p[i] = i;
		
		Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		
		while(lines-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			q.offer(new Node(s, e, w));
		}
		
		System.out.println(kruskal(q, nodes));
	}
	public static int kruskal(Queue<Node> q, int nodeSize) {
		int edgeCount = 0;
		int wSum = 0;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(union(n.s, n.e)) {
				edgeCount++;
				wSum += n.w;
			}
			
			if(edgeCount + 1 == nodeSize)
				break;
		}
		return wSum;
	}
	
	public static int find(int n) {
		if(p[n] == n )
			return n;
		return p[n] = find(p[n]);
	}
	
	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		
		if(n1 == n2)
			return false;
		
		if(n1 > n2)
			p[n1] = n2;
		else
			p[n2] = n1;
		return true;
	}
	
	static class Node{
		int s, e, w;
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
}

