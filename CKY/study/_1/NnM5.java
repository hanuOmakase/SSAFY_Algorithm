package CKY.study._1;

import java.util.*;
import java.io.*;

//순열
public class NnM5 {

	static int arr[];
	static int temp[];
	static boolean v[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		v = new boolean[n];
		temp = new int[m];
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens())
			arr[idx++] = Integer.parseInt(st.nextToken());
		
		permu(m, 0);

	}

	public static void permu(int limit, int p) {
		if(limit == p) {
			Arrays.stream(temp).forEach(e -> System.out.print(e + " "));
			System.out.println();
			return;
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				temp[p] = arr[i];
				permu(limit, p + 1);
				v[i] = false;
			}
		}
	}
}
