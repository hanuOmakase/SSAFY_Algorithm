import java.util.Scanner;

public class P5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int currStick = 0;
			boolean isRaserLeft = true;
			String sticks = sc.next();
			for(int i = 0; i < sticks.length(); i++) {
				if(sticks.charAt(i) == '(') {
					currStick++;
					sum++;
					isRaserLeft = true;
				}
				else if(sticks.charAt(i) == ')' && isRaserLeft) {
					currStick--;
					sum--;
					sum += currStick;
					isRaserLeft = false;
				}
				else if(sticks.charAt(i) == ')') {
					currStick--;
					isRaserLeft = false;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
