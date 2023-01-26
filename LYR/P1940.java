import java.util.Scanner;

public class P1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int dist = 0;
			int currSpeed = 0;
			for(int i = 0; i < N; i++) {
				int command = sc.nextInt();
				if(command == 1) {
					currSpeed += sc.nextInt();
				}
				else if(command == 2) {
					currSpeed -= sc.nextInt();
					if(currSpeed < 0) currSpeed = 0;
				}
				dist += currSpeed;
			}
			System.out.println("#" + testCase + " " + dist);
		}
		sc.close();
	}
}
