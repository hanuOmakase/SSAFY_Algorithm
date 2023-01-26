package CKY.swea.excel;

import java.util.*;
import java.io.*;
 
class _1220
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 10;//Integer.parseInt(br.readLine());
        for(int i = 1; i<=count; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][size];
             
            for(int j =0; j<size; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = 0;
                while(idx < size) {
                    arr[j][idx++] = Integer.parseInt(st.nextToken());
                }
            }
             
            int collide = 0;
            for(int j = 0; j<size; j++) {
                boolean check = false;
                for(int k = 0; k<size; k++) {
                    if(arr[k][j] == 1) { // r
                        check = true;
                    }else if(arr[k][j]==2) { // b
                        if(check) {
                            collide++;
                            check = false;
                        }
                    }
                     
                }
            }
            System.out.println("#" + i + " " + collide);
        }
    }
}