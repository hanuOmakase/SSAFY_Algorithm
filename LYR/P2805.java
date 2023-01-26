import java.util.Scanner;

public class P2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int profit = 0;
			String[] farm = new String[N];
			for(int i = 0; i < N; i++) 
				farm[i] = sc.next();
			int left = N / 2;
			int right = N / 2;
			for(int i = 0; i < N; i++) {
				if(i <= N / 2) {
					for(int j = left; j <= right; j++)
						profit += (farm[i].charAt(j) - '0');
					left--; right++;
				}
				else {
					if(i == (N / 2) + 1) {
						left += 2;
						right -= 2;
					}
					for(int j = left; j <= right; j++)
						profit += (farm[i].charAt(j) - '0');
					left++; right--;
				}
			}
			System.out.println("#" + testCase + " " + profit);
		}
		sc.close();
	}
}
