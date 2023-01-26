import java.util.Scanner;

public class __1970 {

	static final int[] cost = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10 };
	static int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+1);
			System.out.println(sb.toString());
			Solve(N);
		}
	}
	private static void Solve(int price) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cost.length; i++) {
			System.out.print(price / cost[i] + " ");
			price %= cost[i];
		}
		System.out.println();
	}

}
