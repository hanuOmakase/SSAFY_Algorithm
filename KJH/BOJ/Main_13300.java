package BOJ;

import java.util.Scanner;

public class Main_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int ans = 0;
        int[][] arr = new int[7][2];
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a == 0) arr[b][0]++;
            else arr[b][1]++;
        }
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) continue;
                ans += arr[i][j] / K;
                if (arr[i][j] % K != 0) ans += 1;
            }
        }
        System.out.println(ans);
    }
}