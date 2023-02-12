package SWEA.d2;

import java.util.Arrays;
import java.util.Scanner;
public class _1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <=T; tc++) {
            int N = sc.nextInt(), M = sc.nextInt();
            Integer[][] arr = new Integer[N][4];
            Integer[] score = new Integer[N];
            for(int i=0; i<N; i++) {
                for(int k=0; k<3; k++) arr[i][k] = sc.nextInt();
                arr[i][3] = arr[i][0]*35+arr[i][1]*45+arr[i][2]*20;
                score[i] = arr[i][3];
            }
            Arrays.sort(score);
            int temp = N-Arrays.binarySearch(score, arr[M-1][3])-1;
            int k = N/10;
            temp /= k;
            String ans = "";
            switch(temp) {
                case 0: ans = "A+"; break;
                case 1: ans = "A0"; break;
                case 2: ans = "A-"; break;
                case 3: ans = "B+"; break;
                case 4: ans = "B0"; break;
                case 5: ans = "B-"; break;
                case 6: ans = "C+"; break;
                case 7: ans = "C0"; break;
                case 8: ans = "C-"; break;
                case 9: ans = "D0"; break;
            }
            System.out.printf("#%d %s\n",tc,ans);
        }
    }
}