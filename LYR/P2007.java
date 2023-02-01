import java.util.Scanner;

public class P2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String word = sc.next();
			int result = 0;
			for(int i = 0; i < word.length(); i++) {
				if(i > 0 && word.charAt(i) == word.charAt(0)) {
					if(word.charAt(i+1) == word.charAt(1)) {
						result = i;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
