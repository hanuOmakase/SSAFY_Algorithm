package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_5432 { // 5432. 쇠막대기 자르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			String line = sc.next();
			List<Character> stack = new ArrayList<Character>();
			
			int sticks = 0;
			int stickPieces = 0;
			for (int i = 0; i < line.length(); i++) {
				stack.add(line.charAt(i));
				
				if (line.charAt(i) == '(') { // 여는 괄호
					sticks++;
				} else { // 닫는 괄호
					if (stack.get(stack.size() - 2) == '(') { // 레이저
						sticks--; // 이전에 더한 값이 막대가 아니였으므로
						stickPieces += sticks;
						continue;
					}
					stickPieces++;
					sticks--;
				}
			}
			
			System.out.println("#" + tc + " " + stickPieces);
			
		} // end of for testCase
	}
}
