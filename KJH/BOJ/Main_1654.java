package BOJ;

import java.util.Scanner;

public class Main_1654 {
    static long calcul(long[] arr,long v){
        long sum = 0;
        for(long k: arr) sum += k/v;
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(), N = sc.nextInt();
        long mid = 0, num, s = 1, e=0;
        long[] lens = new long[K];
        for (int i = 0; i < K; i++) {lens[i] = sc.nextInt(); e = Math.max(lens[i], e);}
        if(calcul(lens, e) >= N){
            System.out.print(e);
            return;
        }
        while (s+1 != e && s != e) {
            mid = (s+e)/2;
            num = calcul(lens, mid);
            if(num < N) e = mid;
            else s = mid;
        }
        System.out.print(s);
    }
}
