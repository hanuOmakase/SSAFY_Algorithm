import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1966_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			
			System.out.print("#" + tc);
			for (int i = 0; i < nums.length; i++) {
				System.out.print(" " + nums[i]);
			}
			System.out.println();
		}
	}
}
