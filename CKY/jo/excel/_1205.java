package CKY.jo.excel;
import java.util.*;
import java.io.*;

public class _1205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int jokerCount = 0;
		while (st.hasMoreTokens()) {
			int number = Integer.parseInt(st.nextToken());
			if (number == 0) {
				jokerCount++;
				continue;
			}
				
			s.add(number);
		}
		List<Integer> list = new ArrayList<>(s);
		Collections.sort(list);
		
		int maxLen = 0;
		for(int i = 0; i<list.size(); i++){
			int useJoker = jokerCount;
			int tempNumber = list.get(i);
			int len = 1;
			for(int j = i+1; j<list.size(); j++){
				int number = list.get(j);
				if(useJoker >= number - tempNumber - 1) {
					useJoker -= number - tempNumber - 1;
					len += number - tempNumber;
					tempNumber = number;
				}else 
					break;
			}
			len += useJoker;
			maxLen = Math.max(maxLen, len);
		}
		System.out.println(maxLen);
	}
}

