package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class _7087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            boolean[] arr = new boolean[26];
            Arrays.fill(arr, false);
            for(int i=0; i<N; i++) {
                String tmp = sc.next();
                arr[Character.getNumericValue(tmp.charAt(0))-10] = true;
            }
            int i = 0;
            for(i=0; i<26; i++) {
                if(!arr[i]) {
                    System.out.printf("#%d %d\n",tc, i);
                    break;
                }
            }
            if(i == 26) {System.out.printf("#%d 26\n",tc);}
        }
    }
}