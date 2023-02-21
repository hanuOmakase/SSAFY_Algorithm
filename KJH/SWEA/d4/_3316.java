package SWEA.d4;
import java.util.Scanner;

public class _3316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans, T = sc.nextInt(), temp, div = 1000000007;
        int[][] arr= {};
        for(int tc=1; tc<=T; tc++) {
            ans = 0;
            String string = sc.next();
            arr = new int[16][string.length()];
            temp = string.charAt(0)-'A';
            for(int i=1; i<16; i++) {
                if( (i&(1<<temp)) > 0 && (i & 1)>0) {
                    arr[i][0] = 1;
                }
            }
            for(int i=1; i<string.length(); i++) {
                temp = string.charAt(i)-'A';
                for(int k=1; k<16; k++) {
                    for(int j=1; j<16; j++) {
                        if( (k & (1<<temp))>0 && (k & j)!=0){
                            arr[k][i]+= arr[j][i-1];
                            arr[k][i] %= div;
                        }
                    }
                }
            }
            for(int i=1; i<16; i++) {
                ans += arr[i][string.length()-1];
                ans %= div;
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}