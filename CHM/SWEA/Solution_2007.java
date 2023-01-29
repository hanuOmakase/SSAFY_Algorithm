package swea.D2;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_2007 { // 2007 패턴 마디의 길이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			String line = sc.next();
			
			ArrayList<Character> pattern = new ArrayList<Character>(); // char -> Character
			int result = 0;
			
			for (int i = 0; i < line.length(); i++) {
				
				// 리스트 비어있으면 add, 비어있지 않다면 리스트와 비교
				if (pattern.isEmpty()) {
					pattern.add(line.charAt(i));
				} else {
					boolean allEquals = true;
					for (int j = 0; j < pattern.size(); j++) {
						if (!pattern.get(j).equals(line.charAt(i + j))) {
							allEquals = false;
							break;
						}
					}
					
					if (allEquals) { // 전부 같으면 pattern이 마디
						result = pattern.size();
						break;
					} else {
						pattern.add(line.charAt(i));
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
