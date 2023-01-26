package SWEA;

import java.util.Scanner;

public class P1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			String memory = sc.next();
			int sum = 0;
			boolean isDiff = false;
			for(int i = 0; i < memory.length(); i++) {
				if(memory.charAt(i) == '1' && isDiff == false) {
					sum++;
					isDiff = true;
				}
				else if(memory.charAt(i) == '0' && isDiff == true) {
					sum++;
					isDiff = false;
				}
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
