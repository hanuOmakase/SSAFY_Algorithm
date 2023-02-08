package BOJ;

import java.util.Scanner;

public class Main_2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int answer = 1;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'S') answer += 1;
            else if(str.charAt(i) == 'L'){answer += 1; i++;}
        }
        if(answer > N) System.out.println(N);
        else System.out.println(answer);
    }
}

