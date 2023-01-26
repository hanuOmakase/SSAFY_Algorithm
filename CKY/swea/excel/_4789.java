package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _4789 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		// n자리 사람들은 n자리 만큼 앞사람들이 박수를 치고 있어야 박수를 친다.
		for(int i =1; i<=testCase; i++) {
			String p = br.readLine();
			int sumPeople = p.charAt(0) -'0';
			int needPeople = 0;
			
			for(int j =1; j<p.length(); j++) {
				int np = p.charAt(j) -'0';
				if(j > sumPeople) {
					int tempNeed = j - sumPeople;
					needPeople += tempNeed;
					sumPeople += tempNeed;
				}
				sumPeople += np;
			}
			System.out.println("#" + i + " " + needPeople);
		}
	}
}
