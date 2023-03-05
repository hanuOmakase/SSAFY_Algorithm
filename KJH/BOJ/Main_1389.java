package BOJ;

import java.util.Scanner;

public class Main_1389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++) for(int j=1; j<=N; j++) arr[i][j] = 99999;
        for(int i=0; i<M; i++){
            int f = sc.nextInt(), t = sc.nextInt();
            arr[f][t] = arr[t][f] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(arr[i][k] + arr[k][j] >= arr[i][j]) continue;
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int ans = 0, min = 99999;
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++) sum += arr[i][j];
            if(sum < min) {
                ans = i;
                min = sum;
            }
        }
        System.out.println(ans);
    }
}
