package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _2005 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			int size = Integer.parseInt(br.readLine());

			int[][] arr = new int[size][size];
			arr[0][0] = 1;

			for (int j = 1; j < size; j++) { // 1 setting
				arr[j][0] = 1;
				arr[j][j] = 1;
			}

			for (int i1 = 1; i1 < size; i1++) {
				for (int i2 = 1; i2 < size - 1; i2++) {
					if (i2 > i1)
						continue;
					arr[i1][i2] = arr[i1 - 1][i2 - 1] + arr[i1 - 1][i2];
				}
			}

			System.out.println("#" + (int) (i + 1));
			for (int i1 = 0; i1 < size; i1++) {
				for (int i2 = 0; i2 < size; i2++) {
					if (i2 > i1)
						continue;
					System.out.print(arr[i1][i2] + " ");
				}
				System.out.println();
			}
		}
	}
}
