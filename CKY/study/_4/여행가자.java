package CKY.study._4;


import java.util.*;
import java.io.*;

/* TODO
 * 
 * 경로는 상관없고, 최종적으로 갈 수 있는지만 확인
 *
 */

public class 여행가자 {

	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int node = Integer.parseInt(br.readLine());
		br.readLine();
		p = new int[node + 1];
		for (int i = 1; i < p.length; i++)
			p[i] = i;

		for (int i = 1; i <= node; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= node; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					union(i, j);
				}
			}
		}
		
		boolean check = true;
		st = new StringTokenizer(br.readLine());
		int init = find(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			if(init != find(Integer.parseInt(st.nextToken()))) {
				check = false;
				break;
			}
		}
		System.out.println(check ? "YES" : "NO");
	}

	public static int find(int n) {
		if (n == p[n])
			return n;
		return p[n] = find(p[n]);
	}

	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);

		if (n1 == n2)
			return false;

		if (n1 < n2)
			p[n2] = n1;
		else
			p[n1] = n2;
		return true;
	}
}
