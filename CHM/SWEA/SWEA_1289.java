import java.util.Scanner;

public class Solution_SWEA_1289_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			String origin = sc.next();
			char before = '0';
			int result = 0;
			
			for (int i = 0; i < origin.length(); i++) {
				if (before != origin.charAt(i)) {
					result++;
					before = origin.charAt(i);
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
