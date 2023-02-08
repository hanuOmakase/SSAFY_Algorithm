package boj.B2;

import java.util.Scanner;

public class Main_13300 { // 13300. 방 배정
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 방의 최대 인원 수
		
		int[][] check = new int[6][2];
		int rooms = 0;
		
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별
			int Y = sc.nextInt() - 1; // 학년
			
			if (check[Y][S] == K) {
				rooms++;
				check[Y][S] = 1;
			} else {
				check[Y][S]++;
			}
		}
		
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if (check[i][j] != 0) {
					rooms++;
				}
			}
		}
		
		System.out.println(rooms);
	}
}
