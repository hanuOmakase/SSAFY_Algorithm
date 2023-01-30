import java.util.Scanner;

public class Solution_SWEA_1946_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			char[] alphabet = new char[N];
			int[] count = new int[N];
			
			for (int i = 0; i < N; i++) {
				alphabet[i] = sc.next().charAt(0);
				count[i] = sc.nextInt();
			}
			
			System.out.println("#" + tc);
			for (int i = 0, line = 1; i < count.length; i++) {
				for (int j = 0; j < count[i]; j++, line++) {
					System.out.print(alphabet[i]);
					if (line % 10 == 0) {
						System.out.println();
					}
				}
			}
			System.out.println();
			
		} // end of for testCase
	}
}
