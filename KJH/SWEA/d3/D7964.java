package SWEA.d3;

import java.util.Scanner;

public class D7964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N=sc.nextInt(), D=sc.nextInt();
            int temp, answer = 0, now = D;
            for(int i=1; i<=N; i++){
                temp = sc.nextInt();
                if(temp == 1){
                    now = i+D;
                }
                if(i >= now){
                    answer += 1;
                    now += D;
                }
            }
            System.out.printf("#%d %d\n",tc, answer);
        }
    }
}
