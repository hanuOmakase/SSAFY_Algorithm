package CKY.study._3;

import java.io.*;
import java.util.*;

public class 별찍기_10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer sb = new StringBuffer();

	static String[][] str;

	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(br.readLine());
		str = new String[size][size]; // 2차원 공간에 별 찍기

		for (String[] aa : str)
			Arrays.fill(aa, " "); // 공백으로 채우기

		stars(0, 0, size);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(str[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void stars(int row, int col, int size) { // 3,3 // 9,9 // 27,27
		if (size == 1) {
			str[row][col] = "*";
			return;
		}
		// 간격이
		// 27일때 9
		// 9일때 3
		// 3일때 1
		
		size /= 3; // 간격으로 활용

		for (int i = row; i < row + size * 3; i += size) {
			for (int j = col; j < col + size * 3; j += size) {
				if (i == row + size && j == col + size) // 시작 위치가 둘다 중간이라면 비운다
					continue;
				stars(i, j, size);
			}
		}
	}
}
