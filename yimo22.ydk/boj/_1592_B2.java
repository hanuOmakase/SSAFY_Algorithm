
import java.util.*;

public class _1592_B2 {
	public static void main(String[] args) {
		// 현재 공을 받은 횟수가 홀수 -> 자기의 위치에서 시계방향으로 L번쨰
		// 짝수 -> 반시계로 L번째
		Scanner sc = new Scanner(System.in);
		int N, M, L;
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();

		// 공을 던지는 횟수 구하기
		int cnt = 0, pos = 0;
		int[] check = new int[N];
		while (isPromising(check, M)) {
			check[pos]++;
			if (check[pos] % 2 == 0) {
				pos = (pos + N - L) % N;
			} else
				pos = (pos + L) % N;
			cnt++;
		}
		System.out.println(cnt-1);
	}

	static boolean isPromising(int[] check, int M) {
		for (int w : check)
			if (w >= M)
				return false;
		return true;
	}
}
