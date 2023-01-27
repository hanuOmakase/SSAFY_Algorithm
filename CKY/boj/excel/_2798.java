package CKY.boj.excel;

import java.io.*;
import java.util.*;

public class _2798{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>(size);
        String nums = br.readLine();
        StringTokenizer st1 = new StringTokenizer(nums);
        while(st1.hasMoreTokens()){
            list.add(Integer.parseInt(st1.nextToken()));
        }
        Collections.sort(list);

        int max = 0;
        int tmp = 0;
        for(int i =0; i<list.size()-2; i++) {
            for (int j = i+1; j < list.size()-1; j++) {
                tmp = list.get(i) + list.get(j);
                if(tmp >= target) {
                    break;
                }
                for (int k = j+1; k < list.size(); k++) {
                    tmp = list.get(i) + list.get(j) + list.get(k);
                    if(tmp <= target && max < tmp)
                        max = tmp;
                }
            }
        }
        bw.write(max + "\n");
        bw.flush(); bw.close();
    }
}

