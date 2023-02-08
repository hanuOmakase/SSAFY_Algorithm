import java.util.Scanner;

public class P13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] girl = new int [6];
		int[] boy = new int [6];
		int rooms = 0;
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			if(gender == 0)
				girl[grade - 1]++;
			else
				boy[grade - 1]++;
		}
		for(int i = 0; i < 6; i++) {
			rooms += girl[i] / K;
			if(girl[i] % K != 0) rooms++;
			rooms += boy[i] / K;
			if(boy[i] % K != 0) rooms++;
		}
		System.out.println(rooms);
		sc.close();
	}
}
