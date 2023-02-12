
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 태그: <> 괄호로 둘러싸인 길이 3이상의 부분 문자열
// 단어: 알파벳 소문자와 숫자로 이루어진 부분 문자열, 연속하는 두 단어는 공백으로 구분
// 태그는 단어가 아님, 태그와 단어 사이에는 공백 없음
// 주어진 문자열의 '단어'를 뒤집어서 출력하기

public class Main_17413 { // 17413. 단어 뒤집기 2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>(); // 단어이면 스택에 저장
		boolean isTag = false; // 현재 읽고 있는 문자가 태그인지(괄호 안) 체크
		
		for (int i = 0; i < S.length(); i++) {
			char s = S.charAt(i);
			
			if (s == '<') {
				isTag = true;
				while(stack.size() != 0) {
					sb.append(stack.pop()); // 스택에 쌓여있던 단어 출력
				}
			} else if (s == '>') {
				isTag = false;
				sb.append(s);
				continue;
			}
			
			// 태그 안 문자
			if (isTag) { sb.append(s); continue; }
			
			// 태그 밖 문자(=단어)
			if (s == ' ') { // 단어 구분자(공백)이면
				while(stack.size() != 0) {
					sb.append(stack.pop()); // 스택에 쌓여있던 단어 출력
				}
				sb.append(s);
			} else { stack.push(s); }
			
		} // end of for
		
		// 남아있는 단어 출력
		while(stack.size() != 0) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
