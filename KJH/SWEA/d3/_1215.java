package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class _1215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character arr[][] = new Character[8][8];
        int i1, i2, answer;
        boolean is = true;
        for(int tc=1; tc<=10; tc++){
            int T = sc.nextInt();
            answer = 0;
            for(int i=0; i<8; i++){
                String str = sc.next();
                for(int j=0; j<8; j++){arr[i][j] = str.charAt(j);}
            }
            for(int i=0; i<8; i++){
                for(int s=0; s<8-T+1; s++){
                    i1=s; i2=s+T-1; is=true;
                    while(i1<i2){if(arr[i][i1++] != arr[i][i2--]) {is = false; break;}}
                    if(is) answer += 1;
                    i1=s; i2=s+T-1; is=true;
                    while(s<i2){if(arr[i1++][i] != arr[i2--][i]){is=false; break;}}
                    if(is) answer += 1;
                }
            }
            System.out.printf("#%d %d\n",tc, answer);
        }
    }
}
