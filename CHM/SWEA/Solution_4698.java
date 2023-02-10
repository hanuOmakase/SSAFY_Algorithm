package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4698 { // 4698. 테네스의 특별한 소수
	
	private static boolean[] isPrimeNum; // 소수 체크
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			prime(B);
			
			int count = 0;
			// 특별한 소수 = A 이상 B 이하의 소수 중 D를 포함하는 수
			for (int i = A; i <= B; i++) {
				if(isPrimeNum[i] == false) { // 소수이면
					String primeNumber = Integer.toString(i);
					if (primeNumber.contains(D)) {
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
	
	
	// 에라토스테네스의 체: k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외
	private static void prime(int n) {
		
		isPrimeNum = new boolean[n + 1]; // false로 초기화
	
		if (n < 2) { return; }
		
		isPrimeNum[0] = isPrimeNum[1] = true;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrimeNum[i]) { continue; } // true면 이전에 확인한 소수의 배수
			
			for (int j = i * i; j < isPrimeNum.length; j += i) {
				isPrimeNum[j] = true;
			}
		}
	}
	
}
