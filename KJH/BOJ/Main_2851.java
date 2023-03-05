package BOJ;

import java.util.Scanner;
public class Main_2851 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[10];
        for(int i=0; i<10; i++) arr[i] = sc.nextInt();
        for(int i=0; i<10; i++) {
            if(Math.abs((sum+arr[i]-100)) <= Math.abs(sum-100)){sum+=arr[i];}
            else break;
        }
        System.out.println(sum);
    }
}