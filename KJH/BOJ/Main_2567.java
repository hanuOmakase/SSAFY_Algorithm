package BOJ;

import java.util.Scanner;

public class Main_2567 {
    static int[][] arr = new int[102][102];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(),N, M ,answer=0,nx,ny;
        for (int i=0; i<T; i++){
            N = sc.nextInt(); M = sc.nextInt();
            for(int x = N; x<N+10; x++){for(int y=M; y<M+10; y++){arr[x][y] = 1;}}
        }
        int[] x = {-1, 0, 1, 0}, y = {0, 1, 0, -1};
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if(arr[i+x[k]][j+y[k]] == 0){answer += 1;}
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
