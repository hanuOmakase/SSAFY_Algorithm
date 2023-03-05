import java.util.Scanner;

public class Solution_SWEA_1984_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int max = 0;
			int min = 10000;
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt(); // 0 이상 10000 이하의 정수
				sum += num;
				if (max < num) { max = num; }
				if (min > num) { min = num; }
			}
		
			System.out.println("#" + tc + " " + Math.round((sum - max - min) / 8.0));
		}
	}
}
