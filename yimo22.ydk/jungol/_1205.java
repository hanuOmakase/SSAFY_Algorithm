package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int joker = 0;
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean isAllZero = true;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				joker++;
				continue;
			}
			isAllZero = false;
		}

		// start
		// 가장 긴 길이의 스트레이트 구하기
		// N <= 1000
		// w <= 1M

		// 중복제거 & 정렬
		HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		Integer[] brr = set.toArray(new Integer[set.size()]);
		Arrays.sort(brr);
		int answer = 0;
		for (int i = 0; i < brr.length; i++) {
			// 조커 제외
			if (brr[i] == 0)
				continue;

			int avail = joker;
			int j;
			for (j = i + 1; j < brr.length; j++) {
				if (brr[j] == brr[j - 1] + 1)
					continue;

				// joker를 사용하는 경우
				int need = brr[j] - brr[j - 1] - 1;
				if (need > avail)
					break;
				avail -= need;
			}
			// brr[j] 전까지 가능하므로 idx감소
			j--;
//			System.out.println(String.format("%d %d : %d / %d", i, j, answer, brr[j] - brr[i] + 1 + avail));
			answer = Math.max(answer, brr[j] - brr[i] + 1 + avail);
		}
		if (isAllZero)
			System.out.println(N);
		else
			System.out.println(answer);
	}

}