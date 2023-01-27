package CKY.boj.excel;

import java.io.*;
import java.util.*;

public class _11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i =0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 줄을 서는데 최소로.
        int sum=0;
        for(i = 0; i<N; i++){
            sum += arr[i];
            arr1[i] = sum;
        }
        sum = 0;
        for(i = 0; i<N; i++){
            sum +=arr1[i];
        }
        System.out.println(sum);
    }
}

