import java.util.Scanner;

public class __1976 {
	static int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		StringBuilder sb;
		for(int tc = 0; tc<T; tc++) {
			sb = new StringBuilder();
			int h1, m1, h2, m2;
			h1 = sc.nextInt();
			m1 = sc.nextInt();
			h2 = sc.nextInt();
			m2 = sc.nextInt();
			int sumHour = h1 + h2;
			int sumMinute = m1 + m2;
			if(sumHour > 12) sumHour -= 12;
			if(sumMinute >= 60) {
				sumHour++;
				sumMinute -= 60;
			}
			if(sumHour > 12) sumHour -= 12;
			sb.append("#").append(tc+1).append(" ");
			sb.append(sumHour).append(" ").append(sumMinute);
			
			System.out.println(sb.toString());
			
		}
	}

}
