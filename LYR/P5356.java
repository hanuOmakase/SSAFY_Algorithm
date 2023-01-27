import java.util.Scanner;

public class P5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			String[] words = new String [5];
			int maxLen = 0;
			String answer = "";
			for(int i = 0; i < 5; i++) {
				words[i] = sc.next();
				if(words[i].length() > maxLen) maxLen = words[i].length();
			}
			for(int i = 0; i < maxLen; i++)
				for(int j = 0; j < 5; j++)
					if(words[j].length() > i)
						answer += words[j].charAt(i);
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
}
