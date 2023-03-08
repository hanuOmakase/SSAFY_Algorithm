package BOJ;

import java.util.*;

public class Main_20057_마법사상어와토네이도{
    public static void main(String[] args) {
        int dk[][][] = {
                {{0, 1, -1, 2, 1, -1, -2, 1, -1}, {-2, -1, -1, 0, 0, 0, 0, 1, 1 }},
                {{2, 1, 1, 0, 0, 0, 0, -1, -1},   {0, -1, 1, -2, -1, 1, 2, -1, 1}},
                {{0, 1, -1, 2, 1, -1, -2, 1, -1}, {2, 1, 1, 0, 0, 0, 0, -1, -1  }},
                {{-2, -1, -1, 0, 0, 0, 0, 1, 1},  {0, 1, -1, 2, 1, -1, -2, 1, -1}}
        };
        int val[] = { 5, 10, 10, 2, 7, 7, 2, 1, 1 }, dx[] = { 0, 1, 0, -1 }, dy[] = { -1, 0, 1, 0 };
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) arr[i][j] = sc.nextInt();
        int m, tmp, nx, ny, tx, ty, go = 1, d = 0, x = N / 2, y = N / 2, ans = 0;
        boolean flag = false, fin = false;
        while (true) {
            for (int i = 0; i < go; i++) {
                nx = x + dx[d]; ny = y + dy[d];
                tmp = arr[nx][ny];
                m = 0;
                arr[nx][ny] = 0;
                for (int k = 0; k < 9; k++) {
                    tx = nx + dk[d][0][k];  ty = ny + dk[d][1][k];
                    m += ((val[k]*tmp)/100);
                    if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
                        ans += ((val[k]*tmp)/100);
                        continue;
                    }
                    arr[tx][ty] += (int) ((val[k] * tmp) / 100);
                }
                tx = nx + dx[d]; ty = ny + dy[d];
                if (tx >= 0 && tx < N && ty >= 0 && ty < N) arr[tx][ty] += (tmp-m);
                else ans += (tmp-m);
                x = nx; y = ny;
            }
            if (fin) break;
            d = (d + 1) % 4;
            if (flag) {
                flag = false;
                go += 1;
                if (go == N) { fin = true; go -= 1;}
            }
            else flag = true;
        }
        System.out.print(ans);
    }
}
