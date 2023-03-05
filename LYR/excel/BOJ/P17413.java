import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		String answer = "";
		boolean isTag = false;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '<') {
				isTag = true;
				answer += input.charAt(i);
			}
			else if(input.charAt(i) == '>') {
				isTag = false;
				answer += input.charAt(i);
			}
			else if(isTag || input.charAt(i) == ' ') {
				answer += input.charAt(i);
			}
			else if(!isTag) {
				int index = i;
				while(index < input.length() && input.charAt(index) != ' ' && input.charAt(index) != '<')
					index++;
				for(int j = index - 1; j >= i; j--) {
					answer += input.charAt(j);
				}
				i = index - 1;				
			}
		}
		wr.write(answer);
		wr.flush();
	}
}
