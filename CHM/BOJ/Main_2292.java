import java.util.Scanner;

public class Main_2292 { // 2292. 벌집
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int i = 1;
		
		if (N != 1) {
			N = (N - 2) / 6;
			
			int layer = 0;
			while (true) {
				layer += i++;
				if (layer > N) {
					break;
				}
			}
		}
		
		System.out.println(i);
	}
}
