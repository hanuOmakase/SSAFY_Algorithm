package SWEA.d2;
import java.util.Scanner;
public class _2007{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            String str = sc.next();
            String K = "";
            for(int index=1; index<30; index++) {
                K = str.substring(0, index);
                boolean is = true;
                for(int i=0; i<30; i++) {
                    if(str.charAt(i) != K.charAt(i%index)) {
                        is = false;
                        break;
                    }
                }
                if(is) {
                    System.out.println("#" + test_case + " " + index);
                    break;
                }
            }
        }
    }
}