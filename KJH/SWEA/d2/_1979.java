package SWEA.d2;

import java.util.Scanner;

class _1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int answer = 0;
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<N; i++) {
                int temp = 0, temp2 = 0;
                for(int j=0; j<N; j++) {
                    if(arr[i][j] == 1) {temp += 1;}
                    else {if(temp == K) {answer += 1;} temp = 0;}

                    if(arr[j][i] == 1) {temp2 += 1;}
                    else {if(temp2 == K) {answer += 1;} temp2 = 0;}
                }
                if(temp == K) answer += 1;
                if(temp2 == K) answer += 1;
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}