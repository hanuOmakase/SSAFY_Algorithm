
import java.util.Scanner;

public class Main_1592 { // 1592. 영식이와 친구들
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 3이상 50이하
		int M = sc.nextInt(); // 50이하
		int L = sc.nextInt();
		
		int[] ballCount = new int[N];
		ballCount[0] = 1;
		int result = 0;
		
		int i = 0; // 현재 공을 받은 사람
		while (true) {
			int pass = 0; // 공을 받을 사람
			
			if (ballCount[pass] == M) { // 한 사람이 공을 M번 받으면 게임 종료
				break;
			}
			
			if (ballCount[i] % 2 == 0) {
				pass = (i + (N - L)) % N;
			} else {
				pass = (i + L) % N;			
			}
			
			ballCount[pass]++;
			result++;
			i = pass;
		}
		
		System.out.println(result);
	}
}
