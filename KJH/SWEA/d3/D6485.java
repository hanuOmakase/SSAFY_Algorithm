package SWEA.d3;

import java.util.Scanner;

public class D6485 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for(int t=1; t<=tc; t++){
            int N = scanner.nextInt();
            int[] arr = new int[5001];
            for(int i=0; i<N; i++){
                int A = scanner.nextInt(), B = scanner.nextInt();
                for(int k=A; k<=B; k++){
                    arr[k] += 1;
                }
            }
            int P = scanner.nextInt();
            System.out.printf("#%d ",t);
            for(int k=0; k<P; k++){
                System.out.print(arr[scanner.nextInt()] + " ");
            }
            System.out.println();
        }
    }
}
