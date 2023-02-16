import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1.
// 스택으로 한 단어씩 저장
// 현재값이 = 이면 스택 top 확인
// top이 c 또는 s이면 그대로 한 단어 -> pop
// top이 z 이면 한 번 pop 하고 다시 top 확인
// top이 d 이면 그대로 한 단어 -> pop
// top이 d가 아니면 이전 pop까지가 한 단어
// 위와 같은 방법으로 현재값이 - 일 때, j일 때 확인

// 2.
// pop하고 남은 문자랑 새로 들어온 문자가 한 단어가 되면 안됨
// --> 스택말고 인덱스로 문자열 접근해서 풀기

// 3.
// d, l, n을 제외한 알파벳이면 count++
// d이면 다음 자리 확인 
// -> 다음 자리 z이고 다다음자리 =이면 count++ 하고 index +2
// -> 다음 자리 -이면 count++하고 index +1
// n 또는 l이면 다음 자리 확인
// -> 다음 자리 j이면 count++ 하고 index +1

public class Main_2941 { // 2941. 크로아티아 알파벳
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			switch(c) {
			case 'd':
				try {
					if (word.charAt(i + 1) == '-') {
						count++;
						i += 1;
					} else if (word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
						count++;
						i += 2;
					} else {
						count++;
					}
				} catch (IndexOutOfBoundsException e) { // d 다음 글자 없으면
					count++;
				}
				break;
			case 'n': case 'l':
				try {
					if (word.charAt(i + 1) == 'j') {
						count++;
						i += 1;
					} else {
						count++;
					}
				} catch (IndexOutOfBoundsException e) { // n, l 다음 글자 없으면
					count++;
				}
				break;
			case '=': case '-':
				break;
			default:
				count++;
			}
		}
		
		System.out.println(count);
	}
}
