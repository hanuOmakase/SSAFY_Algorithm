
import java.util.*;

public class _2527_S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 4;

		for (int tc = 0; tc < T; tc++) {
			int r1, r2, c1, c2;
			int a1, a2, b1, b2;
			r1 = sc.nextInt();
			c1 = sc.nextInt();
			r2 = sc.nextInt();
			c2 = sc.nextInt();
			a1 = sc.nextInt();
			b1 = sc.nextInt();
			a2 = sc.nextInt();
			b2 = sc.nextInt();

			// 겹치는지 여부를 체크
			// a : 직사각형
			// b : 선분
			// c : 점
			// d : 공통부분없음

			// 공통부분 없음
			int offset = 0;
			if (r2 < a1 || a2 < r1 || b2 < c1 || c2 < b1)
				offset = 3;
			// 점으로 만나는 경우
			else if ((r1 == a2 && c1 == b2) || (r2 == a1 && c2 == b1) || (r1 == a2 && c2 == b1)
					|| (r2 == a1 && c1 == b2)) {
				offset = 2;
			}
			// 선으로 만나는 경우
			else if (c2 == b1 || r2 == a1 || c1 == b2 || r1 == a2) {
				offset = 1;
			}
			System.out.println((char) ('a' + offset));
		}
	}

}
