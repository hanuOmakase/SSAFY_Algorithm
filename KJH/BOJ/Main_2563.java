package BOJ;

import java.util.Scanner;

public class Main_2563 {
    static int[][] arr = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, M ;
        for(int i=0; i<T; i++){
            N = sc.nextInt(); M = sc.nextInt();
            for(int x = N; x<N+10; x++){for(int y=M; y<M+10; y++){arr[x][y] = 1;}}
        }
        int answer = 0;
        for(int i=1; i<=100; i++){for(int j=1; j<=100; j++){if(arr[i][j] == 1) answer += 1;}}
        System.out.println(answer);
    }
}
