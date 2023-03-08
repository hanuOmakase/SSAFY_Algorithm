package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1922_네트워크_연결 {
    static class E {int f, t, v;public E(int f,int t,int v){this.f=f;this.t=t;this.v=v;}}
    static int[] mother;
    static int find_mother(int N){
        if(mother[N] == N) return N;
        else return mother[N] = find_mother(mother[N]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt(), ans=0, num=0, ff, tt;
        PriorityQueue<E> pq = new PriorityQueue<>(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.v-o2.v;
            }
        });
        mother = new int[N+1]; for(int i=1; i<=N; i++) mother[i] = i;
        for(int i=0; i<M; i++){pq.add(new E(sc.nextInt(),sc.nextInt(),sc.nextInt()));}
        while(num != N-1){
            E tmp = pq.poll();
            ff = find_mother(tmp.f); tt = find_mother(tmp.t);
            if(ff == tt) continue;
            mother[ff] = mother[tt] = Math.min(ff, tt);
            ans += tmp.v;
            num += 1;
        }
        System.out.println(ans);
    }
}
