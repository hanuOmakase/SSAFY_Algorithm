package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        Queue<Integer> wait = new LinkedList<Integer>();
        for(int i=1; i<=N; i++){wait.add(i);}
        System.out.print('<');
        int time = 0;
        while(!wait.isEmpty()){
            for(int i=1; i<M; i++) wait.add(wait.remove());
            time += 1;
            if(time != N)
                System.out.print(wait.remove() + ", ");
            else
                System.out.print(wait.remove());
        }
        System.out.print('>');
    }
}
