
import java.util.*;

public class _2810_B1 {
	public static void main(String[] args) {
		
		/* Test Case
		 * 8
		 * LLLLLLLL
		 * -> 3명 불가
		 * 8
		 * SLLSLLSS 
		 * -> 1명불가
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();

		// i번쨰 사람은 i, i+1 홀더를 쓸 수 있다.
		boolean[] holder = new boolean[N + 1];
		Arrays.fill(holder, true);

		// 커플좌석 처리
		for (int i = 0; i < N - 1; i++) {
			if (str.charAt(i) == 'L' && str.charAt(i + 1) == 'L') {
				holder[i] = false;
				i++;
			}
		}
		int answer = N;
		for (int i = 0; i < N; i++) {
			if (!holder[i] && !holder[i + 1]) {
				answer--;
				continue;
			}

			if (holder[i]) {
				holder[i] = false;
			}
			else {
				holder[i+1] = false;
			}
		}
		System.out.println(answer);
	}
}
