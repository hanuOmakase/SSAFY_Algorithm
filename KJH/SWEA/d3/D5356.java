package SWEA.d3;

import java.util.Scanner;

public class D5356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int tc=1; tc<=T; tc++){
            String[] arr = new String[5];
            int max = 0;
            for(int i=0; i<5; i++){arr[i] = scanner.next(); max = Integer.max(max, arr[i].length());}
            System.out.print("#"+tc+" ");
            for(int i=0; i<max; i++) {
                for (int j = 0; j < 5; j++) {
                    if(arr[j].length() > i){
                        System.out.print(arr[j].charAt(i));
                    }
                }
            }
            System.out.println();
        }
    }
}
