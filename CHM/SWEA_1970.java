import java.util.Scanner;

public class Solution_SWEA_1970_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for (int tc = 1; tc <= testCase; tc++) {
			
			int price = sc.nextInt();
			String result = "";
			for (int i = 0; i < money.length; i++) {
				result += (price / money[i] + " ");
				price = price % money[i];
			}
			
			System.out.printf("#%d\n%s\n", tc, result);
		}
	}
}
