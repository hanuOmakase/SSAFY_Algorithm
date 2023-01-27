package CKY.boj.excel;

import java.util.*;
import java.io.*;

public class _1592 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arrSize = Integer.parseInt(st.nextToken());
		int endCondition = Integer.parseInt(st.nextToken());
		int throwL = Integer.parseInt(st.nextToken());
		
		int[] seats = new int[arrSize];
		int throwTimes = 0;
		int nIdx = 0;
		
		while(endCondition != seats[nIdx]) {
			
			if(seats[nIdx] % 2 == 0) { // 시계
				int nThrow = nIdx + throwL;
				if(nThrow >= arrSize) {
					nIdx = (nThrow) % arrSize ;
				}else {
					nIdx = nThrow;
				}
				
			}else { // 반시계
				int nThrow = nIdx - throwL;
				if(nThrow < 0) {
					nIdx = arrSize + nThrow;
				}else {
					nIdx = nThrow;
				}
			}
			throwTimes++;
			seats[nIdx]++;
		}
		
		System.out.println(throwTimes - 1);
	}
}
