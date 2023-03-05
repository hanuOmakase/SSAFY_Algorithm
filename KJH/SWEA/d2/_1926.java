package SWEA.d2;
import java.util.Scanner;

public class _1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1; i<=T; i++) {
            int K=i,temp;
            String time = "";
            while(K!=0) {
                temp = K%10;
                if(temp == 3 || temp == 6 || temp == 9) {time += "-"; }
                K = K / 10;
            }
            if(!time.equals("")) {System.out.print(time+" ");}
            else {System.out.print(i+" ");}
        }
    }
}
