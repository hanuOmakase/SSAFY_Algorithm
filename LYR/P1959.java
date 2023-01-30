package SWEA;

import java.util.Scanner;

public class P1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			int[] num1 = new int[len1];
			int[] num2 = new int[len2];
			for(int i = 0; i < len1; i++) num1[i] = sc.nextInt();
			for(int i = 0; i < len2; i++) num2[i] = sc.nextInt();
			int result;
			if(len1 < len2) result = getMax(num2, num1);
			else result = getMax(num1, num2);
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	public static int getMax(int[] arr1, int[] arr2) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= arr1.length - arr2.length; i++) {
			int tmp = 0;
			for(int j = 0, k = i; j < arr2.length; j++, k++) {
				tmp += (arr1[k] * arr2[j]);
			}
			if(tmp > max) max = tmp;
		}
		return max;
	}
}
