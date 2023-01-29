package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3499 { // 3499. 퍼펙트 셔플
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			String[] cards = new String[N];
			for (int i = 0; i < cards.length; i++) {
				cards[i] = sc.next();
			}
			
			String[] halfCards = Arrays.copyOfRange(cards, (N + 1) / 2, N);
			
			System.out.print("#" + tc);
			for (int i = 0; i < N / 2; i++) {
				System.out.printf(" %s %s", cards[i], halfCards[i]);
			}
			if (N % 2 != 0) { 
				System.out.printf(" %s", cards[N / 2]);
			}
			System.out.println();
			
		} // end of for testCase
	}
}
