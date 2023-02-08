package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main_14969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int a = sc.nextInt();
            Integer[] arr = new Integer[a];
            for(int k=0; k<a; k++) arr[k] = sc.nextInt();
            Arrays.sort(arr, Collections.reverseOrder());
            int b = sc.nextInt();
            Integer[] brr = new Integer[b];
            for(int k=0; k<b; k++) brr[k] = sc.nextInt();
            Arrays.sort(brr,Collections.reverseOrder());
            char winner = '?';
            for(int k=0; k<min(a, b); k++){
                if(arr[k] > brr[k]){winner = 'A'; break;}
                else if(arr[k] < brr[k]){winner = 'B'; break;}
                else if(arr[k] == brr[k]) continue;
            }
            if(winner == '?'){
                winner = a > b ? 'A': a==b ? 'D' : 'B';
            }
            System.out.println(winner);
        }
    }
}
