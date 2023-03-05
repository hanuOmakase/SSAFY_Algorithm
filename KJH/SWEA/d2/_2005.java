package SWEA.d2;

import java.util.Scanner;
import java.io.FileInputStream;
class _2005{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            System.out.println("#"+test_case);
            int N = sc.nextInt();
            int[][] arr = new int[N+2][N+2];
            arr[0][1] = 1;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    System.out.printf("%d ",arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}