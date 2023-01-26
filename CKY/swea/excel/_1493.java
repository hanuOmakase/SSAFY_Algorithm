package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1493 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for (int i = 1; i <= count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number1 = Integer.parseInt(st.nextToken());
			int number2 = Integer.parseInt(st.nextToken());

			int[] xy1 = rec(number1);
			int[] xy2 = rec(number2);
			int x = xy1[0] + xy2[0];
			int y = xy1[1] + xy2[1];

			int number = 1;
			for (int j = 1; j <= y; j++) {
				number += j - 1;
			}

			for (int j = 1; j < x; j++) {
				int gap = y + j;
				number += gap;
			}

			System.out.println("#" + i + " " + number);

		}
	}

	public static int[] rec(int number) {
		int s = 0;
		int e = 0;
		int y = 0;
		int x = 1;

		for (int j = 0; j < 1000; j++) {
			s = e + 1;
			e += j + 1;
			y = j + 1;
			if (s <= number && number <= e) {
				break;
			}
		}

		while (y >= 1) {
			if (s == number)
				break;
			s++;
			x++;
			y--;
		}
		return new int[] { x, y };
	}
}
