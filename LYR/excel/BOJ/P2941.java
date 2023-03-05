import java.util.Scanner;

public class P2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int index = 0;
		int len = 0;
		while(index != input.length()) {
			if(input.charAt(index) == 'c') {
				if((index + 1 < input.length()) && (input.charAt(index + 1) == '=' || input.charAt(index + 1) == '-'))
					index += 2;
				else index++;
			}
			else if(input.charAt(index) == 'd') {
				if((index + 2 < input.length()) && (input.charAt(index + 1) == 'z' && input.charAt(index + 2) == '='))
					index += 3;
				else if(((index + 1) < input.length()) && input.charAt(index + 1) == '-')
					index += 2;
				else index++;
			}
			else if(input.charAt(index) == 'l' || input.charAt(index) == 'n') {
				if((index + 1 < input.length()) && input.charAt(index + 1) == 'j')
					index += 2;
				else index++;
			}
			else if(input.charAt(index) == 's' || input.charAt(index) == 'z') {
				if((index + 1 < input.length()) && input.charAt(index + 1) == '=')
					index += 2;
				else index++;
			}
			else index++;
			len++;
		}
		System.out.println(len);
		sc.close();
	}
}
