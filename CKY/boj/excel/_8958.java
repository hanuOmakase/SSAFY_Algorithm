package CKY.boj.excel;

import java.util.*;

public class _8958 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int answerNumber = s.nextInt();
        s.nextLine();

        String[] ox = new String[answerNumber];
        int[] sum = new int[answerNumber];
        int plus = 0;

        for(int i =0; i<ox.length; i++){
            String q = s.nextLine();
            sum[i] = 0;
            plus = 0;
            for(int j =0; j<q.length(); j++){
                if(q.charAt(j)=='O'){
                    plus++;
                    sum[i] += plus;
                }else { // 'x'일때
                    plus = 0;
                }
            }
        }
        for(int count: sum){
            System.out.println(count);
        }
    }
}