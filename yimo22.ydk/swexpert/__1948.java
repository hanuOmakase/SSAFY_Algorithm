import java.util.Scanner;

public class __1948 {
	static int T;
	static final int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int sum1=0, sum2 =0;
			for(int tmp=0; tmp<m1-1; tmp++) {
				sum1 += days[tmp];
			}
			sum1 += d1;
			
			for(int tmp=0;tmp<m2-1; tmp++) {
				sum2 += days[tmp];
			}
			sum2 += d2;
			System.out.println("#"+(i+1) + " " + (sum2 - sum1 + 1));
		}
	}

}
