package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> s = new Stack<>();

			int check = 1;

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == '{' || c == '[' || c == '<' || c == '(') {
					s.push(c);
					continue;
				} else if (s.isEmpty()) {
					check = 0;
					break;
				}

				if (c == '}' && s.pop() == '{') {
				} else if (c == ']' && s.pop() == '[') {
				} else if (c == '>' && s.pop() == '<') {
				} else if (c == ')' && s.pop() == '(') {
				} else
					check = 0;
			}
			System.out.println("#" + i + " " + check);
		}
	}
}
