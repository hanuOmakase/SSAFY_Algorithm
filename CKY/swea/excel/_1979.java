package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1979 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= count; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int size = Integer.parseInt(st.nextToken());
			int wordSize = Integer.parseInt(st.nextToken());

			int[][] arr = new int[size][size];

			for (int j = 0; j < size; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int k = 0; k < size; k++) {
					int element = Integer.parseInt(st.nextToken());
					if (element == 1) {
						element = 0;
					} else {
						element = 1;
					}
					arr[j][k] = element;
				}
			}
			
			int poss = 0;
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (arr[j][k] == 1)
						continue;
					if (k == 0) {
						poss += countFunc(arr, j, k, wordSize, 0);
					} else {
						if (arr[j][k - 1] == 1)
							poss += countFunc(arr, j, k, wordSize, 0);
					}
					if (j == 0) {
						poss += countFunc(arr, j, k, wordSize, 1);
					} else {
						if (arr[j - 1][k] == 1)
							poss += countFunc(arr, j, k, wordSize, 1);
					}
				}
			}
			System.out.println("#" + i + " " + poss);

		} // end for
	}

	public static int countFunc(int[][] arr, int row, int col, int wordSize, int rowcol) {
		if (rowcol == 0) { // 우측
			if (col + wordSize <= arr.length) {
				for (int i = col; i < col + wordSize; i++) {
					if (arr[row][i] == 1)
						return 0;
				}
				if (col + wordSize == arr.length)
					return 1;
				else {
					if (arr[row][col + wordSize] == 1) {
						return 1;
					} else {
						return 0;
					}
				}

			} else {
				return 0;
			}
		} else { // 좌측
			if (row + wordSize <= arr.length) {
				for (int i = row; i < row + wordSize; i++) {
					if (arr[i][col] == 1)
						return 0;
				}
				if (row + wordSize == arr.length)
					return 1;
				else {
					if (arr[row + wordSize][col] == 1) {
						return 1;
					} else {
						return 0;
					}
				}
			} else {
				return 0;
			}
		}
	}
}
