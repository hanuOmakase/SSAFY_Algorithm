import java.util.Scanner;

public class Solution_SWEA_1288_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt();
			int x = 0;
			boolean[] check = new boolean[10];
			boolean allTrue = false;
			while (!allTrue) {
				String stN = Integer.toString(++x * N);
				for (int i = 0; i < stN.length(); i++) {
					check[(stN.charAt(i) - '0')] = true;
				}
				
				allTrue = true;
				for (int i = 0; i < check.length; i++) {
					if (check[i] == false) { // 보지 않은 숫자가 있다면
						allTrue = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + x * N);
		} // end of for testCase
	}
}
