package SWEA.d2;

import java.util.Arrays;
import java.util.Scanner;

public class _1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int test_case = 1; test_case <= N; test_case++){
            int[] arr = new int[10];
            for(int i=0; i<10; i++){arr[i] = sc.nextInt();}
            int sum = Arrays.stream(arr).sum();
            sum -= Arrays.stream(arr).min().getAsInt();
            sum -= Arrays.stream(arr).max().getAsInt();
            sum = (int)Math.round((double)sum / (double)8);
            System.out.printf("#%d %d\n",test_case, sum);
        }
    }
}
