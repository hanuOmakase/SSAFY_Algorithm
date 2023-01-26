package SWEA;

import java.util.Scanner;

public class P1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String word = sc.next();
			int left = 0;
			int right = word.length() - 1;
			boolean isPalin = true;
			while(left <= right) {
				if(word.charAt(left)!=word.charAt(right)) {
					isPalin = false;
					break;
				}
				left++;
				right--;
			}
			System.out.print("#" + tc + " ");
			if(isPalin) System.out.println("1");
			else System.out.println("0");
		}
		sc.close();
	}
}
