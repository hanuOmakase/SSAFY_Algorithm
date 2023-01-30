package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[i];
            if (min >= Math.abs(sum - 100)) {
                min = Math.abs(sum - 100);
                answer = sum;
            }
        }
        System.out.println(answer);
    }
}
