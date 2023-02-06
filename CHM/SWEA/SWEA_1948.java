import java.util.Scanner;

public class Solution_SWEA_1948_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int tc = 1; tc <= testCase; tc++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			int ans = 0;
			if (m1 == m2) {
				ans = d2 - d1 + 1;
			} else {
				ans = (days[m1 - 1] - d1 + 1) + d2;
				for (int i = m1 + 1; i < m2; i++) {
					ans += days[i - 1];
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
