package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _4698 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] primes = new int[1_000_001];

		// 소수이면 1
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == 1)
				continue;
			int number = i;
			while (true) {
				number += i;
				if (number >= 1_000_001)
					break;
				primes[number] = 1;
			}
		}

		for (int i = 1; i <= count; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int counts = 0;

			for (int j = s; j <= e; j++) {
				if (j == 1)
					continue;

				if (primes[j] == 0) {
					if (check(d, j))
						counts++;
				}
			}
			System.out.println("#" + i + " " + counts);
		}
	}

	public static boolean check(int d, int number) {
		while (number != 0) {
			int rest = number % 10;
			if (d == rest)
				return true;
			number /= 10;
		}
		return false;
	}
}
