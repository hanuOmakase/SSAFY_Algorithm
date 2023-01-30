package CKY.boj.excel;

import java.util.*;
import java.io.*;

public class _10158 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xSize = Integer.parseInt(st.nextToken()); 
		int ySize = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int ax = Integer.parseInt(st.nextToken()); 
		int ay = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
			
		int xAnswer = 0;
		int yAnswer = 0;
		
		if((ax + time) / xSize % 2 == 1) 
			xAnswer = xSize - (ax + time) % xSize;
		else
			xAnswer = (ax + time) % xSize;
		if((ay + time) / ySize % 2 == 1) 
			yAnswer = ySize - (ay + time) % ySize;
		else
			yAnswer = (ay + time) % ySize;
		
		bw.write(xAnswer + " " + yAnswer);  
		bw.flush();   
		bw.close();   
	}
}
