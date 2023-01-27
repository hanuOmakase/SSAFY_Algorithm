package CKY.boj.excel;

import java.io.*;
import java.util.*;

public class _2292 {
	public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int count = 0;
        long number = 1;
        int i = 1;

        while(true){
            number += i * 6; 
            if(A <= number) {
                count = i;
                break;
            }
            i++;
        }
        if(number == 1 || A == 1)
            count = 0;
        else if( A <= 0)
            count = -1;
        bw.write(count +1+ "\n");
        bw.flush();
        bw.close();
    }
}
