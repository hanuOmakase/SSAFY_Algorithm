import java.util.Scanner;

public class P1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int totalWords = 0;
			
			int[][] puzzle = new int[N][N]; // 배열 초기화
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					puzzle[i][j] = sc.nextInt();
			
			for(int i = 0; i < N; i++) { // 가로
				int length = 0;
				for(int j = 0; j < N; j++) {
					if(puzzle[i][j] == 1 && (j == N - 1) && length == (K - 1)) totalWords++;// 퍼즐 크기 끝까지 도달했는데 K길이면
					else if(puzzle[i][j] == 0 && length == K) {// 검은 칸에 도달했는데 K길이면
						totalWords++;
						length = 0;
					}
					else if(puzzle[i][j] == 1) length++;// 빈칸에 도달한 경우 AND 조건 X
					else if(puzzle[i][j] == 0) length = 0;// 검은 칸에 도달한 경우 AND 조건 X
				}
			}
					
			for(int j = 0; j < N; j++) { // 세로
				int length = 0;
				for(int i = 0; i < N; i++) {
					if(puzzle[i][j] == 1 && (i == N - 1) && length == (K - 1)) totalWords++;// 퍼즐 크기 끝까지 도달했는데 K길이면
					else if(puzzle[i][j] == 0 && length == K) {// 검은 칸에 도달했는데 K길이면
						totalWords++;
						length = 0;
					}
					else if(puzzle[i][j] == 1) length++;// 빈칸에 도달한 경우 AND 조건 X
					else if(puzzle[i][j] == 0) length = 0;// 검은 칸에 도달한 경우 AND 조건 X
				}
			}
			System.out.println("#" + testCase + " " + totalWords);
		}
		sc.close();
	}
}
