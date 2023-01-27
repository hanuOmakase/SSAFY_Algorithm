import java.util.Scanner;
import java.util.Stack;

public class P1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String input = sc.next();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < len; i++) {
				if(stack.isEmpty()) stack.push(input.charAt(i));
				else {
					if(stack.peek() == '(' && input.charAt(i) == ')')
						stack.pop();
					else if(stack.peek() == '{' && input.charAt(i) == '}')
						stack.pop();
					else if(stack.peek() == '[' && input.charAt(i) == ']')
						stack.pop();
					else if(stack.peek() == '<' && input.charAt(i) == '>')
						stack.pop();
					else
						stack.push(input.charAt(i));
				}
			}
			System.out.print("#" + tc + " ");
			if(stack.isEmpty()) System.out.println("1");
			else System.out.println("0");
		}
		sc.close();
	}
}
