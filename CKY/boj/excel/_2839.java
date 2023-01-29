package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int max5kg = sugar/5;

        int answer5kg = 0;
        int answer3kg = 0;
        for(int i = max5kg; i>=0; i--){
            int r = sugar - (i * 5);
            if(r % 3 == 0){
                answer5kg = i;
                answer3kg = r/3;
                break;
            }
        }
        System.out.println(answer5kg + answer3kg == 0 ? -1 : answer5kg + answer3kg);
    }
}
