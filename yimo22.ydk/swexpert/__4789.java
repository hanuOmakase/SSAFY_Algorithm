package swexpert;

import java.util.*;

public class __4789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			// str[i] = j : i명 있어야 박수를 치는 사람 수 j
			int curClap = 0;
			int answer = 0;
			for (int i = 0; i < str.length(); i++) {
				int need = (i - curClap) > 0 ? (i - curClap) : 0;
				answer += need;
				curClap += need;
				curClap += str.charAt(i) - '0';
			}
			System.out.printf("#%d %d\n", tc+1, answer);
		}
	}
}
