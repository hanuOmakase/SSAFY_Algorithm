package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _7272 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			boolean check = word(s1).equals(word(s2));

			String checkStr = !check ? "DIFF" : "SAME";
			System.out.println("#" + i + " " + checkStr);

		}
	}

	public static String word(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'B') {
				sb.append(1);
			} else if (c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'R' || c == 'Q') {
				sb.append(2);
			} else {
				sb.append(3);
			}
		}
		return sb.toString();
	}
}
