package SWEA.d3;

import java.util.Scanner;
import java.io.FileInputStream;

class _2805{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                String temp = sc.next();
                for(int j=0; j<N; j++) {
                    arr[i][j] = (int)(temp.charAt(j)-'0');
                }
            }
            int mid = N/2;
            int offset = mid;
            int sum = 0;
            for(int i=mid; i<N; i++) {
                for(int j=mid-offset; j<mid+offset+1; j++ ) {
                    sum += arr[i][j];
                    sum += arr[N-i-1][j];
                }
                offset -= 1;
            }
            for(int i=0; i<N; i++) {
                sum -= arr[mid][i];
            }
            System.out.printf("#%d %d\n",tc,sum);
        }
    }
}