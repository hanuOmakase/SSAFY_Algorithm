package BOJ;

import java.util.*;

public class Main_13023 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean flag = false;
    static void dfs(int K, int dep){
        int siz = arr[K].size();
        for(int i=0; i<siz; i++){
            if(!visited[arr[K].get(i)]){
                visited[arr[K].get(i)] = true;
                if(flag) return;
                if(dep+1 == 5){flag=true; return;}
                dfs(arr[K].get(i), dep+1);
                visited[arr[K].get(i)] = false;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int f, t, N=sc.nextInt(), M=sc.nextInt();
        arr = new ArrayList[N];
        for(int i=0; i<N; i++) arr[i] = new ArrayList<Integer>();
        visited = new boolean[N];
        for(int i=0; i<M; i++){
            f=sc.nextInt(); t=sc.nextInt();
            arr[f].add(t); arr[t].add(f);
        }
        for(int k=0; k<N; k++) {
            if(flag) break;
            visited[k] = true;
            dfs(k, 1);
            visited[k] = false;
        }
        if(flag) System.out.print(1);
        else System.out.print(0);
    }
}
