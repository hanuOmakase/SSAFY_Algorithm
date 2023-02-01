package swea.D3;

import java.util.Scanner;

public class Solution_7272 { // 7272. 안경이 없어!
	
	static private char[] oneWhole = {'A', 'D', 'O', 'P', 'Q', 'R' };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			String str1 = sc.next();
			String str2 = sc.next();
			String int1 = "";
			String int2 = "";
			
			if (str1.length() != str2.length()) {
				System.out.printf("#%d DIFF\n", tc);
				continue;
			}
			
			if (strCheck(str1).equals(strCheck(str2))) {
				System.out.printf("#%d SAME\n", tc);
				continue;
			}
			
			System.out.printf("#%d DIFF\n", tc);
			
		}
	} // end of main
	
	static private String strCheck(String str) {
		
		String ret = "";
		
ex:		for (int i = 0; i < str.length(); i++) { 
			for (int j = 0; j < oneWhole.length; j++) {
				if (str.charAt(i) == oneWhole[j]) {
					ret += 1;
					continue ex;
				}
			}
			if (str.charAt(i) == 'B') {
				ret += 2;
			} else {
				ret += 0;
			}
		}
		
		return ret;
	}
	
} // end of class
