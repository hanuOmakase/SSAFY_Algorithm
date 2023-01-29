package CKY.boj.excel;

import java.io.*;

public class _3052{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] tf = new boolean[42];
        int i = 10;
        while(i>0){
            int A = Integer.parseInt(br.readLine());
            tf[A % 42] = true;
            i--;
        }
        int count = 0;
        for(boolean b : tf){
            if(b == true) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}

