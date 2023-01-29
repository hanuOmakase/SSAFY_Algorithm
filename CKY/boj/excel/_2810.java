package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2810 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seats = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int p = 0;
        boolean leftCheck = false;
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == 'S'){
                if(!leftCheck)
                    leftCheck = false;
                p++;
            }else{
                if(!leftCheck){
                    leftCheck = true;
                    p +=2;
                }else{
                    p++;
                    leftCheck = true;
                }
                i++;
            }
        }
        System.out.println(p);
    }
}
