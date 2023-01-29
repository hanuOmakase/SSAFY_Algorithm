package swea.D3;

import java.util.Scanner;

public class Solution_5356 { // 5356. 의석이의 세로로 말해요
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			String[] input = new String[5];
			String result = "";
			int maxLen = 0;
			
			for (int i = 0; i < 5; i++) {
				input[i] = sc.next();
				if (input[i].length() > maxLen) { maxLen = input[i].length(); }
			}
			
			for (int i = 0; i < maxLen; i++) {
				for (int j = 0; j < input.length; j++) {
					try {
						result += input[j].charAt(i);
					} catch (StringIndexOutOfBoundsException e) {}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		} // end of for testCase
	}
}
