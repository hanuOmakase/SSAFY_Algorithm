import java.util.Scanner;

public class P2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int N = input.length();
		int R = 1;
		int C = input.length();
		for(int i = 2; i < input.length(); i++) {
			if((input.length() % i == 0) && (i <= input.length() / i)) {
				R = i;
				C = input.length() / i;
			}
			else if(i > input.length() / i) break;
		}
		int index = 0;
		char[][] code = new char[C][R];
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				code[i][j] = input.charAt(index);
				index++;
			}
		}
		String answer = "";
		for(int j = 0; j < R; j++) {
			for(int i = 0; i < C; i++) {
				answer += (code[i][j] + "");
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
