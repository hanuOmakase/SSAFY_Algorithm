import java.util.Scanner;

public class Solution_SWEA_1976_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int hour = sc.nextInt();
			int minute = sc.nextInt();
			hour += sc.nextInt();
			minute += sc.nextInt();
			
			hour = (hour + minute / 60) % 12;
			
			System.out.printf("#%d %d %d\n", tc, hour == 0 ? 12 : hour, minute % 60);
		}
	}
}
