package swexpert;
import java.io.InputStreamReader;

import java.util.*;
import java.io.*;
public class __1285 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+1).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Math.abs(Integer.parseInt(st.nextToken()));
			}
			
			// sorting
			Arrays.sort(arr);
			
			// counting
			sb.append(arr[0]).append(" ");
			int cnt = 0;
			for(int i=0; i< arr.length; i++) {
				if(arr[i] != arr[0]) break;
				cnt++;
			}
			sb.append(cnt);
			
			// out
			System.out.println(sb.toString());
		}
	}
	private static class Node{
		int dist, pos;

		public Node(int dist, int pos) {
			super();
			this.dist = dist;
			this.pos = pos;
		}
		
	}
}
