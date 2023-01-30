package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int aw = Integer.parseInt(st.nextToken());
        int ah = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        // 윗벽에 맞으면 x 감소, 아랫벽에 맞으면 x 증가
        // 오른쪽벽에 맞으면 y 감소, 왼쪽벽에 맞으면 y 증가
        // 튕기는 벽을 간단히 알 수 없을까
        boolean xInc = true;
        boolean yInc = true;

        while(time != 0){
            int xIncValue = w - aw;
            int yIncValue = h - ah;
            int xDecValue = aw;
            int yDecValue = ah;

        }

        System.out.println(aw + " " + ah);
    }
}
