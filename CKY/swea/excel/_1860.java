package CKY.swea.excel;
import java.util.*;
import java.io.*;
public class _1860 {
	public static void main(String args[]) throws Exception
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			int res = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
            int fish = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            Set<Integer> s = new HashSet<>();
             
            while(st.hasMoreTokens()) 
                s.add(Integer.parseInt(st.nextToken()));
             
            int totalFish = 0;
             
            boolean check = true;
             
            for(int j = 0; j<=11_111; j++) {
                if(j % time == 0 && j >= time)
                    totalFish += fish;
                 
                if(s.contains(j)) {
                    if(totalFish <= 0) {
                        check = false;
                        break;
                    }
                    else
                        totalFish -=1;
                }
            }
             
            System.out.println("#" + i + " " + (check ? "Possible" : "Impossible"));
        }
    }
}
