package boj.Bronze;

import java.util.Scanner;

public class Main_3052 { // 3052. 나머지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[42];
		for (int i = 0; i < 10; i++) {
			nums[sc.nextInt() % 42]++;
		}
		
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
}
