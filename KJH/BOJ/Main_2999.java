package BOJ;

import java.util.Scanner;

public class Main_2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a=0, b=0;
        for(int i=(int)Math.sqrt(str.length()); i>=1; i--){
            if(str.length()%i==0){b=i; a=str.length()/i; break;}
        }
        if(a>b) {int t=a; a=b; b=t;}
        char[][] arr = new char[a][b];
        int t = 0;
        for(int i=0; i<b; i++) {
            for (int j = 0; j < a; j++) {
                arr[j][i] = str.charAt(t++);
            }
        }
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print(arr[i][j]);
            }
        }
    }
}
