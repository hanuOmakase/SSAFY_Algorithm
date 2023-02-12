package SWEA.d2;

import java.util.Scanner;

class _2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) arr[i][j] = sc.nextInt();
            }
            int answer = 0;
            for (int i = 0; i <= N - M; i++) {
                int temp = 0;
                for (int k = i; k < i + M; k++) {
                    for (int j = 0; j < M; j++) {
                        temp += arr[k][j];
                    }
                }
                answer = answer > temp ? answer : temp;
                for (int j = M; j < N; j++) {
                    for (int k = i; k < i + M; k++) {
                        temp = temp + arr[k][j] - arr[k][j - M];
                    }
                    answer = answer > temp ? answer : temp;
                }
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}