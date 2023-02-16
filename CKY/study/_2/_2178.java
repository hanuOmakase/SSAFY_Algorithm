package CKY.study._2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class _2178{
    static Queue<Node> q = new LinkedList<>();
    static int[] xrange = {1, -1, 0, 0};
    static int[] yrange = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] maze = new int[A][B];
        for(int i = 0; i<A; i++){
            String str = br.readLine();
            for(int j = 0; j<B; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        Node result = bfs(0, 0, maze, A - 1, B - 1);
        System.out.println(result.distance);
    }

    public static Node bfs(int x, int y, int[][] maze, int A, int B){
        int distance = 1;
        Node p = new Node(x, y, 1);
        q.offer(p);
        maze[x][y] = 0; // 방문처리

        while(!q.isEmpty()){
        	Node np = q.poll();
            for(int i = 0; i<4; i++){
                int x1 = np.x - xrange[i];
                int y1 = np.y - yrange[i];
                
                if(x1 <= -1 || x1 > A || y1 <= -1 || y1 > B) // 범위제한
                    continue;
                
                if(maze[x1][y1] == 1){ // 1이면 q offer
                    int dis = np.distance;
                    q.offer(new Node(x1, y1, ++dis));
                    maze[x1][y1] = 0; // 방문처리
                    if(x1 == A && y1 == B){
                    	np.distance++;
                        return np;
                    }
                }
            }
        }
        return p;
    }
    static class Node{
        public int x;
        public int y;
        public int distance;

        Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
} 



