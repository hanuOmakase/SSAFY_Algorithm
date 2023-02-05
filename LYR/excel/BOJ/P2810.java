package BOJ;

import java.util.Scanner;

public class P2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfSeat = sc.nextInt();
        String seat = sc.next();
        int S = 0; int L = 0;
        for(int i = 0; i < numOfSeat; i++){
            if(seat.charAt(i) == 'S') S++;
            else L++;
        }
        int result = 1 + numOfSeat;
        result -= (L / 2);
        if(result > numOfSeat) result = numOfSeat;
        System.out.println(result);
        sc.close();
    }
}
