package BOJ;

import java.util.Scanner;

public class Main_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[6];
        for(int i=0; i<6; i++){sc.nextInt(); arr[i] = sc.nextInt();}
        int left=0,b=0,a=0, right=0;
        for(int i=0; i<6; i+=2){if(arr[i] > left) {left = arr[i];b = i;}}
        for(int i=1; i<6; i+=2){if(arr[i] > right) {right = arr[i];a = i;}}
        int full = left * right;
        if((a+1)%6 != b){int t = a; a = b; b = t;}
        a = a - 2;  b = (b + 2)%6;
        if(a<0) a += 6;
        System.out.println(T*(left*right - arr[b]*arr[a]));
    }
}
