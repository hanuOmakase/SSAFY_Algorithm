import java.util.Scanner;

public class P3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] rollcake = new int[L + 1];
		int N = sc.nextInt();
		int[] numOfCake = new int[N + 1];
		int estimatedMax = -1;
		int estimatedMaxP = -1;
		for(int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			if(K - P > estimatedMax) {
				estimatedMax = K - P;
				estimatedMaxP = i;
			}
			for(int j = P; j <= K; j++)
				if(rollcake[j] == 0) rollcake[j] = i;
		}
		int currMax = -1;
		int maxP = -1;
		
		for(int i = 1; i <= L; i++) {
			if(rollcake[i] != 0) {
				numOfCake[rollcake[i]]++;
				if(numOfCake[rollcake[i]] > currMax) {
					currMax = numOfCake[rollcake[i]];
					maxP = rollcake[i];
				}
				else if(numOfCake[rollcake[i]] == currMax) {
					if(maxP > rollcake[i]) maxP = rollcake[i];
				}
			}
		}
		System.out.println(estimatedMaxP);
		System.out.println(maxP);
		sc.close();
	}
}
