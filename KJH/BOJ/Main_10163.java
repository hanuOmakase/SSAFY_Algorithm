package BOJ;

import java.util.Scanner;

public class Main_10163 {
    static int[][] arr = new int[1002][1002];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a,b,c,d;
        int[] paper = new int[T+1];
        for(int k=1; k<=T; k++){
            a=sc.nextInt();b=sc.nextInt();c=sc.nextInt();d=sc.nextInt();
            for(int i=a; i<a+c; i++){
                for(int j=b; j<b+d; j++){
                    paper[arr[i][j]]-=1;
                    paper[k] += 1;
                    arr[i][j] = k;
                }
            }
        }
        for(int i=1; i<=T; i++){
            System.out.println(paper[i]);
        }
    }
}
