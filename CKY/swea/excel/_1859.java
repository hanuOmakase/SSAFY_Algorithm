package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1859 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			int innerCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] arr = new int[st.countTokens()];
			long[] temp = new long[st.countTokens()];

			int idx = 0;

			while (st.hasMoreTokens()) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < arr.length; j++) { // j 가 뒤에 수.
				for (int k = j - 1; k >= 0; k--) {
					if (arr[j] > arr[k]) {
						temp[j] += (arr[j] - arr[k]);
						temp[k] = 0;
					} else {
						break;
					}
				}
			}
			long sums = Arrays.stream(temp).sum();
			System.out.println("#" + i + " " + sums);
		}
	}
}
