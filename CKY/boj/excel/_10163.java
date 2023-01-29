package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10163 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[1001][1001];
        int papers = Integer.parseInt(br.readLine());
        int[] paperArr = new int[papers+1];

        int idx = 1;
        while(papers-->0){
            st = new StringTokenizer(br.readLine());
            int sw = Integer.parseInt(st.nextToken());
            int sh = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i = sw; i<w + sw ; i++){
                for(int j = sh; j<h + sh; j++){
                    arr[i][j] = idx;
                }
            }
            idx++;
        }

        for(int i = 0; i<1001 ; i++){
            for(int j = 0; j<1001; j++){
                paperArr[arr[i][j]]++;
            }
        }

        for(int i = 1; i< paperArr.length; i++){
            sb.append(paperArr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
