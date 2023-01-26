import java.util.Scanner;

public class P1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] price = new int [N];
			long profit = 0, maxNum = 0;
			for(int i = 0; i < N; i++) price[i] = sc.nextInt();
			for(int i = N - 1; i >= 0; i--) {
				if(price[i] > maxNum)
					maxNum = price[i];
				else
					profit += maxNum - price[i];
			}
			System.out.println("#" + testCase + " " + profit);
		}
		sc.close();
	}
}
