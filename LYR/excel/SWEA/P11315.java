package SWEA;

import java.util.Scanner;

public class P11315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int[] dx = {1, 0, 1, 1};
        final int[] dy = {0, 1, 1, -1};
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            boolean isWin = false;

            // 2차원 배열 입력
            char[][] board = new char[N][N];
            for(int i = 0; i < N; i++){
                String input = sc.next();
                for(int j = 0; j < N; j++)
                    board[i][j] = input.charAt(j);
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(board[i][j] == 'o'){
                        for(int m = 0; m < 4; m++){
                            for(int n = 1; n < 5; n++){
                                int y = i + (dy[m] * n);
                                int x = j + (dx[m] * n);
                                if(x < 0 || y < 0 || x >= N || y >= N || (board[y][x] != 'o'))
                                    break;
                                if(n == 4) isWin = true;
                            }
                            if(isWin) break;
                        }
                    }
                    if(isWin) break;
                }
                if(isWin) break;
            }
            if(isWin) System.out.println("#" + tc + " YES");
            else System.out.println("#" + tc + " NO");
        }
        sc.close();
    }
}
