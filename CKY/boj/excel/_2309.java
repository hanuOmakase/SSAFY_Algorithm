package CKY.boj.excel;

import java.util.*;
import java.io.*;

public class _2309 {
	static int[] arr;
	static int[] temp;
	static int[] answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = new int[7];
		arr = new int[9];
		answer = new int[7];
		
		for(int i = 0; i<9; i++) 
			arr[i] = Integer.parseInt(br.readLine());
				
		combi(0, 7, 0);
		Arrays.stream(answer).sorted().forEach(e -> System.out.println(e));
	}
	
	public static void combi(int n, int limit, int idx) {
		if(n == limit) {
			int sum = Arrays.stream(temp).sum();
			if(sum == 100) 
				System.arraycopy(temp, 0, answer, 0, 7);
			return;
		}
		
		for(int i = idx; i<arr.length; i++) {
			temp[n] = arr[i];
			combi(n + 1, limit, i+1);
		}
	}
}