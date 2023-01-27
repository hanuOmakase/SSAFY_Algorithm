import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_SWEA_1220_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int result = 0; // 교착 상태의 개수
			int baek = sc.nextInt(); // 테이블 한 변, 항상 100
			int[][] table = new int[100][100];
			
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table[i].length; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			// 위 : N(1), 아래 : S(2)
			for (int i = 0; i < table.length; i++) {
				
				List<Integer> stack = new ArrayList<Integer>();
				
				for (int j = 0; j < table[i].length; j++) {
					if (table[j][i] == 1) { // N
						stack.add(table[j][i]);
					} else if (table[j][i] == 2) { // S
						if (stack.size() != 0) { stack.add(table[j][i]); }
					}
				}
				
				// stack 순회하면서 최초로 2 나오면 result + 1
				boolean check = true;
				for (int j = 0; j < stack.size(); j++) {
					if (stack.get(j) == 2 && check) {
						result++;
						check = false;
					}
					if (stack.get(j) == 1 && !check) {
						check = true;
					}
				}
				
			}
			
			System.out.println("#" + tc + " " + result);
		} // end of for testCase
	}
}
