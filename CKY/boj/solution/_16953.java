package CKY.boj.solution;

import java.util.*;
import java.io.*;

public class _16953 {
	static int minx = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());

		f(n, target, 0);
		if (minx == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minx + 1);
	}

	public static void f(long n, long target, int min) {
		if (target <= n) {
			if (target == n)
				minx = Math.min(minx, min);
			return;
		}

		f(n * 2, target, min + 1);
		f(n * 10 + 1, target, min + 1);
	}
}
