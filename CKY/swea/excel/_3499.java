package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _3499 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<>();
			while (st.hasMoreTokens())
				list.add(st.nextToken());

			System.out.println("#" + i + " " + f(list));

		}
	}

	public static StringBuilder f(List<String> list) {
		StringBuilder sb = new StringBuilder();

		int s = 0;
		int m = list.size() % 2 == 0 ? list.size() / 2 : list.size() / 2 + 1;

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				sb.append(list.get(s++)).append(" ");
			} else {
				sb.append(list.get(m++)).append(" ");
			}
		}
		return sb;
	}
}