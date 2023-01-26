package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1289 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= count; i++) {
			char n = '0';
			String arr = br.readLine();
			int amend = 0;

			for (int j = 0; j < arr.length(); j++) {
				if (arr.charAt(j) == n) {

				} else {
					amend++;
					if (n == '0')
						n = '1';
					else
						n = '0';
				}
			}
			System.out.println("#" + i + " " + amend);
		}
	}
}
