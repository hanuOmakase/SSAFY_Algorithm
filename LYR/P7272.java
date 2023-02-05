package SWEA;

import java.util.Scanner;

public class P7272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final String zero = "CEFGHIJKLMNSTUVWXYZ";
        final String one = "ADOPQR";
        final String two = "B";
        for(int tc = 1; tc <= T; tc++){
            String s1 = sc.next();
            String s2 = sc.next();
            boolean isSame = false;
            if(s1.length() != s2.length()){
                System.out.println("#" + tc + " DIFF");
                continue;
            }
            for(int i = 0; i < s1.length(); i++){
                if(zero.contains(s1.charAt(i) + "") && zero.contains(s2.charAt(i) + "")){
                    isSame = true;
                    continue;
                }
                if(one.contains(s1.charAt(i) + "") && one.contains(s2.charAt(i) + "")){
                    isSame = true;
                    continue;
                }
                if(two.contains(s1.charAt(i) + "") && two.contains(s2.charAt(i) + "")){
                    isSame = true;
                    continue;
                }
                isSame = false;
                break;
            }
            if(isSame) System.out.println("#" + tc + " SAME");
            else System.out.println("#" + tc + " DIFF");
        }
        sc.close();
    }
}
