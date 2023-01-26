package SWEA;

import java.util.Scanner;

public class P1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			check(i);
		}
		sc.close();
	}
	public static void check(int i) {
		String tmp = "" + i;
		boolean isClap = false;
		int numOfClap = 0;
		for(int j = 0; j < tmp.length(); j++) {
			if(tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9') {
				isClap = true;
				numOfClap++;
			}
		}
		if(isClap)
			for(int j = 0; j < numOfClap; j++)
				System.out.print("-");
		else
			System.out.print(i);
		System.out.print(" ");
	}
}
