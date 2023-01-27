import java.util.Scanner;
import java.util.Arrays;

public class P4698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] prime = new boolean [1000001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for(int i = 2; i * i < 1000001; i++) {
			if(prime[i])
				for(int j = i * i; j < 1000001; j += i)
					prime[j] = false;
		}
		
		for(int tc = 1; tc <= T; tc++) {
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int sum = 0;
			for(int i = A; i <= B; i++) {
				if(prime[i]) {
					String tmp = "" + i;
					if(tmp.contains(D)) sum++;
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
