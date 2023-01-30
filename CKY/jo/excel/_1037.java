package CKY.jo.excel;

import java.util.*;
import java.io.*;

public class _1037 {

    static List<Node> xList = new ArrayList<>();
    static List<Node> yList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = st.nextToken().charAt(0) - '0';
            }
        }


        int count = 0;
        for (int i = 0; i < size; i++) {
            count += parityR(arr, i, 0);
        }

        for (int i = 0; i < size; i++) {
            count += parityC(arr, 0, i);
        }


        int changeBitCount = 0;
        Node cn = new Node(0, 0);
        if (count >= 1) {
            for (Node n1 : xList) {
                for (Node n2 : yList) {
                    if(n1.equals(n2))
                        cn = n2;
                    changeBitCount += n1.equals(n2) ? 1 : 0;
                }
            }

            if (changeBitCount == 1)
                System.out.println("Change bit (" + (cn.x + 1) + "," + (cn.y + 1) + ")");
            else if (xList.size() == 0 && yList.size() == 0)
                System.out.println("OK");
            else
                System.out.println("Corrupt");
        }
        else
            System.out.println("OK");
    }

    public static int parityR(int[][] arr, int x, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[x][i] == 1)
                count++;
        }

        if (count % 2 != 0) {
            for (int i = 0; i < arr.length; i++)
                xList.add(new Node(x, i));
            return 1;
        }
        return 0;
    }

    public static int parityC(int[][] arr, int x, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y] == 1)
                count++;
        }

        if (count % 2 != 0) {
            for (int i = 0; i < arr.length; i++)
                yList.add(new Node(i, y));
            return 1;
        }
        return 0;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Node n) {
        return this.x == n.x && this.y == n.y;
    }

    public String toString() {
        return this.x + " " + this.y;
    }

}