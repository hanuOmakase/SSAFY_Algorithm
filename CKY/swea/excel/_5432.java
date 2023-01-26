package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _5432 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=testCase; i++) {
			// 두번째 괄호부터 숫자 하나씩 증가
			// 잘려진 개수
			
			int totalSum = 0;
			int tempCount = 0;
			int newLine = 0; // 괄호가 중간에서 새로 생기는 경우
			
			String o = br.readLine();
			for(int j = 0; j<o.length() - 1; j++) {
				char c1 = o.charAt(j);
				char c2 = o.charAt(j + 1);
				
				if(c1 == '(' && c2 == ')') {
					totalSum += tempCount;
					totalSum += newLine;
					newLine = 0;
					j += 1;
				}else if(c1 == '(') {
					tempCount++;
					newLine++;
				}
				else {
					tempCount--;
				}
			}
			System.out.println(totalSum);
		}
	}
}
