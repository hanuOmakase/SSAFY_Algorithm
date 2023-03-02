package CKY.study._3;

import java.util.*;
import java.io.*;

public class 케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[node+1][node+1];
		
		// 전처리
		for(int i = 0; i<arr.length; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE / 2);
			arr[i][i] = 0;
		}
		
		// 입력
		while(edge -- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		// 플로이드워셜
		for(int i = 1; i<arr.length; i++) {
			for(int j = 1; j<arr.length; j++) {
				for(int k = 1; k<arr.length; k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}	
			}
		}
		
		// 사람 번호를 출력한다
		int nodeNumber = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<arr.length; i++) {
			int sum = 0;
			for(int j = 1 ; j<arr.length; j++) 
				sum += arr[i][j];
			if(sum < min ) {
				nodeNumber = i;
				min = sum;
			}
		}
		
		System.out.println(nodeNumber);
	}
}
