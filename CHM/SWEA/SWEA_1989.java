import java.util.Scanner;

public class Solution_SWEA_1989_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int result = 1;
			String word = sc.next();

			for (int i = 0; i < word.length() / 2; i++) {
				if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
					result = 0;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		} // end of for testCase
	}
}
