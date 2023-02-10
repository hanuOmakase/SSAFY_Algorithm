package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2810 { // 2810. 컵홀더
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		// 컵홀더의 개수 = S 개수 + L/2 개수 + 1
		int cups = 1;
		int lCount = 0;
		for (int i = 0; i < seat.length(); i++) {
			if (seat.charAt(i) == 'S') {
				cups++;
			} else if (seat.charAt(i) == 'L') {
				lCount++;
			}
		}
		cups += lCount / 2;
		
		System.out.println(Math.min(cups, N));
	}
}
