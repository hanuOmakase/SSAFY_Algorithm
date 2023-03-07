import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17281_야구_골드4_김영도_840ms { // 순열 + 시물레이션 + CustomQueue
    static int N;
    static int board[][];   // [i][j] : i이닝에서 선수 j의 결과
    static int order[];     // 선수 번호를 순열돌린 결과를 담을 arr
    static int answer;      // 최종정답
    public static void main(String[] args) throws Exception{
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][9];
        order = new int[9];
        order[3] = 0; // 4번 타자는 1번선수로 고정
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // start
        answer = 0;
        perm(0, 1);
        System.out.println(answer);
    }
    static void perm(int depth, int used){
        if(depth >= 9){
            int pos =0;
            int total = 0;
            for(int i=0;i<N;i++){
                int cnt =0;
                int myQue[] = new int[9 * 4 * 3 + 1]; // Queue<> 쓰면 시간초과남
                int qpos = 3;
                int qfront = 0;
                while(cnt < 3){
                    int idx = order[pos];
                    pos = (pos + 1) % 9;
                    if(board[i][idx] == 0){
                        cnt++;
                    }
                    else{
                        myQue[qpos++] = 1;
                        for(int j=0;j<board[i][idx]; j++){
                            total += myQue[qfront++];
                            if(j < board[i][idx] - 1) qpos++;
                        }
                    }
                }
            }
            if(answer < total) answer = total;
            return;
        }

        if(depth == 3) perm(depth+1, used);
        else {
            for (int i = 0; i < 9; i++) {
                if ((used & (1 << i)) != 0) continue;

                order[depth] = i;
                perm(depth+1, used | (1 << i));
            }
        }
    }
}
