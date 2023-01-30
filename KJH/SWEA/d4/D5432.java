package SWEA.d4;

import java.util.Scanner;

public class D5432 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int tc=1; tc<=T; tc++){
            String str = scanner.next();
            int answer=0, now=0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='('){now += 1;}
                else{
                    if(str.charAt(i-1)=='('){now -= 1; answer += now;}
                    else{now -= 1; answer += 1;}
                }
            }
            System.out.printf("#%d %d\n",tc,answer);
        }
    }
}
