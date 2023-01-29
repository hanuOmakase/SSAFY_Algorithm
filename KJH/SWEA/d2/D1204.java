package SWEA.d2;

import java.util.Scanner;

public class D1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int Trash = sc.nextInt();
            int[] arr = new int[101];
            int answer=0, num=0;
            int temp;
            for(int i=0; i<1000; i++){
                temp = sc.nextInt();
                arr[temp] += 1;
                if(arr[temp] > num){answer = temp; num = arr[temp];}
                else{if(arr[temp] == num && temp > answer){answer = temp; num=arr[temp];}}
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
