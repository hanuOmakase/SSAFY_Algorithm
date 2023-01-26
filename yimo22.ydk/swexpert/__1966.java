import java.util.Arrays;
import java.util.Scanner;

public class __1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			
			// sort
			Arrays.sort(arr);
			
			System.out.print("#" + (tc+1));
			for(int w : arr) {
				System.out.print(" "+ w);
			}
			System.out.println();
		}
	}

}
