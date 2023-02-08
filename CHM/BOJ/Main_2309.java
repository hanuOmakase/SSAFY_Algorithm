import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 { // 2309. 일곱 난쟁이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] heights = new int[9];
		int total = 0;
		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();
			total += heights[i];
		}
		
		int diff = total - 100;
		
		Arrays.sort(heights);
ex:		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights.length; j++) {
				if (heights[i] + heights[j] == diff) {
					heights[i] = 100;
					heights[j] = 100;
					break ex;
				}
			}
		}
		
		Arrays.sort(heights);
		for (int i = 0; i < heights.length - 2; i++) {
			System.out.println(heights[i]);
		}
	}
}
