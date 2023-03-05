package BOJ;

import java.util.Scanner;

public class Main_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String str = sc.next();
            int answer = 0, go=1;
            for(int k=0; k<str.length(); k++){
                if(str.charAt(k)=='O'){answer += go++;}
                else{go = 1;}
            }
            System.out.println(answer);
        }
    }
}
