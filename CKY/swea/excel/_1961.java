package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1961 {
	static int[][] arr;
	static List<StringBuilder> list;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			int arrSize = Integer.parseInt(br.readLine());

			list = new ArrayList<>();

			for (int zz = 0; zz < arrSize; zz++) {
				list.add(new StringBuilder());
			}

			arr = new int[arrSize][arrSize];

			for (int j = 0; j < arrSize; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int col = 0;
				while (st.hasMoreTokens()) {
					arr[j][col++] = Integer.parseInt(st.nextToken());
				}
			}

			switchArr(0, 0, arrSize);
			switchArr(0, 0, arrSize);
			switchArr(0, 0, arrSize);

			System.out.println("#" + i);

			for (StringBuilder sb : list) {
				System.out.println(sb.toString().trim());
			}
		}
	}

	// 재귀적으로 가능해야 한다는 점.
	public static void switchArr(int startRow, int startCol, int size) {
		if (size <= 1) {
			for (int i = 0; i < arr.length; i++) {
				StringBuilder sb = list.get(i);
				int[] aaa = arr[i];
				sb.append(" ");
				for (int e : aaa) {
					sb.append(e);
				}
			}
			return;
		}

		int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[startRow][startCol + i];
		}

		for (int i = 0; i < size; i++) {
			arr[startRow][startCol + size - 1 - i] = arr[startRow + i][startCol];
		}

		for (int i = 0; i < size; i++) {
			arr[startRow + i][startCol] = arr[startRow + size - 1][startCol + i];
		}

		for (int i = 0; i < size; i++) {
			arr[startRow + size - 1][startCol + i] = arr[startRow + size - 1 - i][startCol + size - 1];
		}

		for (int i = 0; i < size; i++) {
			arr[startRow + i][startCol + size - 1] = temp[i];
		}

		switchArr(startRow + 1, startCol + 1, size - 2);
	}
}
