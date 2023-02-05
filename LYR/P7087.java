package SWEA;

import java.util.Scanner;

public class P7087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            boolean[] alpha = new boolean [26];
            for(int i = 0; i < N; i++){
                String tmp = sc.next();
                alpha[tmp.charAt(0) - 'A'] = true;
            }
            int cnt = 0;
            for(int i = 0; i < 26; i++){
                if(alpha[i]) cnt++;
                else break;
            }
            System.out.println("#" + tc + " " + cnt);
        }
        sc.close();
    }
}
