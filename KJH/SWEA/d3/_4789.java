package SWEA.d3;

import java.util.Scanner;
class _4789{
    public static void main(String args[]) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case=1; test_case<=T; test_case++){
            int hire = 0;
            int now = 0;
            String str = scanner.next();
            for(int i=0; i<str.length(); i++){
                int temp = Character.getNumericValue(str.charAt(i));
                if(temp != 0){
                    if (now >= i) {
                        now += temp;
                    }
                    else{
                        hire += (i-now);
                        now = i+temp;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,hire);
        }
    }
}