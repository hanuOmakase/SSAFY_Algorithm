package BOJ;

import java.util.Scanner;

public class Main_2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int now = 1,answer = 1, offset = 6;
        while(now < T) {
            answer += 1;
            now += offset;
            offset += 6;
        }
        System.out.println(answer);
    }
}
