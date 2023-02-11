package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 { // 2798. 블랙잭
	
	private static int[] cards; // 주어진 숫자 카드
	private static int[] numbers = new int[3]; // 카드 3장의 조합
	private static int N; // 카드 개수
	private static int M;
	private static int result; // 카드 3장의 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(result);
		
	}
	
	private static void comb(int cnt, int start) {
		
		if (cnt == 3) { // N개 중 3개 조합
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			if (sum <= M && sum > result) {
				result = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = cards[i];
			comb(cnt + 1, i + 1);
		}
	}
	
}
