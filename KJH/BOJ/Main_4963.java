package BOJ;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static class p { int x, y;public p(int x, int y) {this.x = x;this.y = y;}}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int nx, ny, ans = 0, H = sc.nextInt(), W = sc.nextInt();
            if (W == 0 && H == 0) break;
            int[][] arr = new int[W][H];
            for (int i = 0; i < W; i++) for (int j = 0; j < H; j++) arr[i][j] = sc.nextInt();
            Queue<p> wait = new ArrayDeque<>();
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    if (arr[i][j] != 1) continue;
                    wait.add(new p(i, j));
                    arr[i][j] = -1;
                    while(!wait.isEmpty()) {
                        p tmp = wait.poll();
                        for (int k = 0; k < 8; k++) {
                            nx = tmp.x + dx[k];
                            ny = tmp.y + dy[k];
                            if (nx < 0 || nx >= W || ny < 0 || ny >= H || arr[nx][ny] != 1) continue;
                            arr[nx][ny] = -1;
                            wait.add(new p(nx, ny));
                        }
                    }
                    ans += 1;
                }
            }
            System.out.println(ans);
        }
    }
}
