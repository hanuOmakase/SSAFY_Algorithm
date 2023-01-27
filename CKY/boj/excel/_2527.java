package CKY.boj.excel;

import java.util.*;
import java.io.*;

public class _2527 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			String answer = "";
			
			int xRangeMax = Math.max(x1, x2); 
			int pRangeMin = Math.min(p1, p2);
			int yRangeMax = Math.max(y1, y2);
			int qRangeMin = Math.min(q1, q2);
			
			if(xRangeMax < pRangeMin) {
				if(yRangeMax < qRangeMin) {
					answer = "a";
				}else if(yRangeMax == qRangeMin)
					answer = "b";
			}else if(xRangeMax == pRangeMin) {
				if(yRangeMax < qRangeMin) {
					answer = "b";
				}else if(yRangeMax == qRangeMin)
					answer = "c";
			}
			
			if(answer.equals(""))
				answer = "d";
			System.out.println(answer);
		}
	}
}
