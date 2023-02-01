import java.util.Scanner;

public class P7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] cities = new int [N + 2];
			for(int i = 1; i < N + 1; i++)
				cities[i] = sc.nextInt();
			int result = 0;
			cities[0] = 1;
			cities[N + 1] = 1;
			int currDis = 0;
			for(int i = 0; i < N + 2; i++) {
				if(cities[i] == 0 && currDis == D) {
					cities[i] = 1;
					result++;
					currDis = 0;
				}
				else if(cities[i] == 1){
					currDis = 0;
				}
				currDis++;
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
