package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_숫자카드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] playerCard = new int [N];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			playerCard[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[] inputCard = new int [M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			inputCard[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(playerCard);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int start = 0;
			int end = N - 1;
			int card = inputCard[i];
			
			while(true) {
				if(start == end) {
					if(playerCard[start] != card)
						sb.append("0 ");
					else
						sb.append("1 ");
					break;
				}
				int mid = (start + end) / 2;
				if(card == playerCard[mid]) {
					sb.append("1 ");
					break;
				}
				else if(card < playerCard[mid]) 
					end = mid;
				else 
					start = ++mid;
			}
		}
		System.out.println(sb.toString());
	}
}
