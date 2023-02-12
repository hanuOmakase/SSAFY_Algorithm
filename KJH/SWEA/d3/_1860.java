package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class _1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[11112];
        for(int tc=1; tc<=T; tc++) {
            int tmp, N=sc.nextInt(), M=sc.nextInt(), K=sc.nextInt();
            int make=0, people=0, max=0;
            Arrays.fill(arr, 0);
            boolean can = true;
            for(int i=1; i<=N; i++) {
                tmp = sc.nextInt();
                arr[tmp] += 1;
                max = Integer.max(max, tmp);
            }
            for(int i=0; i<=max+1; i++) {
                if(i != 0 &&i%M==0) {make += K;}
                people += arr[i];
                if(people>make) {
                    can = false;
                    break;
                }
            }
            if(can) System.out.printf("#%d Possible\n",tc);
            else System.out.printf("#%d Impossible\n",tc);
        }
    }
}
