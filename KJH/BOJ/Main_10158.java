package BOJ;

import java.util.Scanner;

public class Main_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w=sc.nextInt(), h=sc.nextInt();
        int p=sc.nextInt(), q=sc.nextInt();
        int t=sc.nextInt();
        p = (p + t) % (2*w); if(p>=w){p = w-Math.abs(w-p);}
        q = (q + t) % (2*h); if(q>=h){q = h-Math.abs(h-q);}
        System.out.println(p+" "+q);
    }
}
