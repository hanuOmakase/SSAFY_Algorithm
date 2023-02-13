package CKY.study._1;

import java.util.*;
import java.io.*;

// 중복 순열
public class NnM3 {

	static int temp[];
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		permu(m, 0);

	}

	public static void permu(int limit, int p) {
		if (limit == p) {
			Arrays.stream(temp).forEach(e -> System.out.print(e + " "));
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			temp[p] = i;
			permu(limit, p + 1);
		}
	}
}
