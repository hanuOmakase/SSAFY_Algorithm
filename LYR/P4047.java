import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P4047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			Set<String> set = new HashSet<String>();
			String word = sc.next();
			int[] result = {13, 13, 13, 13};
			boolean isError = false;
			for(int i = 0; i < word.length(); i += 3) {
				String tmp = word.substring(i, i + 3);
				if(set.contains(tmp)) {
					System.out.println("#" + testCase + " " + "ERROR");
					isError = true;
					break;
				}
				else { 
					set.add(tmp);
					switch(tmp.charAt(0)) {
					case 'S': result[0]--; break;
					case 'D': result[1]--; break;
					case 'H': result[2]--; break;
					case 'C': result[3]--; break;
					}
				}
			}
			if(!isError) {
				System.out.print("#" + testCase + " ");
				for(int i = 0; i < 4; i++)
					System.out.print(result[i] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
