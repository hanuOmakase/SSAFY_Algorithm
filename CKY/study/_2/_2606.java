package CKY.study._2;

import java.io.*;
import java.util.*;

public class _2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st; 

        for(int i = 0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        visit = new boolean[N+1];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = -1; 
            if(st.hasMoreTokens())
                 b = Integer.parseInt(st.nextToken()); 

            if(b != -1) {
                list.get(a).add(b);
                list.get(b).add(a);
            }
        }

        bfs(1);
        System.out.println(count);
    }
    
    public static void bfs(int start){
        q.offer(start);
        visit[start] = true;
        
        while(!q.isEmpty()){
            int l = q.poll();
            for(int j = 0; j<list.get(l).size(); j++) {
                int number = list.get(l).get(j);
                if(!visit[number]) { 
                    count++;
                    q.offer(number); 
                    visit[number] = true; 
                }
            }
        }
    }
}


