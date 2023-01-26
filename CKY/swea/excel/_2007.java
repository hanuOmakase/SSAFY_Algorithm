package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _2007 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) { // line
			String repeatStr = br.readLine();
			for (int j = 1; j <= Integer.MAX_VALUE; j++) { // 1씩 증가시켜서 일치하는지 검증
				String isRepeat = repeatStr.substring(0, j);

				boolean check = false;

				for (int k = j; k < repeatStr.length() - j; k += j) {
					if (isRepeat.equals(repeatStr.substring(k, k + j))) {
						check = true;
					} else {
						break;
					}
				}

				if (check) {
					System.out.println("#" + i + " " + j);
					break;
				}
			}
		} // end for
	}
}
