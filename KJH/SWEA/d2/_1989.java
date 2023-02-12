package SWEA.d2;
import java.util.Scanner;
public class _1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String str = sc.next();
            int is = 1;
            for(int i=0; i<str.length()/2; i++) {
                if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
                    is = 0; break;
                }
            }
            System.out.printf("#%d %d\n",tc,is);
        }
    }
}