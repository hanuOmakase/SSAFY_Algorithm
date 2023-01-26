package CKY.swea.excel;
import java.util.*;
import java.io.*;
public class _2001 {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
         
        for(int i = 1; i<=count; i++){
            int max = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int chae = Integer.parseInt(st.nextToken());
             
            int[][] arr = new int[size][size];
             
            for(int j = 0; j<size; j++){
                st = new StringTokenizer(br.readLine());
                int col = 0;
                 
                while(st.hasMoreTokens()){
                    arr[j][col] = Integer.parseInt(st.nextToken());
                    col++;
                }
            } 
             
            for(int j = 0; j<size; j++){
                for(int k = 0; k<size; k++){ 
                    int swing = 0;
                    if(j + chae <= size && k + chae <=size){
                        for(int z = j; z<j+chae ; z++){
                            for(int x = k; x< k+chae;  x++){
                                swing += arr[z][x];
                            }
                        }
                    }
                     
                   max = Math.max(swing, max); 
                }
            }
        System.out.println("#" + i + " " + max);
        }// end count
    }
}
