import java.util.Scanner;

public class P4789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String claps = sc.next();
			int hire = 0;
			int clapping = 0;
			clapping += claps.charAt(0) - '0';
			for(int i = 1; i < claps.length(); i++) {
				if(claps.charAt(i) != '0') {
					if(clapping < i) {
						hire += (i - clapping);
						clapping += (i - clapping);
					}
					clapping += (claps.charAt(i) - '0');
				}
			}
			System.out.println("#" + tc + " " + hire);
		}
		sc.close();
	}
}
