package boj.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567 { // 2567. 색종이 - 2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] paper = new int[101][101]; // 도화지
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			
			for (int x = xx; x < xx + 10; x++) {
				for (int y = yy; y < yy + 10; y++) {
					paper[x][y] = 1;
				}
			}
		}
		
		int boundary = 0;
		for (int i = 0; i < 101; i++) {
			int beforeRow = 0;
			int beforeCol = 0;
			for (int j = 0; j < 101; j++) {
				if (paper[i][j] != beforeRow) {
					boundary++;
				}
				beforeRow = paper[i][j];
				
				if (paper[j][i] != beforeCol) {
					boundary++;
				}
				beforeCol = paper[j][i];
			}
		}
		
		System.out.println(boundary);
	}
}
