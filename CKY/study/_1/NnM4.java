package CKY.study._1;

import java.util.*;
import java.io.*;

// 중복 조합
public class NnM4 {
	
	static int[] temp;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		
		comb(m, 0, 1);
	} 
	
	public static void comb(int limit, int p, int idx) {
		if(limit == p) {
			Arrays.stream(temp).forEach(e -> System.out.print(e + " "));
			System.out.println();
			return;
		}
		
		for(int i = idx; i<=n; i++) {
			temp[p] = i;
			comb(limit, p+1, i);
		}
	}
}
