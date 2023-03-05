package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){arr[i] = sc.nextInt();}
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    int temp = arr[i]+arr[j]+arr[k];
                    if(temp > M) break;
                    if(temp > answer) answer = temp;
                }
            }
        }
        System.out.println(answer);
    }
}
