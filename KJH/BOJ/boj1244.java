package BOJ;

import java.util.Scanner;

public class boj1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
            int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int T = sc.nextInt();
        int a, b;
        for (int i = 0; i < T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 1) {
                int j = 1;
                while (b * j <= N) {
                    arr[b * j] = (arr[b * j++] + 1) % 2;
                }
            } else {
                int offset = 1;
                arr[b] = (arr[b] + 1) % 2;
                while (b + offset <= N && b - offset >= 1 && arr[b + offset] == arr[b - offset]) {
                    arr[b + offset] = arr[b - offset] = (arr[b - offset++] + 1) % 2;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        if (i % 20 == 0) System.out.println();
        }
    }
}
