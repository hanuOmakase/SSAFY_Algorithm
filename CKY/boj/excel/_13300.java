package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _13300 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sn = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> hm = new HashMap<>();

        while(sn -- > 0 ){
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            gen = gen == 0 ? gen + 10 : gen;
            int gra = Integer.parseInt(st.nextToken());
            hm.put(gen + gra, hm.getOrDefault(gen + gra, 0)+1);
        }

        int room = 0;
        for(Map.Entry<Integer, Integer> v : hm.entrySet()){
            room += v.getValue()/max;
            if(v.getValue() % max != 0)
                room += 1;
        }
        System.out.println(room);
    }
}
