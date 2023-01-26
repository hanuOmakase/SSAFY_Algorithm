package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1974 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			int[][] arr = new int[9][9];
			for (int j = 0; j < 9; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 9; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			boolean check = true;

			for (int j = 0; j < 9; j++) {
				if (!checkRow(arr, j) || !checkCol(arr, j))
					check = false;
			}

			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (!checkBox(arr, j * 3, k * 3))
						check = false;
				}
			}
			if (check)
				System.out.println("#" + i + " " + "1");
			else
				System.out.println("#" + i + " " + "0");
		}
	}

	public static boolean checkRow(int[][] arr, int row) {
		boolean[] checkArr = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (checkArr[arr[row][i]])
				return false;
			else
				checkArr[arr[row][i]] = true;
		}
		return true;
	}

	public static boolean checkCol(int[][] arr, int col) {
		boolean[] checkArr = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (checkArr[arr[i][col]])
				return false;
			else
				checkArr[arr[i][col]] = true;
		}
		return true;
	}

	public static boolean checkBox(int[][] arr, int row, int col) {
		boolean[] checkArr = new boolean[10];
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (checkArr[arr[i][j]])
					return false;
				else
					checkArr[arr[i][j]] = true;
			}
		}
		return true;
	}
}
