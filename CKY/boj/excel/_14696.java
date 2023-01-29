package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14696 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int round = Integer.parseInt(br.readLine());
        int[] p1 = new int[4];
        int[] p2 = new int[4];

        int idx = 1;
        while(idx++ <= round){
            Arrays.fill(p1, 0);
            Arrays.fill(p2, 0);

            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens())
                p1[Integer.parseInt(st.nextToken())-1]++;

            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens())
                p2[Integer.parseInt(st.nextToken())-1]++;

            if(Arrays.equals(p1, p2)){
                sb.append("D").append("\n");
                continue;
            }

            for(int i = p1.length - 1; i>= 0; i--){
                if(p1[i] > p2[i]){
                    sb.append("A").append("\n");
                    break;
                }else if (p1[i] < p2[i]) {
                    sb.append("B").append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
