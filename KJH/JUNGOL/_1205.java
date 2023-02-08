package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class _1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Integer[] arr = new Integer[T];
        for(int i=0; i<T; i++) {arr[i]=sc.nextInt(); }
        Arrays.sort(arr);
        int joker_num = 0;
        for(int i=0; i<T; i++) {if(arr[i]==0 ) joker_num++; else break;}
        if(joker_num == arr.length || joker_num == arr.length-1) {
            System.out.println(arr.length);
            System.exit(0);
        };
        arr = Arrays.copyOfRange(arr, joker_num, T);
        int answer = joker_num, temp, rest=0;
        for(int i=0; i<arr.length; i++) {
            temp = arr[i];
            rest = joker_num;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] == temp) continue;
                if(rest - (arr[j] - temp -1) >= 0) {
                    rest -= (arr[j] - temp - 1);
                    temp = arr[j];
                }
                answer = Math.max(answer, temp - arr[i] + 1 + rest );
            }
        }
        System.out.println(answer);
    }
}
