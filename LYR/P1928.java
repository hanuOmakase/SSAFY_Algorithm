package SWEA;

import java.util.Base64;
import java.util.Scanner;
import java.util.Base64.Decoder;;

public class P1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			Decoder decode = Base64.getDecoder();
			String input = sc.next();
			byte[] answer = decode.decode(input);
			System.out.println("#" + tc + " " + new String(answer));
		}
		sc.close();
	}
}
