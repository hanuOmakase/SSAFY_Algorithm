package CKY.swea.excel;
import java.util.*;
import java.io.*;
 
public class _1984 {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine().trim());
         
        for(int i =1; i<=count; i++){
            st = new StringTokenizer(br.readLine().trim());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
             
            while(st.hasMoreTokens()){
                int number = Integer.parseInt(st.nextToken());
                min = Math.min(min, number);
                max = Math.max(max, number);
                sum += number;
            }
            sum -= min;
            sum -= max;
             
            double avg = (double)sum/8;
            long intAvg = Math.round(avg);
             
            System.out.println("#" + i + " " + intAvg);
        }
    }
}
