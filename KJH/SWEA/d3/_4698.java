package SWEA.d3;

import java.util.Scanner;
import java.util.Arrays;
public class _4698 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            int D=scanner.nextInt(), A=scanner.nextInt(), B=scanner.nextInt();
            boolean[] arr = new boolean[1000001];
            Arrays.fill(arr, true);
            int answer = 0;
            for(int i=2; i<=B; i++){
                if(arr[i]){
                    if(i >= A && i <= B){
                        int temp = i;
                        while(temp != 0){
                            if(temp%10 == D){
                                answer += 1;
                                break;
                            }
                            temp /= 10;
                        }
                    }
                    int temp = i, j = 2;
                    while(temp*j <= B){
                        arr[temp*(j++)] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,answer);
        }
    }
}