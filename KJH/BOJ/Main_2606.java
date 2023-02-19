package BOJ;

import java.util.*;

public class Main_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(),f,t,ne;
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer>[] conn = new ArrayList[N+1];
        for(int i=0; i<=N;i++){conn[i] = new ArrayList<Integer>();}
        for(int i=0; i<K; i++){
            f = sc.nextInt(); t= sc.nextInt();
            conn[f].add(t); conn[t].add(f);
        }
        Queue<Integer> wait = new LinkedList<Integer>();
        wait.add(1); set.add(1);
        while(!wait.isEmpty()){
            ne = wait.poll();
            for(Integer temp : conn[ne]){
                if(set.contains(temp)) continue;
                set.add(temp);
                wait.add(temp);
            }
        }
        System.out.println(set.size()-1);
    }
}
