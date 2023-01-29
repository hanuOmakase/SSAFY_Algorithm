package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8320 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10_001];
        int answer = 0;

        for(int i = 1; i<=n; i++){
            int sq = (int) Math.sqrt(i);
            for(int j = 1; j<=sq; j++){
                if(i % j == 0)
                    arr[i]++;
            }
        }

        for(int i = 1; i<=n; i++)
            answer += arr[i];
        System.out.println(answer);
    }
}
