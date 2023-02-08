package BOJ;

import java.util.Scanner;

public class Main_3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int arr[] = new int[T+1];
        int s,max=0,N = sc.nextInt(),f,t,a1=0,a2=0,t1=0,t2=0;
        for(int i=1; i<=N; i++){
            f=sc.nextInt(); t=sc.nextInt();
            if(t-f+1>t1){t1 = t-f+1; a1 = i;}
            s=0;
            for(int k=f; k<=t; k++){
                if(arr[k] == 0){arr[k] = i; s++;}
            }
            if(s>t2){t2=s; a2=i;}
        }
        System.out.print(a1+"\n"+a2);
    }
}
