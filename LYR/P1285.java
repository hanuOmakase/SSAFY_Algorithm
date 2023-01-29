package SWEA;

import java.util.Scanner;

public class P1285 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int dis = 100001;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				int tmp = num;
				int disTmp = dis;
				if(dis < 0) disTmp *= -1;
				if(num < 0) tmp *= -1;
				if(tmp < disTmp) {
					dis = num;
					cnt = 1;
				}
				else if(tmp == dis) cnt++;
			}
			if(dis < 0) dis *= -1;
			System.out.println("#" + tc + " " + dis + " " + cnt);
		}
		sc.close();
	}
}
