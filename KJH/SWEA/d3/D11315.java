package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class D11315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {arr[i] = sc.next().toCharArray();}
            int[] dx = {0, -1, -1, -1};
            int[] dy = {-1, 0, -1, 1};
            int[][][] dp = new int[4][N][N];
            int cx, cy;
            boolean find = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 'o') {
                        for (int k = 0; k < 4; k++) {
                            cx = i + dx[k]; cy = j + dy[k];
                            if (cx >= 0 && cx < N && cy >= 0 && cy < N && arr[cx][cy] == 'o') {
                                dp[k][i][j] = dp[k][cx][cy] + 1;
                                if (dp[k][i][j] >= 5) {find = true;break;}
                            } else {dp[k][i][j] = 1;}
                        }
                        if (find) break;
                    }
                }
                if (find) break;
            }
            if (find) System.out.printf("#%d YES\n", tc);
            else System.out.printf("#%d NO\n", tc);
        }
    }
}
