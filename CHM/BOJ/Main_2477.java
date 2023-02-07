import java.util.Scanner;

public class Main_2477 { // 2477. 참외밭 s2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 참외
        int[][] dist = new int[6][2];

        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < 6; i++) {
            dist[i][0] = sc.nextInt();
            dist[i][1] = sc.nextInt();

            // 큰 직사각형의 크기 구하기
            if (dist[i][0] == 1 || dist[i][0] == 2) {
                if (dist[i][1] > maxRow) { maxRow = dist[i][1]; }
            } else {
                if (dist[i][1] > maxCol) { maxCol = dist[i][1]; }
            }
        }

        int smallSquare = 0;
        for (int i = 0; i < 6; i++) {
            int nextIdx = i + 1;
            if (i == 5) { nextIdx = 0; }
            if(dist[i][0] == 1 && dist[nextIdx][0] == 3) {
                smallSquare = dist[i][1] * dist[nextIdx][1];
                break;
            } else if (dist[i][0] == 2 && dist[nextIdx][0] == 4) {
                smallSquare = dist[i][1] * dist[nextIdx][1];
                break;
            } else if (dist[i][0] == 3 && dist[nextIdx][0] == 2) {
                smallSquare = dist[i][1] * dist[nextIdx][1];
                break;
            } else if (dist[i][0] == 4 && dist[nextIdx][0] == 1) {
                smallSquare = dist[i][1] * dist[nextIdx][1];
                break;
            }
        }

        System.out.println(K * (maxRow * maxCol - smallSquare));
    }
}
