package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String str = br.readLine();

        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '<' || c == '>' || c == ' '){
                answer.append(sb.reverse());
                sb.setLength(0);
            }

            if (c == '<') {
                answer.append(c);
                check = true;
            } else if (c == '>') {
                answer.append(c);
                check = false;
            } else if (c == ' ') {
                answer.append(c);
            }else if(check){
                answer.append(c);
            }else
                sb.append(c);
        }
        answer.append(sb.reverse());
        System.out.println(answer);
    }
}
