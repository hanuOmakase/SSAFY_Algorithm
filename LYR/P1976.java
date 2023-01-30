package SWEA;

import java.util.Scanner;

public class P1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			int resultH = h1 + h2;
			int resultM = m1 + m2;
			if(resultM >= 60) {
				resultH += (resultM / 60);
				resultM %= 60;
			}
			if(resultH > 12)
				resultH %= 12;
			if(resultH == 0) resultH = 12;
			System.out.println("#" + tc + " " + resultH + " " + resultM);
		}
		sc.close();
	}
}
