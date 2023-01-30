package swea.D3;

import java.util.Scanner;

public class Solution_4789 { // 4789. 성공적인 공연 기획
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			String input = sc.next();
			
			int ans = 0; // 고용해야 될 사람 수
			int clapping = 0; // 현재 박수를 치고 있는 사람 수
			
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '0') {
					if (clapping < i + 1) {
						ans += (i + 1) - clapping;
						clapping++;
					}
				} else {
					clapping += input.charAt(i) - '0';
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		} // end of for testCase
	}
}
