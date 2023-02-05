package BOJ;

import java.util.Scanner;

public class P2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mushroom = new int [10];
        final int target = 100;
        for(int i = 0; i < 10 ; i++)
            mushroom[i] = sc.nextInt();
        for(int i = 0; i < 10; i++) {
            if(i != 0)
                mushroom[i] += mushroom[i - 1];
        }
        for(int i = 0; i < 10; i++) {
            if(mushroom[i] == 100) {
                System.out.println(target);
                break;
            }
            else if(mushroom[i] > 100) {
                if((target - mushroom[i - 1]) < mushroom[i] - target )
                    System.out.println(mushroom[i - 1]);
                else
                    System.out.println(mushroom[i]);
                break;
            }
            if(i == 9)
                System.out.println(mushroom[i]);
        }
        sc.close();
    }
}
