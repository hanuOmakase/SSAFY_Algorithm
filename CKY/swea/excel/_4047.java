package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _4047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		// S, D, H, C
		// 0, 1, 2, 3
		loop1: for (int i = 1; i <= testCase; i++) {
			int[][] arr = new int[4][14];

			String cards = br.readLine();
			for (int j = 0; j < cards.length(); j += 3) {
				String cardType = cards.substring(j, j + 1);
				int cardNumber = Integer.parseInt(cards.substring(j + 1, j + 3));

				if (cardType.equals("S")) {
					arr[0][cardNumber]++;
				} else if (cardType.equals("D")) {
					arr[1][cardNumber]++;
				} else if (cardType.equals("H")) {
					arr[2][cardNumber]++;
				} else if (cardType.equals("C")) {
					arr[3][cardNumber]++;
				}
			}

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < 4; j++) {
				int count = 13;
				for (int k = 1; k < arr[0].length; k++) {
					if (arr[j][k] == 1)
						count--;
					else if (arr[j][k] >= 2) {
						System.out.println("#" + i + " ERROR");
						continue loop1;
					}
				}
				sb.append(count).append(" ");
			}
			System.out.println("#" + i + " " + sb.toString());
		}
	}
}