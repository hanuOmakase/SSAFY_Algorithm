import java.util.Arrays;
import java.util.Scanner;

public class NextPerm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		
		// 전처리 : 오름차순 정렬
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		} while(np(input));
	}
	
	private static boolean np(int[] input) {
		int n = input.length;
		
		// step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i > 0 && input[i-1] >= input[i]) i--;
		if(i==0) {
			// 이 상태는 가장큰 순열의 형태이다.!
			return false;
		}
		
		// step2. 꼭대기 바로 앞 자리에 교환할 값을 뒤쪽부터 찾는다.
		// 현재 i-1이 교환할 위치
		int j = n-1;
		while(input[i-1] >= input[j]) j--;
		
		// step3. swap : 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		// 현재 j 가 교환할 대상
		swap(input, i-1, j);
		
		// step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k=n-1;
		while(i < k) {
			swap(input, i++, k--);
		}
		
		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
