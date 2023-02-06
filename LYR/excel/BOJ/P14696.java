import java.util.Scanner;

public class P14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int round = sc.nextInt();
		for(int i = 0; i < round; i++) {
			int[] aCard = new int [4];
			int[] bCard = new int [4];
			
			int aNum = sc.nextInt();
			for(int j = 0; j < aNum; j++) {
				int num = sc.nextInt();
				aCard[num - 1]++;
			}
			int bNum = sc.nextInt();
			for(int j = 0; j < bNum; j++) {
				int num = sc.nextInt();
				bCard[num - 1]++;
			}
			
			for(int j = 3; j >= 0; j--) {
				if(aCard[j] < bCard[j]) {
					System.out.println("B");
					break;
				}
				else if(aCard[j] > bCard[j]) {
					System.out.println("A");
					break;
				}
				if(j == 0) System.out.println("D");
			}
		}
		sc.close();
	}
}
