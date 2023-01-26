package CKY.swea.excel;
import java.util.*;
import java.io.*;
public class _1204 {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
 
        for (int i = 1; i <= count; i++) {
            br.readLine();            
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int[] point = new int[101];
 
            while(st.hasMoreTokens()){
                point[Integer.parseInt(st.nextToken())]++;
            }
 
            int max = 0;
            int maxIdx = 0;
            for(int j = 0; j<point.length; j++){
                if(max <= point[j]){
                    max = point[j];
                    maxIdx = j;
                }
            }
 
            System.out.println("#" + i + " " + maxIdx);
        }
    }
}
