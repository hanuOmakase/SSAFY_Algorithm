package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i=0; i<9; i++) {arr[i]= scanner.nextInt(); }
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int gap = sum - 100;
        int n1=0,n2=0;
        boolean find = false;
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(arr[i]+arr[j] == gap ) {;
                    n1=arr[i]; n2=arr[j];find = true;break;
                }
            }
            if(find) break;
        }
        for(int i=0; i<9; i++) {
            if(arr[i]==n1 || arr[i]==n2) continue;
            System.out.println(arr[i]);
        }
    }
}
