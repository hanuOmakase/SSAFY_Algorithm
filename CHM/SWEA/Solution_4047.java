package swea.D3;

import java.util.Scanner;

public class Solution_4047 { // 4047. 영준이의 카드 카운팅
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			String input = sc.next();
			
			boolean errorCheck = false;
			boolean[][] cardList = new boolean[4][13];
			
			for (int i = 0; i < input.length(); i += 3) {
				char shape = input.charAt(i);
				int number = Integer.parseInt(input.substring(i+1, i+3));
				int shapeIndex = -1;
				
				switch (shape) {
				case 'S': shapeIndex = 0; break;
				case 'D': shapeIndex = 1; break;
				case 'H': shapeIndex = 2; break;
				case 'C': shapeIndex = 3; break;
				}
				
				if (cardList[shapeIndex][number - 1]) { // 이미 존재하는 카드
					errorCheck = true;
					break;
				} else {
					cardList[shapeIndex][number - 1] = true;
				}
			}
			
			if (errorCheck) {
				System.out.printf("#%d ERROR\n", tc);
				continue;
			}
			
			int[] count = {13, 13, 13, 13};
			for (int i = 0; i < cardList.length; i++) {
				for (int j = 0; j < cardList[i].length; j++) {
					if (cardList[i][j]) {
						count[i]--;
					}
				}
			}
			
			System.out.printf("#%d %d %d %d %d\n", tc, count[0], count[1], count[2], count[3]);
		} // end of for testCase
	}
}
