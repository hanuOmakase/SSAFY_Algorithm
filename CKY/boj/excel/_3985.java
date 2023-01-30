package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int max = 0;
        int maxIdx = 0;
        int max2 = 0;
        int maxIdx2 = 0;
        boolean[] cake = new boolean[len + 1];
        int idx = 1;

        while (p-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            // 기대
            if (max < e - s + 1) {
                maxIdx = idx;
                max = e - s + 1;
            }
            
            //실제
            int tempMax = 0;
            for (int i = s; i <= e; i++) {
                if(!cake[i]){
                    cake[i] = true;
                    tempMax++;
                }
                if(tempMax > max2){
                    max2 = tempMax;
                    maxIdx2 = idx;
                }
            }

            idx++;
        }
        System.out.println(maxIdx);
        System.out.println(maxIdx2);
    }
}
