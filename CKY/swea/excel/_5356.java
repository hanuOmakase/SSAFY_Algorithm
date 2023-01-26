package CKY.swea.excel;
import java.util.*;
import java.io.*;
public class _5356 {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for(int i =1; i<=count; i++) {
            String[][] str = new String[5][16];
 
            for(int j = 0; j<5; j++){
                String word = br.readLine();
                for(int k =0; k<str[0].length; k++){
                    if(word.length() > k){
                        str[j][k] = String.valueOf(word.charAt(k));
                    }else{
                        str[j][k] = "empty";
                    }
                }
            }
            sb.append("#").append(i).append(" ");
            for(int j = 0; j<str[0].length; j++){
                for(int k =0; k<5; k++){
                    if(str[k][j].equals("empty")){
                        continue;
                    }
                        else
                    sb.append(str[k][j]);
                }
            }
 
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}