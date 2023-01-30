import java.util.Scanner;

public class Solution_SWEA_1945_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[] nums = {2, 3, 5, 7, 11};
		for (int tc = 1; tc <= testCase; tc++) {
			
			int N = sc.nextInt(); // 2이상
			int[] abcde = {0, 0, 0, 0, 0};
			
			int namoeji = N;
			for (int i = 0; i < nums.length; i++) {
				while (true)  {
					if (namoeji % nums[i] == 0) {
						abcde[i]++;
						namoeji /= nums[i];
					} else { 
						break; 
					}
				}
			}
			
			System.out.printf("#%d %d %d %d %d %d\n", tc, 
					abcde[0], abcde[1], abcde[2], abcde[3], abcde[4]);
			
		} // end of for testCase
	}
}
