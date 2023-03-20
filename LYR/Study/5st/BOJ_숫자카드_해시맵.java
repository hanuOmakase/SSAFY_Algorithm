package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_숫자카드_해시맵 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> map = new HashSet<Integer>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			map.add(card);
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(map.contains(card))
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		System.out.println(sb.toString());
	}
}
