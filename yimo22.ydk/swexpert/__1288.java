package swexpert;

import java.util.*;
import java.io.*;

public class __1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			sb.append("#").append(tc+1).append(" ");
			
			sb.append(Solve(N));
			
			System.out.println(sb.toString());
		}
	}

	private static int Solve(int N) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[10];
		
		int answer = 0;
		int value = N;
		while(!check(visited)) {
			String str = Integer.toString(value);
			for (int i = 0; i < str.length(); i++) {
				visited[str.charAt(i)-'0'] = true;
			}
			answer += N;
			value += N;
		}
		return answer;
	}
	private static boolean check(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
}
