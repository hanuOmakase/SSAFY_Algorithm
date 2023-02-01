import java.util.Scanner;

public class P6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] A = new int [N];
			int[] B = new int [N];
			int[] nodes = new int [5001];
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			int[] resBus = new int [P];
			for(int i = 0; i < P; i++) resBus[i] = sc.nextInt();
			
			for(int i = 0; i < N; i++) 
				for(int j = A[i]; j <= B[i]; j++)
					nodes[j]++;
			System.out.print("#" + tc + " ");
			for(int i = 0; i < P; i++) {
				System.out.print(nodes[resBus[i]] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
