package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _7964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 10; // Integer.parseInt(br.readLine());

		for (int i = 1; i <= testCase; i++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[8][8];
			for (int j = 0; j < 8; j++) {
				String str = br.readLine();
				for (int k = 0; k < 8; k++) {
					arr[j][k] = str.charAt(k) - 'A';
				}
			}
			int count = 0;

			// 0, 1, 2
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k <= 8 - size; k++)
					count += checkRow(arr, j, k, size);
			}
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k <= 8 - size; k++)
					count += checkCol(arr, j, k, size);
			}

			System.out.println(count);
		}
	}

	public static int checkRow(int[][] arr, int x, int y, int size) {
		int e = size/2 -1;
		int m = size % 2 == 1 ? size / 2 + 1 : size / 2;
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i <= e; i++)
			s.push(arr[x][y + i]);

		for (int i = m; i < size; i++) {
			if (s.pop() != arr[x][y + i])
				return 0;
		}
		return 1;
	}

	public static int checkCol(int[][] arr, int x, int y, int size) {
		int e = size/2 -1;
		int m = size % 2 == 1 ? size / 2 + 1 : size / 2;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <= e; i++)
			s.push(arr[y + i][x]);

		for (int i = m; i < size; i++) {
			if (s.pop() != arr[y + i][x])
				return 0;
		}
		return 1;
	}
}
