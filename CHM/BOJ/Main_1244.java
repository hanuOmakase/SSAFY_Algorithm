package boj.S4;

import java.util.Scanner;

public class Main_1244 { // 1244. 스위치 켜고 끄기
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 스위치 개수 (1 이상 100 이하)
		
		int[] switches = new int[n]; // 스위치 (0:off 1:on)
		for (int i = 0; i < switches.length; i++) {
			switches[i] = sc.nextInt();
		}
		
		int nStdudent = sc.nextInt(); // 학생 수 (1 이상 100 이하)
		
		for (int i = 0; i < nStdudent; i++) {
			
			if (sc.nextInt() == 1) { // 남학생
				
				int num = sc.nextInt(); // 받은 번호
				for (int j = 1; j * num <= switches.length; j++) { // 받은 번호의 배수 위치의 스위치 상태 변경
					switches[j * num - 1] = switches[j * num - 1] == 0 ? 1 : 0;
				}
				
			} else { // 여학생
				
				int num = sc.nextInt(); // 받은 번호
				switches[num - 1] = switches[num - 1] == 0 ? 1 : 0; // 받은 번호 스위치 상태 변경
				
				for (int j = 1; j <= Math.min(n - num, num - 1); j++) {
					if (switches[num - j - 1] == switches[num + j - 1]) { // 대칭이면 스위치 상태 변경
						switches[num - j - 1] = switches[num - j - 1] == 0 ? 1 : 0;
						switches[num + j - 1] = switches[num + j - 1] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < switches.length; i++) {
			System.out.print(switches[i] + " ");
			if (i % 20 == 19) {
				System.out.println();
			}
		}
		
	}
}
