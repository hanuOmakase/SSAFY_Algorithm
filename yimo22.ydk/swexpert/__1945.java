import java.util.*;
import java.io.*;

public class __1945 {
	static int T;
	static boolean[] isPrime;
	static final int MAX_W = (int) Math.sqrt(10000000);
	static int[] tmpPrime = { 2, 3, 5, 7, 11 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		isPrime = new boolean[MAX_W];
		// make prime;
		makePrime();
		for (int tc = 0; tc < T; tc++) {
			int value = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+1).append(" ");
			for (int i = 0; i < tmpPrime.length; i++) {
				int cnt = 0;
				while (value % tmpPrime[i] == 0) {
					cnt++;
					value /= tmpPrime[i];
				}
				sb.append(cnt).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	private static void makePrime() {
		// TODO Auto-generated method stub
		// init
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < MAX_W; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < MAX_W; j += i)
					isPrime[j] = false;
			}
		}
	}

}
