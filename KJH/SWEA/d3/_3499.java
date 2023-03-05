package SWEA.d2;

import java.util.Scanner;
import java.io.FileInputStream;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            String[] arr = new String[N];
            for(int i=0; i<N; i++) {
                arr[i] = sc.next();
            }
            int iter1 = 0, iter2 = N/2 + N%2;
            System.out.printf("#%d ",tc);
            for(int i=0; i<N; i++) {
                if(i%2 == 0)
                    System.out.printf("%s ",arr[iter1++]);
                else
                    System.out.printf("%s ",arr[iter2++]);
            }
            System.out.println();
        }
    }
}