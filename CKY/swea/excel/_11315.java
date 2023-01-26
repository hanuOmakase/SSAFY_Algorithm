package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _11315 {
	static int[][] arr;
	static int size;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];

			for (int j = 0; j < size; j++) {
				String strs = br.readLine();
				for (int k = 0; k < size; k++) {
					if (strs.charAt(k) == '.') 
						arr[j][k] = 0;
					else 
						arr[j][k] = 1;
				}
			}

			boolean check = false;
			loop1: for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (arr[j][k] == 1) {
						check = fiveStone(j, k);
					}
					if (check)
						break loop1;
				}
			}
			String answer = check ? "YES" : "NO";
			System.out.println("#" + i + " " + answer);
		} 
	}

	public static boolean fiveStone(int x, int y) {
		boolean check = false;
		int count = 0;

		for (int i = 1; i <= 4; i++) {
			if (rangeCheck(x, y + i)) {
				if (arr[x][y + i] == 1)
					count++;
			}
		}
		if (count == 4) {
			return true;
		} else {
			count = 0;
		}

		// 아래 오
		for (int i = 1; i <= 4; i++) {
			if (rangeCheck(x + i, y + i)) {
				if (arr[x + i][y + i] == 1)
					count++;
			}
		}
		if (count == 4) {
			return true;
		} else 
			count = 0;

		// 아래
		for (int i = 1; i <= 4; i++) {
			if (rangeCheck(x + i, y)) {
				if (arr[x + i][y] == 1)
					count++;
			}
		}
		if (count == 4) {
			return true;
		} else {
			count = 0;
		}

		// 왼 아래
		for (int i = 1; i <= 4; i++) {
			if (rangeCheck(x + i, y - i)) {
				if (arr[x + i][y - i] == 1) 
					count++;
			}
		}
		if (count == 4) 
			return true;
		
		return false;
	}

	public static boolean rangeCheck(int x, int y) {
		if (x >= 0 && x < size && y >= 0 && y < size)
			return true;
		return false;
	}
}