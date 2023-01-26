import java.util.Scanner;

public class P3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			String[] card = new String [N];
			for(int i = 0; i < N; i++) card[i] = sc.next();
			String[] result = new String [N];
			int left = 0, right;
			if(N % 2 == 0) right = N / 2;
			else right = (N / 2) + 1;
			int mid = right;
			int index = 0;
			while(left < mid || right < N) {
				if(left < mid) {
					result[index] = card[left];
					index++;
				}
				if(right < N) {
					result[index] = card[right];
					index++;
				}
				left++;
				right++;
			}
			System.out.print("#" + testCase + " ");
			for(int i = 0; i < N; i++) System.out.print(result[i] + " ");
			System.out.println();
				
			
		}
		sc.close();
	}
}
