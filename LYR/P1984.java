import java.util.Arrays;
import java.util.Scanner;

public class P1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int[] arr = new int [10];
			for(int i = 0; i < 10; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			double avg = 0;
			for(int i = 1; i < 9; i++) avg += arr[i];
			avg /= (double)8;
			avg = Math.round(avg);
			System.out.println("#" + testCase + " " + (int)avg);
		}
		sc.close();
	}
}
