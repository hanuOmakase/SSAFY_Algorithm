package BOJ;

import java.util.Scanner;

public class Main_1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt();
        int[] arr = new int[N];
        int now = 0;
        arr[0] = 1;
        int next, answer = 0;
        while (arr[now] < M) {
            if (arr[now] % 2 != 0) {
                next = (now + L) % N;
            } else {
                next = now - L;
                if (next < 0) next += N;
            }
            arr[next] += 1;
            now = next;
            answer += 1;
        }
        System.out.println(answer);
    }
}
