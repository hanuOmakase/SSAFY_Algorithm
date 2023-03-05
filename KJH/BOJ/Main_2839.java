package BOJ;

import java.util.Scanner;

public class Main_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int temp,answer=10000000, i=3, j=0;
        while(i*j<=T){
            temp = (T -  i*j);
            if(temp % 5 == 0){answer = answer < (j + temp/5) ? answer : (j+temp/5);}
            j++;
        }
        if(answer == 10000000) answer = -1;
        System.out.println(answer);
    }
}
