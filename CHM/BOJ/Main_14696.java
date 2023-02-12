
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14696 { // 14696. 딱지놀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
ex:     for (int i = 0; i < N; i++) {
            int[] A = new int[4];
            int[] B = new int[4];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int aa = 0; aa < a; aa++) {
                A[Integer.parseInt(st.nextToken()) - 1]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int bb = 0; bb < b; bb++) {
                B[Integer.parseInt(st.nextToken()) - 1]++;
            }

            for (int j = 3; j >= 0; j--) {
                if (A[j] > B[j]) {
                    sb.append("A\n");
                    continue ex;
                } else if (A[j] < B[j]) {
                    sb.append("B\n");
                    continue ex;
                }
            }
            sb.append("D\n");
        }
        System.out.println(sb);
    }
}
