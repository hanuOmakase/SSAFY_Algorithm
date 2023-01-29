package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] alpha = {"c-", "c=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        ppp:
        for (int i = 0; i < str.length(); i++) {
            if (i <= str.length() - 3 && str.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 2;
                continue;
            } else if (i <= str.length() - 2) {
                String s2 = str.substring(i, i + 2);
                for (int j = 0; j < alpha.length; j++) {
                    if (s2.equals(alpha[j])) {
                        count++;
                        i++;
                        continue ppp;
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
