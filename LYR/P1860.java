package SWEA;

import java.util.Scanner;
import java.util.Arrays;

public class P1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] arrivals = new int[N];
            int min = 11112;
            int max = 0;
            for(int i = 0; i < N; i++) {
                arrivals[i] = sc.nextInt();
                if(arrivals[i] > max) max = arrivals[i];
                if(arrivals[i] < min) min = arrivals[i];
            }
            Arrays.sort(arrivals);

            int currFish = 0;
            boolean isPoss = true;

            currFish += ((min - 1) / M) * K;

            int index = 0;

            for(int i = min; i <= max; i++){
                if((i != 0) && i % M == 0) currFish += K;
                while(arrivals[index] == i){
                    if(currFish < 1){
                        isPoss = false;
                        System.out.println("#" + tc + " Impossible");
                        break;
                    }
                    else currFish--;
                    if(index == N - 1) break;
                    index++;
                }
            }

            if(isPoss) System.out.println("#" + tc + " Possible");
        }
        sc.close();
    }
}
