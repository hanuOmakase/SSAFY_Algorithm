package DivideConquer;

import java.io.*;

public class BOJ_2447_별찍기10 {
	static int N;
	static char[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		paper = new char [N][N];
		printStar(0, 0, N);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(paper[i][j]);
			}
			bw.write('\n');
		}
		bw.flush();
	}
	public static void printStar(int y, int x, int size) {
		int nextSize = size / 3;
		if(size > 3) {
			printStar(y, x, nextSize);
			printStar(y, x + nextSize, nextSize);
			printStar(y, x + nextSize * 2, nextSize);
			
			printStar(y + nextSize, x, nextSize);
			printBlank(y + nextSize, x + nextSize, nextSize);
			printStar(y + nextSize, x + nextSize * 2, nextSize);
			
			printStar(y + nextSize * 2, x, nextSize);
			printStar(y + nextSize * 2, x + nextSize, nextSize);
			printStar(y + nextSize * 2, x + nextSize * 2, nextSize);
		}
		else {
			for(int j = x; j < x + size; j++)
				paper[y][j] = '*';
			
			paper[y + 1][x] = '*';
			paper[y + 1][x + 1] = ' ';
			paper[y + 1][x + 2] = '*';
			
			for(int j = x; j < x + size; j++)
				paper[y + 2][j] = '*';
		}
	}
	public static void printBlank(int y, int x, int size) {
		for(int i = y; i < y + size; i++)
			for(int j = x; j < x + size; j++)
				paper[i][j] = ' ';
	}
}
