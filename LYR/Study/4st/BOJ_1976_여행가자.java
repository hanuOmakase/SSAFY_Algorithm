package DisJointSet;

import java.io.*;
import java.util.*;

public class BOJ_1976_여행가자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int [N + 1];
		for(int i = 1; i <= N ;i++)
			p[i] = i;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int city = Integer.parseInt(st.nextToken());
				if(city == 0) continue;
				union(i, j, p);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] cityList = new int[M];
		for(int i = 0; i < M; i++)
			cityList[i] = Integer.parseInt(st.nextToken());
		
		int currParent = find(cityList[0], p);
		for(int i = 1; i < M; i++) {
			int nextParent = find(cityList[i], p);
			if(currParent != nextParent) {
				System.out.println("NO");
				return;
			}
			currParent = nextParent;
		}
		
		System.out.println("YES");
	}
	public static int find(int x, int[] p) {
		if(p[x] == x) return x;
		return find(p[x], p);
	}
	
	public static void union(int i, int j, int[] p) {
		int iParent = find(i, p);
		int jParent = find(j, p);
		if(iParent < jParent)
			p[jParent] = iParent;
		else
			p[iParent] = jParent;
	}
}
